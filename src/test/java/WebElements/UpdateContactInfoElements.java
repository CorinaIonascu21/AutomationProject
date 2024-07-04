package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UpdateContactInfoElements {
    private WebDriver driver;

    public UpdateContactInfoElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickUpdateContactInfoLink() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[6]/a"));
    }
    public WebElement updateProfileText() {
        return driver.findElement(By.xpath("//*[@id=\"updateProfileForm\"]/h1"));
    }
    public WebElement firstName() {
        return driver.findElement(By.id("customer.firstName"));
    }
    public WebElement lastName() {
        return driver.findElement(By.id("customer.lastName"));
    }
    public WebElement address() {
        return driver.findElement(By.id("customer.address.street"));
    }
    public WebElement city() {
        return driver.findElement(By.id("customer.address.city"));
    }
    public WebElement state(){
        return driver.findElement(By.id("customer.address.state"));
    }
    public WebElement zipCode(){
        return driver.findElement(By.id("customer.address.zipCode"));
    }
    public WebElement phone(){
        return driver.findElement(By.id("customer.phoneNumber"));
    }
    public WebElement updateProfileSubmitButton(){
        return driver.findElement(By.xpath("//*[@id=\"updateProfileForm\"]/form/table/tbody/tr[8]/td[2]/input"));
    }
    public WebElement profileUpdatedText() {
        return driver.findElement(By.xpath("//*[@id=\"updateProfileResult\"]/h1"));
    }

}
