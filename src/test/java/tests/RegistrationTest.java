package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.RegistrationPage;
import utils.BaseTest;

public class RegistrationTest extends BaseTest {

    @Test
    public void testInvalidRegistrations() {
        RegistrationPage reg = new RegistrationPage(driver);

        reg.openPage();
        reg.enterFirstName("Bracha123");
        reg.enterLastName("Rosen45");
        reg.selectGender("female");
        reg.enterEmail("bracha@gmail.com");
        reg.enterPhone("0500000000");
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem");
        reg.clickCheckBox();
        reg.submitForm();
        Assert.assertFalse(reg.isSubmitButtonEnabled(),
                "Submit should be disabled when name contains numbers.");

        reg.openPage();
        reg.enterFirstName("Bracha");
        reg.enterLastName("Rosenfeld");
        reg.selectGender("female");
        reg.enterEmail("bracha@gmail.com");
        reg.enterPhone("abc12345");
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem");
        reg.clickCheckBox();
        reg.submitForm();
        Assert.assertFalse(reg.isSubmitButtonEnabled(),
                "Submit should be disabled when phone contains letters.");

        reg.openPage();
        reg.enterFirstName("Bracha");
        reg.enterLastName("Rosenfeld");
        reg.selectGender("female");
        reg.enterEmail("bracha@gmail.com");
        reg.enterPhone("0500000000");
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem123");
        reg.clickCheckBox();
        reg.submitForm();
        Assert.assertFalse(reg.isSubmitButtonEnabled(),
                "Submit should be disabled when city contains numbers.");
    }

    @Test
    public void testValidRegistration() {
        RegistrationPage reg = new RegistrationPage(driver);
        reg.openPage();
        reg.enterFirstName("Bracha");
        reg.enterLastName("Rosenfeld");
        reg.selectGender("female");
        reg.enterEmail("bracha@gmail.com");
        reg.enterPhone("0500000000");
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem");
        reg.clickCheckBox();
        reg.submitForm();

        Assert.assertTrue(reg.isSubmitButtonEnabled(), "Submit button should be enabled after registration.");
    }
}
