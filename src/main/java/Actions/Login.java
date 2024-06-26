package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private LoginElements elements = null;

    public Login(WebDriver driver) {
        elements = new LoginElements(driver);

    }

    public void clickRegisterButton() {
        elements.registerButton().click();
    }

    public void setEmailInput(String email) {
        elements.emailInput().sendKeys(email);
    }

    public void setPasswordInput(String password) {
        elements.passwordInput().sendKeys(password);


    }
    public void setLoginButton() {
        elements.loginButtonInput().click();

    }
    }

