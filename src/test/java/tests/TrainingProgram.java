package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class TrainingProgram extends BaseTest {
    private Login login = null;
    private Dashboard dashboard = null;
    private Register register = null;
    private RegisterUser registerUser = null;
    private ConfigLoader configLoader;
    private Training training;

    @Test
    public void openTrainingTab() {
        initTest("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        training = new Training(driver);


        login();
    }

    private void login() {

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String Email = configLoader.getProperty("Email");
        String password = configLoader.getProperty("password");

        login.enterUserName(Email);
        login.enterPassword(password);
        login.clickSubmitButton();

        dashboard.clickTrainingButton();

        training.clickGenerateProgramButton();

    }
}


