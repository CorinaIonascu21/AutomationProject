package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountDetailsTransactions {
    private WebDriver driver = null;

    public AccountDetailsTransactions(WebDriver driver) {
        this.driver = driver;
    }

    public List<WebElement> accountDetailsTableRows() {
        return driver.findElements(By.xpath("//*[@id=\"transactionTable\"]/tbody"));
    }

    public WebElement lastTransactionsSelected() {
        List<WebElement> tableRows = this.accountDetailsTableRows();
        WebElement lastTransaction = tableRows.get(tableRows.size() - 1);
        return lastTransaction.findElement(By.tagName("a"));
    }
    public WebElement lastElement(){
        return driver.findElement(By.xpath("//*[@id=\"transactionTable\"]/tbody"));
    }
    public WebElement AccountDetailsText(){
        return driver.findElement((By.xpath("//*[@id=\"accountDetails\"]/h1")));
    }
}