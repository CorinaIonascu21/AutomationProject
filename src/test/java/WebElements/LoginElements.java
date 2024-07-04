package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginElements {
    private WebDriver driver;
    public LoginElements(WebDriver driver) {
        this.driver = driver;

    }
   public WebElement clickRegisterButton() {
       return driver.findElement(By.xpath("//*[@id=\"loginPanel\"]/p[2]/a"));

    }
    public WebElement signInTitle() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/h2\n"));
    }
    public WebElement clickLogoutButton() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a"));
    }
    public WebElement userName(){
        return driver.findElement(By.name("username"));
}
    public WebElement  passwordInput() {
    return driver.findElement(By.name("password"));
    }
    public WebElement  loginButtonInput() {
        return driver.findElement(By.cssSelector("input[type='submit']"));
    }
   public WebElement errorLoginText() {
        return driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/h1"));
    }
    public WebElement signOutTitle(){
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/h2"));
    }
}
