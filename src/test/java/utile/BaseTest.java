package utile;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;


public class BaseTest {
    public WebDriver driver;//aici e null, driver e un obiect dintr-o clasa
    private ExtentTest extentTest;
    private ScreenshotUtils screenshotUtils;

    @BeforeClass//inainte sa fie rulata o clasa din proiect intra in metoda asta si face initializarile
    public void setupClass() {
        WebDriverManager.chromedriver().setup();//am facut instanta de wbdrivermanager,
        //se numeste apelare in cascada
        // apelare pentru o clasa statica si apeleaza 2 metode

        driver = new ChromeDriver();//apelam instanta. iar aici driver devine true si dupa cand intra in if trb sa inchida
        screenshotUtils = new ScreenshotUtils(driver);
        driver.get("http://apptest.go.ro:9999/login");
    }

    @AfterClass
   public void tearDown() {//facem o alta metoda care sa inchida mereu dupa noi
        if (driver != null) {
driver.quit();
        }
   }

    @AfterMethod
    public void afterMethod(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            captureAndSaveFailureScreenshot(result.getMethod().getMethodName());
        }
        if (result.getStatus() == ITestResult.FAILURE) {
            extentTest.log(Status.FAIL, MarkupHelper.createLabel("Test case Failed: " + result.getName(), ExtentColor.RED));
            extentTest.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            extentTest.log(Status.PASS, MarkupHelper.createLabel("Test case Passed: " + result.getName(), ExtentColor.GREEN));
        } else {
            extentTest.log(Status.SKIP, MarkupHelper.createLabel("Test case Skipped: " + result.getName(), ExtentColor.YELLOW));

        }
    }

    @AfterSuite
    public void compileReport() {
        ReportManager.getInstance().flush();
    }

    public void initTest(String testName) {
        extentTest = ReportManager.createTest(testName);
    }

    private void captureAndSaveFailureScreenshot(String testName) throws IOException {
        //trb creat un folder nou  ca sa pastram toate pozele
        File screenshotDirectory = new File("Screenshots");
        if (!screenshotDirectory.exists()) {
            screenshotDirectory.mkdir();
        }

        //capture and save screenshot
        screenshotUtils.captureAndSaveScreenshots(testName);

    }


}
