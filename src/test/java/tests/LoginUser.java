package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class LoginUser extends BaseTest {
   private Login signIn = null;

    @Test
    public void loginUser() {

        initTest("Login user");
        driver.get("http://apptest.go.ro:9999/login");
        signIn = new Login(driver);


        signIn.setEmailInput("popadan@gmail.com");
        signIn.setPasswordInput("1234");
        signIn.setLoginButton();

        //Assert.assertTrue(signIn.getLoginText().equalsIgnoreCase("login"));

    }
}