import Actions.SimpleActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class SimpleTest extends BaseTest {

    @Test
    public void firstTest() {
        initTest("Sample test");
        driver.get("http://apptest.go.ro:9999/login");

        String expectedText = "Login";
        SimpleActions simpleActions = new SimpleActions(driver);
        String loginText = simpleActions.getLoginText();

        Assert.assertEquals(loginText.toLowerCase(), expectedText.toLowerCase());
        Assert.assertTrue(loginText.equalsIgnoreCase(expectedText));

        System.out.println(loginText);
        System.out.println(expectedText);
    }
   @Test
    public void testLoginFail(){
        // Test login page with wrong email or password
        // 1. punem email si parola gresita
        // expected sa apara mesaj de eroare
        initTest("testLoginFail");
        driver.get("http://apptest.go.ro:9999/login");

        String expectedText= "Access forbidden!";

        SimpleActions simpleActions= new SimpleActions(driver);
        // trebuie sa iti gasesti toate elemetele de care ai nevoie in test

        // 1.EMail field
        WebElement emailInput = simpleActions.getEmailField();
        // 2. Password
        WebElement passwordInput = simpleActions.getPasswordField();
        // 3. login button
        WebElement loginButton = simpleActions.getLoginButton();


        // Actions
        // 1. Punem in fieldul de email un text random
        emailInput.sendKeys("test@gmail.com");
        // 2. parola la fel
        passwordInput.sendKeys("test");
        // 3. dam cick pe button
        loginButton.click();
        //asteapta dupa api raspuns
        simpleActions.waitForElement(driver, "errorForbiddenAccess");
        WebElement errorMessage = simpleActions.getLoginErrorMessage();
        // expect error text = expectedText
          Assert.assertEquals(errorMessage.getText(),expectedText);
    }
    @Test
    public void testLoginSuccess(){
    //test123@gmail.com
        // Test login page with wrong email or password
        // 1. punem email si parola gresita
        // expected sa apara mesaj de eroare
        initTest("testLoginSuccess");
        driver.get("http://apptest.go.ro:9999/login");
        SimpleActions simpleActions= new SimpleActions(driver);

        WebElement emailInput = simpleActions.getEmailField();
        WebElement passwordInput = simpleActions.getPasswordField();
        WebElement loginButton = simpleActions.getLoginButton();
        emailInput.sendKeys("test123@gmail.com");
        passwordInput.sendKeys("Corina12");
        loginButton.click();
        //asteapta dupa api raspuns
        simpleActions.waitForElement(driver, "userName");
        // expect user name = test123@gmail.com
        WebElement userName = simpleActions.getUserNameText();
        Assert.assertEquals(userName.getText(),"test123@gmail.com");
    }
}
