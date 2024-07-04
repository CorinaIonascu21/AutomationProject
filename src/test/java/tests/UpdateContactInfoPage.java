package tests;

import Actions.BillPay;
import Actions.Login;
import Actions.Register;
import Actions.UpdateContactInfo;
import org.testng.Assert;
import org.testng.annotations.Test;
import utile.BaseTest;
import utile.ConfigLoader;

public class UpdateContactInfoPage extends BaseTest {
    private Login login = null;
    private ConfigLoader configLoader;
    private UpdateContactInfo updateContactInfo = null;
    private Register register = null;

    @Test
    public void UpdateContactInfoPage() {
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");

        initTest("Update contact info link");
        login = new Login(driver);
        register = new Register(driver);
        updateContactInfo = new UpdateContactInfo(driver);
        // login.login();
        login.clickRegisterButton();
        String dynamicUserName = register.getDynamicUsername();
        register.registerUser(dynamicUserName);
        updateContactInfo.clickUpdateContactInfoLink();
        Assert.assertTrue(updateContactInfo.getUpdateProfileText().equalsIgnoreCase("Update Profile"));


        updateContactInfo.clearProfileData();
        updateContactInfo.updateProfileElements();
        Assert.assertTrue(updateContactInfo.getProfileUpdatedText().equalsIgnoreCase("Profile Updated"));

        updateContactInfo.clickUpdateContactInfoLink();
        Assert.assertTrue(updateContactInfo.getUpdateProfileText().equalsIgnoreCase("Update Profile"));
        updateContactInfo.waitUntilProfileDateLoaded();

        String profileFirstName = updateContactInfo.getFirstNameValue();
        String FirstName = configLoader.getProperty("firstName");
        Assert.assertTrue(profileFirstName.equalsIgnoreCase(FirstName));

        String profileLastName = updateContactInfo.getLastNameValue();
        String LastName = configLoader.getProperty("LastName");
        Assert.assertTrue(profileLastName.equalsIgnoreCase(LastName));

        String profileAddress = updateContactInfo.getAddressValue();
        String Address = configLoader.getProperty("Address");
        Assert.assertTrue(profileAddress.equalsIgnoreCase(Address));

        String profileCity = updateContactInfo.getCityValue();
        String City = configLoader.getProperty("City");
        Assert.assertTrue(profileCity.equalsIgnoreCase(City));

        String profileState = updateContactInfo.getStateValue();
        String State = configLoader.getProperty("State");
        Assert.assertTrue(profileState.equalsIgnoreCase(State));

        String profileZipCode = updateContactInfo.getZipCodeValue();
        String ZipCode = configLoader.getProperty("ZipCode");
        Assert.assertTrue(profileZipCode.equalsIgnoreCase(ZipCode));

        String profilePhoneNumber = updateContactInfo.getPhoneValue();
        String Phone = configLoader.getProperty("Phone");
        Assert.assertTrue(profilePhoneNumber.equalsIgnoreCase(Phone));


    }

    @Test
    public void UpdateContactInfoPageElement() {
        configLoader = new ConfigLoader("src/test/resources/proprietati/dateUser1.properties");

        initTest("Update contact info link, only first name element");
        login = new Login(driver);
        register = new Register(driver);
        updateContactInfo = new UpdateContactInfo(driver);
        // login.login();
        login.clickRegisterButton();
        String dynamicUserName = register.getDynamicUsername();
        register.registerUser(dynamicUserName);
        updateContactInfo.clickUpdateContactInfoLink();
        Assert.assertTrue(updateContactInfo.getUpdateProfileText().equalsIgnoreCase("Update Profile"));

        updateContactInfo.waitUntilProfileDateLoaded();
        updateContactInfo.clearFirstNameElement();
        String newFirstName = "New first name";
        updateContactInfo.setFirstName(newFirstName);
        updateContactInfo.clickUpdateProfileSubmitButton();
        Assert.assertTrue(updateContactInfo.getProfileUpdatedText().equalsIgnoreCase("Profile Updated"));
        updateContactInfo.clickUpdateContactInfoLink();
        updateContactInfo.waitUntilProfileDateLoaded();

        String profileFirstName = updateContactInfo.getFirstNameValue();
        Assert.assertTrue(profileFirstName.equalsIgnoreCase(newFirstName));



    }
}
