package Actions;

import WebElements.TransferFundsElements;
import WebElements.UpdateContactInfoElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;
import java.util.Objects;

public class UpdateContactInfo {
    private Wait<WebDriver> wait;
    public UpdateContactInfoElements element = null;
    private ConfigLoader configLoader;

    public UpdateContactInfo(WebDriver driver) {
        this.element = new UpdateContactInfoElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickUpdateContactInfoLink() {
        element.clickUpdateContactInfoLink().click();
    }
    public String getUpdateProfileText(){
        wait.until(d -> element.updateProfileText().isDisplayed());
        return element.updateProfileText().getText();
    }

    public void setFirstName(String firstName) {
        wait.until(d -> element.firstName().isDisplayed());
        element.firstName().sendKeys(firstName);
    }

    public void setLastName(String lastName) {
        element.lastName().sendKeys(lastName);
    }

    public void setAddress(String address) {
        element.address().sendKeys(address);
    }

    public void setCity(String city) {
        element.city().sendKeys(city);
    }

    public void setState(String state) {
        element.state().sendKeys(state);
    }

    public void setZipCode(String ZipCode) {
        element.zipCode().sendKeys(ZipCode);
    }

    public void setPhone(String phone) {
        element.phone().sendKeys(phone);
    }

    public String getFirstNameValue() {
        return  element.firstName().getAttribute("value");
    }
    public String getLastNameValue() {
        return  element.lastName().getAttribute("value");
    }
    public String getAddressValue() {
        return  element.address().getAttribute("value");
    }
    public String getCityValue() {
        return  element.city().getAttribute("value");
    }
    public String getStateValue() {
        return  element.state().getAttribute("value");
    }
    public String getZipCodeValue() {
        return  element.zipCode().getAttribute("value");
    }
    public String getPhoneValue() {
        return  element.phone().getAttribute("value");
    }

    public void waitUntilProfileDateLoaded(){
        wait.until(d -> !element.firstName().getAttribute("value").isEmpty());

    }
    public void clickUpdateProfileSubmitButton() {
        element.updateProfileSubmitButton().click();
    }
    public String getProfileUpdatedText(){
        wait.until(d -> element.profileUpdatedText().isDisplayed());
        return element.profileUpdatedText().getText();
    }
    public void clearProfileData(){
        this.waitUntilProfileDateLoaded();
        element.firstName().clear();
        element.lastName().clear();
        element.address().clear();
        element.city().clear();
        element.state().clear();
        element.zipCode().clear();
        element.phone().clear();
    }
    public void clearFirstNameElement() {
        this.waitUntilProfileDateLoaded();
        element.firstName().clear();
    }
    public void updateProfileElements() {
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String firstName = configLoader.getProperty("firstName");
        String lastName = configLoader.getProperty("LastName");
        String Address = configLoader.getProperty("Address");
        String City = configLoader.getProperty("City");
        String State = configLoader.getProperty("State");
        String ZipCode = configLoader.getProperty("ZipCode");
        String Phone = configLoader.getProperty("Phone");


        setFirstName(firstName);
        setLastName(lastName);//apelam metodele.actiunile
        setAddress(Address);
        setCity(City);
        setState(State);
        setZipCode(ZipCode);
        setPhone(Phone);
        clickUpdateProfileSubmitButton();

    }
}
