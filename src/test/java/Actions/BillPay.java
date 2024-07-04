package Actions;

import WebElements.BillPayElements;
import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.BaseTest;
import utile.ConfigLoader;

import java.time.Duration;

public class BillPay {
    private BillPayElements element = null;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader;

    public BillPay(WebDriver driver) {
        this.element = new BillPayElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickBillPayButton() {
        element.clickBillPayButton().click();
    }

    public String billPaymentServiceText() {
        wait.until(d -> element.billPaymentServiceText().isDisplayed());
        return element.billPaymentServiceText().getText();
    }

    public void setPayeeName(String payeeName) {
        wait.until(d -> element.payeeName().isDisplayed());
        element.payeeName().sendKeys(payeeName);
    }

    public void setAddress(String address) {
        element.address().sendKeys(address);
    }

    public void setCity(String city) {
        element.city().sendKeys(city);
    }

    public void setState(String state) {
        element.state().sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        element.zipCode().sendKeys(zipCode);
    }

    public void setPhone(String Phone) {
        element.phone().sendKeys(Phone);
    }

    public void setAccount(String Account) {
        element.account().sendKeys(Account);
    }

    public void setVerifyAccount(String VerifyAccount) {
        element.verifyAccount().sendKeys(VerifyAccount);
    }

    public void setAmount(String Amount) {
        element.amount().sendKeys(Amount);
    }

    public void clickSendPaymentButton() {
        element.clickSendPayment().click();
    }

    public String getBillPaymentCompleteText() {
        wait.until(d -> element.billPaymentCompleteText().isDisplayed());
        return element.billPaymentCompleteText().getText();
    }

    public void billPayCompleteElements() {
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String PayeeName = configLoader.getProperty("PayeeName");
        String Address = configLoader.getProperty("Address");
        String City = configLoader.getProperty("City");
        String State = configLoader.getProperty("State");
        String ZipCode = configLoader.getProperty("ZipCode");
        String Phone = configLoader.getProperty("Phone");
        String Account = configLoader.getProperty("Account");
        String VerifyAccount = configLoader.getProperty("VerifyAccount");
        String Amount = configLoader.getProperty("Amount");


        setPayeeName(PayeeName);//apelam metodele.actiunile
        setAddress(Address);
        setCity(City);
        setState(State);
        setZipCode(ZipCode);
        setPhone(Phone);
        setAccount(Account);
        setAmount(Amount);
        setVerifyAccount(VerifyAccount);
        setAmount(Amount);
        clickSendPaymentButton();
        //account pentru test 21 este 13455
    }
}
