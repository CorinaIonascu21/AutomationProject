package tests;

import Actions.AccountsOverview;
import Actions.Login;
import Actions.OpenNewAccount;
import Actions.Register;
import WebElements.UpdateContactInfoElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

import java.time.Duration;

import static org.testng.AssertJUnit.assertEquals;

public class OpenNewAccountPage extends BaseTest {
    private OpenNewAccount openNewAccount = null;
    private Register register = null;
    private Login login = null;
    private ConfigLoader configLoader;
    private Wait<WebDriver> wait;
    private AccountsOverview overview = null;

    @Test
    public void  OpenNewAccount() {
        initTest("Open new account");
        login = new Login(driver);
        openNewAccount = new OpenNewAccount(driver);
        register = new Register(driver);
        overview = new AccountsOverview(driver);
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        login.login();
        String accountText = overview.getAccountsOverviewText();
        Assert.assertTrue(accountText.equalsIgnoreCase("Accounts Overview"));

        /*login.clickRegisterButton();
        String dynamicUserName = register.getDynamicUsername();
        register.registerUser(dynamicUserName);*/
        openNewAccount.clickOpenNewAccountLink();
        String openAccount = openNewAccount.getOpenNewAccountText();
        Assert.assertTrue(openAccount.equalsIgnoreCase("Open New Account"));

        createNewAccount();

        String getAccountNumberCreated = openNewAccount.accountNumberCreated();
        overview.clickAccountsOverviewLink();
        String getAccountNumberOverview = overview.newAccountCreated();
        //Assert.assertTrue(getAccountNumberCreated.equalsIgnoreCase(getAccountNumberOverview));
        if (getAccountNumberCreated.equals(getAccountNumberOverview)){
            System.out.println("Text matched");
        }
        else{
            System.out.println("Text not matched");
        }
        }

    private void createNewAccount() {
        openNewAccount.selectTypeOfAccount("SAVINGS");
        var SelectedOption = openNewAccount.getSelectedOptionTypes();
        Assert.assertEquals(SelectedOption.size(), 1, "Incorrect number of selection!");
        Assert.assertTrue(SelectedOption.contains("SAVINGS"), "Option not selected");

        openNewAccount.selectExistedAccountToTransfer();
        /*var SelectedOptionAccount = openNewAccount.selectExistedAccountToTransfer();
        Assert.assertEquals(SelectedOptionAccount.size(), 1, "Incorrect number of selection!");
        Assert.assertTrue(SelectedOptionAccount.contains("20670"), "Option not selected");*/
        openNewAccount.clickNewAccountButton();
        String openAccountText = openNewAccount.accountOpenedText();
        Assert.assertTrue(openAccountText.equalsIgnoreCase("Account Opened!"));
    }
}

