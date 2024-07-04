package Actions;

import WebElements.AccountServicesElements;
import WebElements.OpenNewAccountElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class OpenNewAccount {
    private OpenNewAccountElement element = null;
    private Wait<WebDriver> wait;


    public OpenNewAccount(WebDriver driver) {
        this.element = new OpenNewAccountElement(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void clickOpenNewAccountLink() {
        element.clickOpenNewAccountLink().click();
    }

    public String getOpenNewAccountText() {
        return element.openNewAccountText().getText();
    }

    public void selectTypeOfAccount(String option) {
        element.findDropDownElement().selectByVisibleText(option);
    }

    public void selectExistedAccount(String option) {
        element.findDropDownExistedAccounts().selectByVisibleText(option);
    }

    public List<String> getSelectedOptionTypes() {
        List<WebElement> selectedElements = element.findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public List<String> selectExistedAccountToTransfer() {
        List<WebElement> selectTheExistedAccount = element.findDropDownExistedAccounts().getAllSelectedOptions();
        return selectTheExistedAccount.stream().map(e -> e.getText()).collect(Collectors.toList());
    }

    public void clickNewAccountButton() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        element.clickOpenNewAccountButton().click();
    }

    public String accountOpenedText() {
         wait.until(d -> element.accountOpenedText().isDisplayed());
        return element.accountOpenedText().getText();
    }

    public String accountNumberCreated() {
       return element.accountNumber().getText();
    }


}