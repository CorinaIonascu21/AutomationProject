package Actions;

import WebElements.DashboardElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Dashboard {
    //trb facut un obiect care sa faca legatura cu elemetele de acolo
    private DashboardElements elements = null;
    private Wait<WebDriver> wait;
    public WebDriver driver;

    //cream un constructor unde parsam driverul mai departe
    public Dashboard(WebDriver driver) {
        elements = new DashboardElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //extagem textul
    public String getUserEmailFromDashBoard() {
        wait.until(d -> elements.userNameDisplay().isDisplayed());
        return elements.userNameDisplay().getText();
    }

    public void clickTrainingButton() {
        wait.until(d -> elements.trainingButton().isDisplayed());
        elements.trainingButton().click();
    }

    public void clickOn23Day() {
        wait.until(d -> elements.clickOn23().isDisplayed());
        elements.clickOn23().click();
    }

    public String getTextAddAnewElement() {
        return elements.getTextAddAnewElement().getText();
    }

    public void addAnewElement(String p) {
        elements.addAnewElement().sendKeys(p);
    }

    public void createEventSubmit() {
        elements.createEventSubmit().click();

    }

    public void clickSpecificDay(String date) {
        for (WebElement element : elements.calendarDays()) {
            if (element.getAttribute("data-date").equals(date)) {
                element.click();
            }
        }
    }

    public void sendEventText(String eventText) {
        wait.until(d -> elements.eventTitle().isDisplayed());
        elements.eventTitle().sendKeys(eventText);
    }

    public void clickCreateEventButton() {

        elements.createEventButton().click();
    }

    public boolean isEventPresent(String event) {
        wait.until(d -> !elements.events().get(0).isDisplayed());
        for (WebElement element : elements.events()) {
            if (element.getText().equalsIgnoreCase(event)) {
                return true;
            }
        }
        return false;
    }
}


