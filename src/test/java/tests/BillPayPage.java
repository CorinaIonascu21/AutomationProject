package tests;

import Actions.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class BillPayPage extends BaseTest {
    private Login login = null;
    private ConfigLoader configLoader;
    private BillPay billpay = null;

    @Test
    public void BillPayPage() {

        initTest("bill Page Parabank transaction");
        login = new Login(driver);
        billpay = new BillPay(driver);
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String userName = configLoader.getProperty("Username1");
        String password = configLoader.getProperty("Password1");

        login.enterUserName(userName);
        login.enterPassword(password);
        login.clickSubmitButton();
        billpay.clickBillPayButton();
        Assert.assertTrue(billpay.billPaymentServiceText().equalsIgnoreCase("Bill Payment Service"));
        billpay.billPayCompleteElements();
        Assert.assertTrue(billpay.getBillPaymentCompleteText().equalsIgnoreCase("Bill Payment Complete"));
    }

}

