package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;

public class Register {
    private RegisterElements elements = null;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader;

    public Register(WebDriver driver) { //constructorul clasei
        elements = new RegisterElements(driver);
    }

    public String getSingUpText() {
        return elements.singUpText().getText();
    }

    public void setFirstName(String firstName) {
        wait.until(d-> elements.firstName().isDisplayed());
        elements.firstName().sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        elements.lasName().sendKeys(lastName);
    }

    public void setPhoneNumber(String phoneNumber) {
        elements.phoneNumber().sendKeys(phoneNumber);
    }

    public void setEmail(String email) {
        elements.email().sendKeys(email);
    }

    public void city(String city) {
        elements.city().sendKeys(city);
    }

    public void password(String password) {
        elements.password().sendKeys(password);
    }

    public void customer() {
        elements.customer().click();

    }

    public void trainer() {
        elements.trainer().click();
    }

    public void submit() {
        elements.submit().click();
    }

    public void registerUser(boolean isTrainer){
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUserCalendar.properties");
        String firstName = configLoader.getProperty("firstName");
        String LastName = configLoader.getProperty("LastName");
       String Email = configLoader.getProperty("Email");
       String PhoneNumber = configLoader.getProperty("PhoneNumber");
        String password = configLoader.getProperty("password");
        String city = configLoader.getProperty("city");


        setFirstName(firstName);//apelam metodele.actiunile
        setLastName(LastName);
        setEmail(Email);
        setPhoneNumber(PhoneNumber);
       password(password);
       city(city);
        if (isTrainer) {
            trainer();
        } else {

            customer();
        }
        submit();
    }


    public void waitForElement(WebDriver driver ,  String selector) {
        // Get error text
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));

        wait.until(d -> {
            WebElement e = d.findElement(By.className(selector));
            e.isDisplayed();
            return true;
        });
    }
    }