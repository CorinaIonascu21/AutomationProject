package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterElements {
    private WebDriver driver = null;

    public RegisterElements(WebDriver driver) {
        this.driver = driver;

    }


    public WebElement firstName() {
        return driver.findElement(By.id("customer.firstName"));
    }

    public WebElement lasName() {
        return driver.findElement(By.id("customer.lastName"));
    }

    public WebElement address() {
        return driver.findElement(By.id("customer.address.street"));
    }
    public WebElement city() {
        return driver.findElement(By.id("customer.address.city"));
    }

    public WebElement state() {
        return driver.findElement(By.id("customer.address.state"));
    }

    public WebElement zipCode() {
        return driver.findElement(By.id("customer.address.zipCode"));
    }


    public WebElement phoneNumber() {
        return driver.findElement(By.id("customer.phoneNumber"));

    }

    public WebElement ssn() {
        return driver.findElement(By.id("customer.ssn"));
    }

    public WebElement userName() {
        return driver.findElement(By.id("customer.username"));
    }
    public WebElement password() {
        return driver.findElement(By.id("customer.password"));
    }
    public WebElement confirm() {
        return driver.findElement(By.id("repeatedPassword"));
    }
    public WebElement registerButton() {
        return driver.findElement(By.xpath("//*[@id=\"customerForm\"]/table/tbody/tr[13]/td[2]/input"));
    }
    public WebElement singUpText(){
        return driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1"));
    }
    public WebElement registerUserSuccessText(){
        return driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p"));
    }
}
