package Actions;

import WebElements.LoginElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class Login {
    private LoginElements element = null;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader;

    public Login(WebDriver driver) {
        this.element = new LoginElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public void clickRegisterButton() {
        element.clickRegisterButton().click();
    }
    public void clickLogoutButton() {
        element.clickLogoutButton().click();
    }
    public String getSignInTitle() {
        return element.signInTitle().getText();
    }
    public void enterUserName(String name) {

        element.userName().sendKeys(name);
    }

    public void enterPassword(String password) {
        element.passwordInput().sendKeys(password);
    }

    public void clickSubmitButton() {
        element.loginButtonInput().click();
    }
    public void login(){
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        wait.until(d -> element.loginButtonInput().isDisplayed());
        String userName = configLoader.getProperty("Username1");
        String password = configLoader.getProperty("Password1");
        this.enterUserName(userName);
        this.enterPassword(password);
        this.clickSubmitButton();
    }
    public String getErrorLoginText(){
        return element.errorLoginText().getText();
    }
    public String getSignOutTitle(){
        return element.signOutTitle().getText();
    }

   /* public boolean errorForbiddenAccessText() {
try {
    wait.until(d -> element.errorForbiddenAccess().isDisplayed());

    return element.errorForbiddenAccess().isDisplayed();

}catch(Exception e){
    return false;
}
    }*/
}



