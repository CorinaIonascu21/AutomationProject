package tests;
import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import com.fasterxml.jackson.databind.ser.Serializers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.util.List;

public class TrainingDragAndDrop extends BaseTest {
    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;
    private ConfigLoader configLoader;
    private Training training;

    @Test
    public void DragAndDrop () {
        initTest("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        training = new Training(driver);


        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserCalendar.properties");
        String Email = configLoader.getProperty("Email");
        String password = configLoader.getProperty("password");

        login.enterUserName(Email);
        login.enterPassword(password);
        login.clickSubmitButton();

        dashboard.clickTrainingButton();

        training.clickGenerateProgramButton();

        try {

            Thread.sleep(1000);
            List<WebElement> elements = driver.findElements(By.xpath("//*[@id=\"cdk-drop-list-0\"]/div[1]"));
            WebElement firstElement = elements.get(0);
            //Element on which need to drop.
            WebElement To = driver.findElement(By.xpath("//*[@id=\"cdk-drop-list-1\"]"));

            //Using Action class for drag and drop.
            Actions act = new Actions(driver);

            //Dragged and dropped.
            act.clickAndHold(firstElement).moveToElement(To).release().perform();

            Thread.sleep(1000);

        }catch(Exception e){
            e.printStackTrace();
        }finally{
          // driver.quit();
        }

    }
}
