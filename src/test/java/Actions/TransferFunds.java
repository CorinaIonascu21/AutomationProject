package Actions;

import WebElements.LoginElements;
import WebElements.TransferFundsElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utile.ConfigLoader;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class TransferFunds {
    private Wait<WebDriver> wait;
    public TransferFundsElements element = null;
    private ConfigLoader configLoader;

    public TransferFunds(WebDriver driver) {
        this.element = new TransferFundsElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickTransferFundsButton() {
        element.clickTransferFundsButton().click();
    }

    public String getTransferFundsText() {
       return element.transferFundsText().getText();
    }
    public void getAmountValueTransfer(){

        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");
        String amount = configLoader.getProperty("Amount");
        wait.until(d -> element.amountValueTransfer().isDisplayed());
        element.amountValueTransfer().sendKeys(amount);
    }
    public void getTransferAmountButton(){
        wait.until(d -> element.amountValueTransfer().isDisplayed());
        element.transferAmountButton().click();
    }
    public String getTransferAmountSuccess(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
       return element.transferAmountSuccess().getText();

    }
    public void selectFromAccount(String option) {
        element.findDropDownFromAccountElement().selectByVisibleText(option);
    }
    public void selectToAccount(String option) {
        element.findDropDownToAccountElement().selectByVisibleText(option);
    }

    public List<String> getFromAccountTypes() {
        wait.until(d -> element.findDropDownFromAccountElement().getOptions().size() > 1);

        List<WebElement> selectedElements = element.findDropDownFromAccountElement().getOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

}


