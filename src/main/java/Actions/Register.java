package Actions;

import WebElements.LoginElements;
import WebElements.RegisterElements;
import org.openqa.selenium.WebDriver;

public class Register {
    private RegisterElements elements = null;

    public Register(WebDriver driver) {
        elements = new RegisterElements(driver);
    }

    public String getSingUpText() {
        return elements.singUpText().getText();
    }

    public void setFirstName(String firstName) {
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
    public void city (String city){
        elements.city().sendKeys(city);
    }
   public  void password(String password){
        elements.password().sendKeys(password);
   }
   public void customer(){
        elements.customer().click();


   }
    public void submit(){
        elements.submit().click();
    }
}