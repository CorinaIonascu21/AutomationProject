package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;
import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;

import java.util.List;

public class DragAndDropEvent extends BaseTest {
    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private ConfigLoader configLoader;

    @Test
    public void DragAndDrop() {

        initTest("take the firts element and move it to other day");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserCalendar.properties");
        String Email = configLoader.getProperty("Email");
        String password = configLoader.getProperty("password");

        login.enterUserName(Email);
        login.enterPassword(password);
        login.clickSubmitButton();

        try {

            Thread.sleep(1000);
            List<WebElement> elements = driver.findElements(By.xpath("/html/body/app-root/app-dashboard/div/div[2]/full-calendar/div[2]/div/table/tbody/tr/td/div/div/div/table/tbody/tr[4]/td[3]/div/div[2]/div[2]"));
            WebElement firstElement = elements.get(0);
            //Element on which need to drop.
            WebElement To = driver.findElement(By.id("fc-dom-52"));

            //Using Action class for drag and drop.
            Actions act = new Actions(driver);

            //Dragged and dropped.
            act.clickAndHold(firstElement).moveToElement(To).release().perform();
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
