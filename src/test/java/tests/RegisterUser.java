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
        login = new Login(driver);
        register = new Register(driver);
        login.clickRegisterButton();

        Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("Signing up is easy!"));
        String dynamicUserName = register.getDynamicUsername();
        register.registerUser(dynamicUserName);
        String successRegisterUser = "Your account was created successfully. You are now logged in.";
        Assert.assertTrue(register.getRegisterUserSuccessText().equalsIgnoreCase(successRegisterUser));
    }

}
