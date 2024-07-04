package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountServicesElements {
    private WebDriver driver;

    public AccountServicesElements(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement clickRequestLoan() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[7]/a"));
    }
    public WebElement clickFindTransactions() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[5]/a"));
    }
    public WebElement findTransactionsText() {
        return driver.findElement(By.xpath("//*[@id=\"formContainer\"]/h1"));
    }
    public WebElement applyForALoanText() {
        return driver.findElement(By.xpath("//*[@id=\"requestLoanForm\"]/h1"));
    }
}
