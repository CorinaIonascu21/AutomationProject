package Actions;

import WebElements.AccountDetailsTransactions;
import WebElements.AccountsOverviewElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountDetails {
    private AccountDetailsTransactions elements = null;
    private Wait<WebDriver> wait;


    public AccountDetails(WebDriver driver) {
        elements = new AccountDetailsTransactions(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    public String newTransactionCreated(){
        wait.until(d -> elements.accountDetailsTableRows().size() > 1);

        return elements.lastTransactionsSelected().getText();
    }
    public String lastElement(){
       return elements.lastElement().getText();
    }
    public String getAccountDetailsText(){
        return elements.AccountDetailsText().getText();
    }
}
