package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.RegistrationPage;
import utils.BaseTest;

public class RegistrationTest extends BaseTest {


    private void checkValidationError(boolean errorShown, String fieldName) {
        if (!errorShown) {
            System.out.println("⚠️ WARNING: Invalid " + fieldName + " was accepted — no error was shown!");
        }
        Assert.assertTrue(errorShown, "Expected validation error for invalid " + fieldName);
    }

    @Test
    public void testInvalidEmail() {
        RegistrationPage reg = new RegistrationPage(driver);

        reg.openPage();
        reg.enterFirstName("John");
        reg.enterLastName("Doe");
        reg.selectGender("male");
        reg.enterEmail("john@g");   // Invalid email
        reg.enterPhone("0500000000");
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem");
        reg.clickCheckBox();

        reg.submitForm();

        checkValidationError(reg.isErrorDisplayed(), "email");
    }

    @Test
    public void testInvalidPhone() {
        RegistrationPage reg = new RegistrationPage(driver);

        reg.openPage();
        reg.enterFirstName("John");
        reg.enterLastName("Doe");
        reg.selectGender("male");
        reg.enterEmail("john@gmail.com");
        reg.enterPhone("abc");  // Invalid phone
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem");
        reg.clickCheckBox();

        reg.submitForm();

        checkValidationError(reg.isErrorDisplayed(), "phone");
    }

    @Test
    public void testInvalidCity() {
        RegistrationPage reg = new RegistrationPage(driver);

        reg.openPage();
        reg.enterFirstName("John");
        reg.enterLastName("Doe");
        reg.selectGender("male");
        reg.enterEmail("john@gmail.com");
        reg.enterPhone("0500000000");
        reg.enterAddress("Some Street");
        reg.enterCity("123");  // Invalid city
        reg.clickCheckBox();

        reg.submitForm();

        checkValidationError(reg.isErrorDisplayed(), "city");
    }

//    @Test
//    public void testInvalidRegistrations() {
//        RegistrationPage reg = new RegistrationPage(driver);
//
//        reg.openPage();
//        reg.enterFirstName("John");
//        reg.enterLastName("Doe");
//        reg.selectGender("male");
//        reg.enterEmail("john");
//        reg.enterPhone("0500000000");
//        reg.enterAddress("Some Street");
//        reg.enterCity("Jerusalem");
//        reg.clickCheckBox();
//        reg.submitForm();
//        Assert.assertFalse(reg.isSubmitButtonEnabled(),
//                "Submit should be disabled when email address is wrong syntax.");
//    }
//        @Test
//        public void testInvalidRegistrations2() {
//            RegistrationPage reg = new RegistrationPage(driver);
//
//            reg.openPage();
//            reg.enterFirstName("John");
//            reg.enterLastName("Doe");
//            reg.selectGender("male");
//            reg.enterEmail("john@gmail.com");
//            reg.enterPhone("abc");
//            reg.enterAddress("Some Street");
//            reg.enterCity("Jerusalem");
//            reg.clickCheckBox();
//            reg.submitForm();
//            Assert.assertFalse(reg.isSubmitButtonEnabled(),
//                    "Submit should be disabled when phone contains letters.");
//        }
//    @Test
//    public void testInvalidRegistrations3() {
//        RegistrationPage reg = new RegistrationPage(driver);
//
//        reg.openPage();
//        reg.enterFirstName("John");
//        reg.enterLastName("Doe");
//        reg.selectGender("male");
//        reg.enterEmail("john@gmail.com");
//        reg.enterPhone("0500000000");
//        reg.enterAddress("Some Street");
//        reg.enterCity("123");
//        reg.clickCheckBox();
//        reg.submitForm();
//        Assert.assertFalse(reg.isSubmitButtonEnabled(),
//                "Submit should be disabled when city contains numbers.");
//
//    }
//@Test
//public void testInvalidEmailSyntax() {
//    RegistrationPage reg = new RegistrationPage(driver);
//    SoftAssert soft = new SoftAssert();
//    reg.openPage();
//    reg.enterFirstName("John");
//    reg.enterLastName("Doe");
//    reg.selectGender("male");
//    reg.enterEmail("john"); // invalid
//    reg.enterPhone("0500000000");
//    reg.enterAddress("Some Street");
//    reg.enterCity("Jerusalem");
//    reg.clickCheckBox();
//    reg.submitForm();
//
//    soft.assertFalse(
//            reg.isSubmitButtonEnabled(),
//            "Submit should be disabled when email syntax is invalid."
//    );
//
//    soft.assertAll(); // לא מפיל את שאר הטסטים
//}
//
//    @Test
//public void testInvalidCity() {
//        RegistrationPage reg = new RegistrationPage(driver);
//        SoftAssert soft = new SoftAssert();
//    reg.openPage();
//    reg.enterFirstName("John");
//    reg.enterLastName("Doe");
//    reg.selectGender("male");
//    reg.enterEmail("john@gmail.com");
//    reg.enterPhone("0500000000");
//    reg.enterAddress("Some Street");
//    reg.enterCity("123"); // invalid
//    reg.clickCheckBox();
//    reg.submitForm();
//
//    soft.assertFalse(
//            reg.isSubmitButtonEnabled(),
//            "Submit should be disabled when city contains numbers."
//    );
//
//    soft.assertAll();
//}
//
//    @Test
//    public void testInvalidPhone() {
//        RegistrationPage reg = new RegistrationPage(driver);
//        SoftAssert soft = new SoftAssert();
//        reg.openPage();
//        reg.enterFirstName("John");
//        reg.enterLastName("Doe");
//        reg.selectGender("male");
//        reg.enterEmail("john@gmail.com");
//        reg.enterPhone("abc");
//        reg.enterAddress("Some Street");
//        reg.enterCity("Jerusalem");
//        reg.clickCheckBox();
//        reg.submitForm();
//
//        soft.assertFalse(
//                reg.isSubmitButtonEnabled(),
//                "Submit should be disabled when phone contains letters."
//        );
//
//        soft.assertAll(); // מדפיס שגיאה אבל לא עוצר ריצה של כל הטסטים
//    }

    @Test
    public void testValidRegistration() {
       // RegistrationPage reg = new RegistrationPage(driver);
        RegistrationPage reg = new RegistrationPage(driver);
        SoftAssert soft = new SoftAssert();
        reg.openPage();
        reg.enterFirstName("John");
        reg.enterLastName("Doe");
        reg.selectGender("male");
        reg.enterEmail("john@gmail.com");
        reg.enterPhone("0500000000");
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem");
        reg.clickCheckBox();
        reg.submitForm();

        Assert.assertTrue(reg.isSubmitButtonEnabled(), "Submit button should be enabled after registration.");
    }
}
