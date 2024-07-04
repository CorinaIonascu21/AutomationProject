package tests;


import Actions.Login;
import Actions.AccountsOverview;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;


public class LoginPage extends BaseTest {

    private Login login = null;
    private AccountsOverview overview = null;
    private ConfigLoader configLoader;

    @Test
    public void loginParabankSuccess() {
        //String username = corina + time

        initTest("Login Page Parabank Success");
        login = new Login(driver);
        overview= new AccountsOverview(driver);

        login.login();

        String accountText = overview.getAccountsOverviewText();
        Assert.assertTrue(accountText.equalsIgnoreCase("Accounts Overview"));
    }

    @Test
    public void loginParabankFail() {

        initTest("Login Page Parabank Fail");
        login = new Login(driver);
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String userName = configLoader.getProperty("Username");
        String password = configLoader.getProperty("Password");

        login.enterUserName(userName);
        login.enterPassword(password);
        login.clickSubmitButton();

        String errorLoginText = login.getErrorLoginText();
        Assert.assertTrue(errorLoginText.equalsIgnoreCase("Error!"));


    }
    @Test
    public void logOutParabank(){
        initTest("Logout Page Parabank");
        login = new Login(driver);
        overview = new AccountsOverview(driver);

        String signInTitle = login.getSignInTitle();
        Assert.assertTrue(signInTitle.equalsIgnoreCase("Customer Login"));
        login.login();
        String accountText = overview.getAccountsOverviewText();
        Assert.assertTrue(accountText.equalsIgnoreCase("Accounts Overview"));
        login.clickLogoutButton();
        String signOutText = login.getSignOutTitle();
        Assert.assertTrue(signOutText.equalsIgnoreCase("Customer Login"));
    }
}
