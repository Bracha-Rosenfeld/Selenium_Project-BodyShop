//package tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import pages.RegistrationPage;
//import utils.BaseTest;
//
//public class RegistrationTest extends BaseTest {
//
//    @Test
//    public void testValidRegistration() {
//
//        RegistrationPage reg = new RegistrationPage(driver);
//
//        reg.openRegistrationPage();
//
//        reg.enterFirstName("Bracha");
//        reg.enterLastName("Rosenfeld");
//        reg.enterEmail("bracha@example.com");
//        reg.enterPhone("0500000000");
//        reg.enterAddress("");
//        reg.enterCity("Jerusalem");
//        reg.selectGender("female");
//        reg.submitForm();
//
//        Assert.assertTrue(reg.isSuccessMessageDisplayed(),
//                "Success message should appear after registration.");
//    }
//}
package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import pages.RegistrationPage;
import utils.BaseTest;

public class RegistrationTest extends BaseTest {

    @Test
    public void testInvalidRegistrations() {
        RegistrationPage reg = new RegistrationPage(driver);

        // ---- מקרה 1: שם עם מספרים ----
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

        // ---- מקרה 2: טלפון עם אותיות ----
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

        // ---- מקרה 3: עיר עם מספרים ----
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

//    @Test
//    public void testEmptyFieldsRegistration() {
//        RegistrationPage reg = new RegistrationPage(driver);
//        reg.openPage();
//        reg.clickCheckBox();
//        reg.submitForm();
//
//        Assert.assertFalse(reg.isSubmitButtonEnabled(), "Submit button should be disabled for empty fields.");
//    }
//
//    @Test
//    public void testInvalidEmailRegistration() {
//        RegistrationPage reg = new RegistrationPage(driver);
//        reg.openPage();
//
//        reg.enterFirstName("Bracha");
//        reg.enterLastName("Rosenfeld");
//        reg.selectGender("female");
//        reg.enterEmail("invalid-email"); // אימייל לא חוקי
//        reg.enterPhone("0500000000");
//        reg.enterAddress("Some Street");
//        reg.enterCity("Jerusalem");
//        reg.clickCheckBox();
//        reg.submitForm();
//
//         }
//}
}
