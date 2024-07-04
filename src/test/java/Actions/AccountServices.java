package Actions;

import WebElements.AccountServicesElements;
import WebElements.AccountsOverviewElements;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AccountServices {
    private AccountServicesElements element = null;

    public AccountServices(WebDriver driver) {
        this.element = new AccountServicesElements(driver);


    }
    public void clickRequestLoanLink(){
        element.clickRequestLoan().click();
    }
    public void clickFindTransactionsLink(){
        element.clickFindTransactions().click();
    }
    public String getFindTransactionsText(){
        return element.findTransactionsText().getText();
    }
    public String getApplyForALoanText(){
       return element.applyForALoanText().getText();
    }

}
