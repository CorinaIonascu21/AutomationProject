package Actions;

import WebElements.DashboardElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Dashboard {
    //trb facut un obiect care sa faca legatura cu elemetele de acolo
    private DashboardElements elements = null;
    private Wait<WebDriver> wait;

//cream un constructor unde parsam driverul mai departe
    public Dashboard(WebDriver driver){
        elements = new DashboardElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
//extagem textul
    public String getUserEmailFromDashBoard(){
        wait.until(d-> elements.userNameDisplay().isDisplayed());
        return  elements.userNameDisplay().getText();
    }

    public void clickTrainingButton(){
        wait.until(d-> elements.trainingButton().isDisplayed());
        elements.trainingButton().click();
    }
}
