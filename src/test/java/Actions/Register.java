package Actions;

import WebElements.RegisterElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Register {
    private RegisterElements elements = null;
    private Wait<WebDriver> wait;
    private ConfigLoader configLoader;

    public Register(WebDriver driver) { //constructorul clasei
        elements = new RegisterElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void setFirstName(String firstName) {
        wait.until(d -> elements.firstName().isDisplayed());
        elements.firstName().sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        elements.lasName().sendKeys(lastName);
    }

    public void setAddress(String address) {
        elements.address().sendKeys(address);
    }

    public void setCity(String city) {
        elements.city().sendKeys(city);
    }

    public void setState(String state) {
        elements.state().sendKeys(state);
    }

    public void setZipCode(String zipCode) {
        elements.zipCode().sendKeys(zipCode);
    }

    public void setPhoneNumber(String phoneNumber) {
        elements.phoneNumber().sendKeys(phoneNumber);

    }

    public void setSSN(String ssn) {
        elements.ssn().sendKeys(ssn);
    }

    public void setUserName(String username) {
        elements.userName().sendKeys(username);
    }

    public void setPassword(String pass) {
        elements.password().sendKeys(pass);
    }

    public void setConfirmPassword(String password) {
        elements.confirm().sendKeys(password);
    }

    public void clickRegisterButton() {
        elements.registerButton().click();
    }

    public String getSingUpText() {
        return elements.singUpText().getText();
    }
    public String getRegisterUserSuccessText() {
        wait.until(d -> elements.registerUserSuccessText().isDisplayed());
        return elements.registerUserSuccessText().getText();
    }
    public String getDynamicUsername(){
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String Username = configLoader.getProperty("Username");
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("HHmmss");
        LocalDateTime now= LocalDateTime.now();
        return Username + dtf.format(now);
    }
    public void registerUser(String Username) {
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String firstName = configLoader.getProperty("firstName");
        String LastName = configLoader.getProperty("LastName");
        String Address = configLoader.getProperty("Address");
        String City = configLoader.getProperty("City");
        String State = configLoader.getProperty("State");
        String ZipCode = configLoader.getProperty("ZipCode");
        String Phone = configLoader.getProperty("Phone");
        String SSN = configLoader.getProperty("SSN");
        String Password = configLoader.getProperty("Password");
        String ConfirmPassword = configLoader.getProperty("ConfirmPassword");

        setFirstName(firstName);//apelam metodele.actiunile
        setLastName(LastName);
        setAddress(Address);
        setCity(City);
        setState(State);
        setZipCode(ZipCode);
        setPhoneNumber(Phone);
        setSSN(SSN);
        setUserName(Username);
        setPassword(Password);
        setConfirmPassword(ConfirmPassword);
        clickRegisterButton();
    }


}