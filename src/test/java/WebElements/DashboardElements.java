package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class DashboardElements {
    private WebDriver driver = null;
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    public DashboardElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement userNameDisplay() {
        return driver.findElement(By.cssSelector("#userNameDisplay"));
    }

    public WebElement trainingButton() {

        return driver.findElement(By.cssSelector(".trainings"));
    }

    public WebElement clickOn23() {
        return driver.findElement(By.id("fc-dom-48"));
    }

    public WebElement addAnewElement() {
        return driver.findElement(By.xpath("//*[@id=\"eventTitle\"]"));
    }

    public WebElement createEventSubmit() {
        return driver.findElement(By.xpath("//*[@id=\"createEventButton\"]"));
    }

    public WebElement getTextAddAnewElement() {
        return driver.findElement(By.xpath("//*[@id=\"createEvent\"]/div/div/h1"));
    }

    public List<WebElement> calendarDays() {
        return driver.findElements(By.cssSelector(".fc-daygrid-day"));
    }

    public WebElement eventTitle() {
        return driver.findElement(By.cssSelector("#eventTitle"));
    }

    public WebElement createEventButton() {
        return driver.findElement(By.cssSelector("#createEventButton"));
    }

    public List<WebElement> events() {
        return driver.findElements(By.cssSelector(".fc-event"));
    }
}