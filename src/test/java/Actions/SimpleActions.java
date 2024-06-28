package Actions;

import WebElements.SimpleElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SimpleActions {
    //trb sa legam cele 2 clase,trb facut o instanta aici
    private SimpleElements elements;

//trb facut si aici un constructor pt clasa action
    public SimpleActions(WebDriver driver) {
        this.elements= new SimpleElements(driver);
    }

    //metoda ce extrage textul apeland metoda de dincolo
    public String getLoginText(){
        return elements.loginText().getText();
    }
    public WebElement getLoginButton() {
        return elements.loginButton();
    }
    public WebElement getEmailField() {
        return elements.emailInput();
    }
    public WebElement getPasswordField() {
        return elements.passwordInput();
    }
    public WebElement getLoginErrorMessage() {
        return elements.loginErrorMessage();

    }
    public void waitForElement(WebDriver driver, String selector) {
        // Get error text
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(d -> {
            WebElement e = d.findElement(By.className(selector));
            e.isDisplayed();
            return true;
        });


    }
    // login
    public WebElement getUserNameText(){
        return elements.userNameAfterLogin();
    }

}



