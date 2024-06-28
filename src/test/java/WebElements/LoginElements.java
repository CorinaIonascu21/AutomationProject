package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {
    private WebDriver driver;
    public LoginElements(WebDriver driver) {
        this.driver = driver;

    }
    public WebElement registerButton() {
        return driver.findElement(By.className("register"));
    }
    public WebElement loginText() {
        return driver.findElement(By.xpath("//h2"));// h2 este un locator

    }
    public WebElement emailInput(){
        return driver.findElement(By.cssSelector("#userEmail"));
}
    public WebElement  passwordInput() {
    return driver.findElement(By.cssSelector("#userPassword"));
    }
    public WebElement  loginButtonInput() {
        return driver.findElement(By.id("submitButton"));
    }
    public WebElement errorForbiddenAccess() {
        return driver.findElement(By.cssSelector("errorForbiddenAccess"));
    }
}
