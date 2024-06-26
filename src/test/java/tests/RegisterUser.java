package tests;

import Actions.Login;
import Actions.Register;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;

public class RegisterUser extends BaseTest {
    private Login login = null;
    private Register register = null;

    @Test
    public void registerUser() {

        initTest("Register user");
        driver.get("http://apptest.go.ro:9999/login");
        login = new Login(driver);
        register = new Register(driver);
        login.clickRegisterButton();

        register.setFirstName("popa");
        register.setLastName("dan");
        register.setEmail("popadan@gmail.com");
        register.setPhoneNumber("0722222");
        register.password("1234");
        register.city("Romania");
        register.customer();
        register.submit();

        Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("Sign Up"));
    }
}