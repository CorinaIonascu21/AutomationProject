package Actions;

import WebElements.TrainingElements;
import com.google.common.collect.Lists;
import org.bouncycastle.cms.bc.BcKeyTransRecipientInfoGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;


import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class Training {
    private TrainingElements elements = null;
    private Wait<WebDriver> wait;
    public WebDriver driver;
    private Actions builder;

    public Training(WebDriver driver) {
        elements = new TrainingElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        builder = new Actions(driver);
    }

    public void clickGenerateProgramButton() {
        wait.until(d -> elements.generateProgram().isDisplayed());
        elements.generateProgram().click();

    }

    public void dragAndDropTrainingProgram(String dayNumber, String trainingProgram) {
        wait.until(d -> elements.trainingPrograms().get(0).isDisplayed());
        Action dragAndDrop = builder.clickAndHold(getTrainingProgram(trainingProgram))
                .moveToElement(elements.weekDay(dayNumber))
                .release(elements.weekDay(dayNumber))
                .build();
        dragAndDrop.perform();
    }

    private WebElement getTrainingProgram(String trainingProgram) {
        for (WebElement element : elements.trainingPrograms()) {
            if (element.getText().equalsIgnoreCase(trainingProgram)) {
                return element;
            }
        }
        return null;
    }

    public String trainingProgramOnWeekday(String dayNumber,String trainingProgram) {
        for (WebElement element : elements.trainingProgramsOnWeekDay(dayNumber)) {
            if (element.getText().equalsIgnoreCase(trainingProgram)) {
                return element.getText();
            }
        }
        return null;

    }
}


