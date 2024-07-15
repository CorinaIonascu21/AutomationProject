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
    public void registerUser(boolean isTrainer) {

        initTest("Register user");
        login = new Login(driver);
        register = new Register(driver);
        login.clickRegisterButton();

        Assert.assertTrue(register.getSingUpText().equalsIgnoreCase("Sign Up"));

        register.setFirstName("popa");//apelam metodele.actiunile
       register.setLastName("dan");
        register.setEmail("dan@dan864.com");
        register.setPhoneNumber("0123456");
        register.password("1234");
        register.city("Romania");
        if (isTrainer) {
            register.trainer();
        } else {

            register.customer();
        }
        register.submit();
    }


    }
