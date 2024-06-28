package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class LoginTrainer extends BaseTest {

    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private ConfigLoader configLoader;
    @Test
    public void loginTrainer() {

        initTest("Login trainer");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String Email = configLoader.getProperty("Email");
        String password = configLoader.getProperty("password");

        login.enterUserName(Email);
        login.enterPassword(password);
        login.clickSubmitButton();

        if (login.errorForbiddenAccessText()) {
            login.clickRegisterButton();
            register.registerUser(true);
        }



        Assert.assertTrue(dashboard.getUserEmailFromDashBoard().equalsIgnoreCase(Email));
    }
}
