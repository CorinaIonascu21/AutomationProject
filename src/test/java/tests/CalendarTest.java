package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;


public class CalendarTest extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;
    private ConfigLoader configLoader;
    private ConfigLoader configLoaderDate;
    private Training training;
    private String email = "";
    private String parola = "";

    @Test
    public void openDashboard() {
        initTest("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        training = new Training(driver);


        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserCalendar.properties");
        configLoaderDate = new ConfigLoader("src/test/resources/proprietati/dateData.properties");

        email = configLoader.getProperty("Email");
        parola = configLoader.getProperty("password");

        login();
        dashboard.clickSpecificDay(configLoaderDate.getProperty("date"));
        dashboard.sendEventText(configLoaderDate.getProperty("eventText"));
        dashboard.clickCreateEventButton();
        Assert.assertTrue(dashboard.isEventPresent(configLoaderDate.getProperty("eventText")));
    }

    private void login() {

        loginActions(email, parola);

        if (login.errorForbiddenAccessText()) {
            login.clickRegisterButton();
            register.registerUser(true);

            loginActions(email, parola);
        }
        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase(email));

    }

    private void loginActions(String email, String parola) {
        login.enterUserName(email);
        login.enterPassword(parola);
        login.clickSubmitButton();
    }
}




