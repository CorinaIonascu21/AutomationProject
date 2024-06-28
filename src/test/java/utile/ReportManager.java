package utile;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ReportManager {
    private static ExtentReports extentReports;

    public static ExtentReports getInstance() {
        if (extentReports == null) {
            String reportName = "report/test-report.html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportName);//i se creaza un constructor custom-personalizat
            extentReports = new ExtentReports();//am creat obiectul de mai sus
            extentReports.attachReporter(sparkReporter);
        }
        return extentReports;
    }

    public static ExtentTest createTest(String testName) {
        return getInstance().createTest(testName);

    }
    public static void compileReport() {
         getInstance().flush();
    }
    }