package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class Dashboard extends BaseTest {
    private Login login = null;
    private Actions.Dashboard dashboard = null;
    private Register register = null;
    private ConfigLoader configLoader;
    @Test
    public void createNewEventElement() {

        initTest("create first events element");
        login = new Login(driver);
        dashboard = new Actions.Dashboard(driver);
        register = new Register(driver);

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserCalendar.properties");
        String Email = configLoader.getProperty("Email");
        String password = configLoader.getProperty("password");

        login.enterUserName(Email);
        login.enterPassword(password);
        login.clickSubmitButton();

        dashboard.clickOn23Day();
        Assert.assertTrue(dashboard.getTextAddAnewElement().equalsIgnoreCase("Add a new event"));
        dashboard.addAnewElement("Abdomen");
        dashboard.createEventSubmit();
    }
    }
