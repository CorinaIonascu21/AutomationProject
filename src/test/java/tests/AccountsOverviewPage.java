package tests;

import Actions.*;
import WebElements.AccountDetailsTransactions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.time.Duration;

public class AccountsOverviewPage extends BaseTest {
    private OpenNewAccount openNewAccount = null;
    private Register register = null;
    private Login login = null;
    private ConfigLoader configLoader;
    private Wait<WebDriver> wait;
    private AccountsOverview overview = null;
    private AccountDetails accountDetails = null;

    @Test
    public void AccountOverviewElement() {
        initTest("Verified account displayed");
        login = new Login(driver);
        openNewAccount = new OpenNewAccount(driver);
        register = new Register(driver);
        overview = new AccountsOverview(driver);
        accountDetails = new AccountDetails(driver);
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login.login();
        String accountText = overview.getAccountsOverviewText();
        Assert.assertTrue(accountText.equalsIgnoreCase("Accounts Overview"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        overview.clickFirstAccountElement();
        String accountDetailsText = accountDetails.getAccountDetailsText();
        Assert.assertTrue(accountDetailsText.equalsIgnoreCase("Account Details"));
        System.out.println("here are all the transactions ");

    }

}
