package WebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TransferFundsElements {
    private WebDriver driver;
    private By dropdownFromAccount = By.id("fromAccountId");
    private By dropdownToAccount = By.id("toAccountId");


    public TransferFundsElements(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement clickTransferFundsButton() {
        return driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[3]/a"));
    }

    public WebElement transferFundsText() {
        return driver.findElement(By.xpath("//*[@id=\"showForm\"]/h1"));
    }

    public WebElement amountValueTransfer() {
        return driver.findElement(By.xpath("//*[@id=\"amount\"]"));
    }

    public WebElement transferAmountButton() {
        return driver.findElement(By.xpath("//*[@id=\"transferForm\"]/div[2]/input"));
    }

    public WebElement transferAmountSuccess() {
        return driver.findElement(By.xpath("//*[@id=\"showResult\"]/h1"));
    }


    public Select findDropDownFromAccountElement() {
        return new Select(driver.findElement(dropdownFromAccount));
    }
    public Select findDropDownToAccountElement() {
        return new Select(driver.findElement(dropdownToAccount));
    }
}
