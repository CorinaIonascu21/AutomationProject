package tests;

import Actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class MainMenuNavigation extends BaseTest {

    private Login login = null;
    private OpenNewAccount openNewAccount = null;
    private AccountsOverview overview = null;
    private ConfigLoader configLoader;
    private BillPay billpay = null;
    private Register register = null;
    private TransferFunds transfer = null;
    private UpdateContactInfo updateContactInfo = null;
    private AccountServices accountServices = null;

    @Test
    public void MainMenuNavigationSuccess() {

        initTest("Main menu navigation through all the links/items");
        login = new Login(driver);
        overview = new AccountsOverview(driver);
        register = new Register(driver);
        overview = new AccountsOverview(driver);
        transfer = new TransferFunds(driver);
        updateContactInfo = new UpdateContactInfo(driver);
        billpay = new BillPay(driver);
        accountServices = new AccountServices(driver);
        openNewAccount = new OpenNewAccount(driver);
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");


        /*login.login()
        String accountText = overview.getAccountsOverviewText();
        Assert.assertTrue(accountText.equalsIgnoreCase("Accounts Overview"));  */

        login.clickRegisterButton();
        String dynamicUserName = register.getDynamicUsername();
        register.registerUser(dynamicUserName);

        //navighez prin meniul de update contact info
        updateContactInfo.clickUpdateContactInfoLink();
        Assert.assertTrue(updateContactInfo.getUpdateProfileText().equalsIgnoreCase("Update Profile"));

        //navigare prin meniul de Transfer Funds
        transfer.clickTransferFundsButton();
        String transferFundsText=transfer.getTransferFundsText();
        Assert.assertTrue(transferFundsText.equalsIgnoreCase("Transfer Funds"));

        //navigare prin Bill Pay
        billpay.clickBillPayButton();
        Assert.assertTrue(billpay.billPaymentServiceText().equalsIgnoreCase("Bill Payment Service"));

        //navigare prin meniul Accounts overview
        overview.clickAccountsOverviewLink();
        String accountText = overview.getAccountsOverviewText();
        Assert.assertTrue(accountText.equalsIgnoreCase("Accounts Overview"));


        //navigare prin meniul find transactions
        accountServices.clickFindTransactionsLink();
        String findTransaction = accountServices.getFindTransactionsText();
        Assert.assertTrue(findTransaction.equalsIgnoreCase("Find Transactions"));


        //navigare prin meniul Request loan
        accountServices.clickRequestLoanLink();
        String requestLoan = accountServices.getApplyForALoanText();
        Assert.assertTrue(requestLoan.equalsIgnoreCase("Apply for a Loan"));

        //navigare prin meniul open new account
        openNewAccount.clickOpenNewAccountLink();
        String openAccount = openNewAccount.getOpenNewAccountText();
        Assert.assertTrue(openAccount.equalsIgnoreCase("Open New Account"));
}
}
