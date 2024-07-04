package tests;

import Actions.*;
import WebElements.AccountDetailsTransactions;
import WebElements.OpenNewAccountElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class TransferFundsPage extends BaseTest {
    private Login login = null;
    private Register register = null;
    private AccountsOverview overview = null;
    private TransferFunds transfer = null;
    private OpenNewAccount openNewAccount = null;
    private AccountDetails accountDetails = null;

    @Test
    public void transferFunds() {
        initTest("Transfer of Funds between accounts! ");
        login = new Login(driver);
        register = new Register(driver);
        overview = new AccountsOverview(driver);
        transfer = new TransferFunds(driver);
        openNewAccount = new OpenNewAccount(driver);
        accountDetails = new AccountDetails(driver);

        String signInTile = login.getSignInTitle();
        Assert.assertTrue(signInTile.equalsIgnoreCase("Customer Login"));
        login.login();
        String accountText = overview.getAccountsOverviewText();
        Assert.assertTrue(accountText.equalsIgnoreCase("Accounts Overview"));

        openNewAccount.clickOpenNewAccountLink();
        openNewAccount.clickNewAccountButton();

        transfer.clickTransferFundsButton();
        String transferFundsText = transfer.getTransferFundsText();
        Assert.assertTrue(transferFundsText.equalsIgnoreCase("Transfer Funds"));
        transfer.getAmountValueTransfer();

        var SelectedOption = transfer.getFromAccountTypes();

        transfer.selectFromAccount(SelectedOption.get(0));
        transfer.selectToAccount(SelectedOption.get(1));

        transfer.getTransferAmountButton();
        String transferAmountSuccess = transfer.getTransferAmountSuccess();
        Assert.assertTrue(transferAmountSuccess.equalsIgnoreCase("Transfer Complete!"));
        overview.clickAccountsOverviewLink();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        overview.clickFirstAccountElement();

        String getLastTransactionCreated = accountDetails.lastElement();

        String getAccountNumber =  accountDetails.newTransactionCreated();
        //Assert.assertTrue(getAccountNumberCreated.equalsIgnoreCase(getAccountNumberOverview));
        if (getLastTransactionCreated.equals(getAccountNumber)){
            System.out.println("transfer display");
        }
        else{
            System.out.println("transfer is  not display");
        }

    }

}
