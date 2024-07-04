package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountsOverviewElements {
    private WebDriver driver = null;

    public AccountsOverviewElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement accountsOverviewText() {
        return driver.findElement(By.xpath("//*[@id=\"showOverview\"]/h1"));
    }

    public WebElement clickAccountsOverviewLink() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[2]/a"));
    }
    public List<WebElement> accountOverviewTableRows(){
       return driver.findElements(By.xpath("//*[@id=\"accountTable\"]/tbody/tr"));
    }
    public WebElement newAccountCreated(){
        List<WebElement> tableRows = this.accountOverviewTableRows();
        WebElement lastAccountCreated = tableRows.get(tableRows.size() -2);
        return lastAccountCreated.findElement(By.tagName("a"));
    }
    public WebElement clickFirstAccountElement(){
        return driver.findElement(By.xpath("//*[@id=\"accountTable\"]/tbody/tr[1]/td[1]/a"));

    }
}