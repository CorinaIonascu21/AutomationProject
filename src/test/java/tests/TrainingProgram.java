package tests;

import Actions.Dashboard;
import Actions.Login;
import Actions.Register;
import Actions.Training;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
    private String email = "";
    private String parola = "";

    @Test
    public void openTrainingTab() {
        initTest("Training Program");
        login = new Login(driver);
        dashboard = new Dashboard(driver);
        register = new Register(driver);
        registerUser = new RegisterUser();
        training = new Training(driver);

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserCalendar.properties");
        email = configLoader.getProperty("Email");
        parola = configLoader.getProperty("password");


        login();

        dashboard.clickTrainingButton();

        training.clickGenerateProgramButton();


        training.dragAndDropTrainingProgram(configLoader.getProperty("weekDay"),
                configLoader.getProperty("trainingProgram"));

Assert.assertTrue(training.trainingProgramOnWeekday(configLoader.getProperty("weekDay") ,"legs").
        equalsIgnoreCase("legs"));

    }

    private void login() {

        loginActions(email,parola);

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


