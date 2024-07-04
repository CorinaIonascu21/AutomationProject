package Actions;

import WebElements.AccountsOverviewElements;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static io.opentelemetry.sdk.metrics.internal.data.EmptyExponentialHistogramBuckets.get;

public class AccountsOverview {
    //trb facut un obiect care sa faca legatura cu elemetele de acolo
    private AccountsOverviewElements elements = null;
    private Wait<WebDriver> wait;

    //cream un constructor unde parsam driverul mai departe
    public AccountsOverview(WebDriver driver) {
        elements = new AccountsOverviewElements(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //extagem textul
    public String getAccountsOverviewText() {
        wait.until(d -> elements.accountsOverviewText().isDisplayed());
        return elements.accountsOverviewText().getText();
    }
    public void clickAccountsOverviewLink(){
        elements.clickAccountsOverviewLink().click();
    }
    public String getBalanceByAccountId(String accountId) {
       List<WebElement> rows = elements.accountOverviewTableRows();
       for(WebElement row: rows) {
           List<WebElement> cell = row.findElements(By.tagName("td"));
           if(cell.size()>1) {
               String cellAccountId = cell.get(0).findElement(By.tagName("a")).getText();
               if(cellAccountId.equals(accountId)) {
                  return cell.get(1).getText();
               }
           }
       }
        return null;
    }
    public String newAccountCreated(){
        wait.until(d -> elements.accountOverviewTableRows().size() > 1);

        return elements.newAccountCreated().getText();
    }
    public void clickFirstAccountElement(){
         elements.clickFirstAccountElement().click();
    }

}

