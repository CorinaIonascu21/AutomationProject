package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BillPayElements {
    private WebDriver driver;

    public BillPayElements(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement clickBillPayButton() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[4]/a"));
    }

    public WebElement billPaymentServiceText() {
        return driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/h1"));
    }

    public WebElement payeeName() {
        return driver.findElement(By.name("payee.name"));
    }

    public WebElement address() {
        return driver.findElement(By.name("payee.address.street"));
    }

    public WebElement city() {
        return driver.findElement(By.name("payee.address.city"));
    }

    public WebElement state() {
        return driver.findElement(By.name("payee.address.state"));
    }

    public WebElement zipCode() {
        return driver.findElement(By.name("payee.address.zipCode"));
    }

    public WebElement phone() {
        return driver.findElement(By.name("payee.phoneNumber"));
    }

    public WebElement account() {
        return driver.findElement(By.name("payee.accountNumber"));
    }

    public WebElement verifyAccount() {
        return driver.findElement(By.name("verifyAccount"));
    }

    public WebElement amount() {
        return driver.findElement(By.name("amount"));


    }

    public WebElement clickSendPayment() {
        return driver.findElement(By.xpath("//*[@id=\"billpayForm\"]/form/table/tbody/tr[14]/td[2]/input"));
    }

    public WebElement billPaymentCompleteText() {
        return driver.findElement(By.xpath("//*[@id=\"billpayResult\"]/h1"));
    }
}

