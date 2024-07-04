package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OpenNewAccountElement {
    private WebDriver driver = null;
    private By dropdownTipeOfAccount = By.id("type");
    private By dropdownExistedAccount = By.id("fromAccountId");

    public OpenNewAccountElement(WebDriver driver) {
        this.driver = driver;

    }

    public WebElement openNewAccountText() {
        return driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/h1"));
    }

    public WebElement clickOpenNewAccountLink() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[1]/a"));
    }

    public Select findDropDownExistedAccounts() {
        return new Select(driver.findElement(dropdownExistedAccount));

    }

    public Select findDropDownElement() {
           return new Select(driver.findElement(dropdownTipeOfAccount));
    }

    public WebElement clickOpenNewAccountButton() {
        return driver.findElement(By.xpath("//*[@id=\"openAccountForm\"]/form/div/input"));
    }

    public WebElement accountOpenedText() {
        return driver.findElement(By.xpath(" //*[@id=\"openAccountResult\"]/h1"));
    }
    public WebElement accountNumber() {
        return driver.findElement(By.xpath("//*[@id=\"newAccountId\"]"));
    }
}


