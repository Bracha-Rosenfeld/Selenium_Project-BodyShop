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

    // private RegistrationPage reg;

    /*@BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.bodyshop.co.il/%D7%94%D7%A6%D7%98%D7%A8%D7%A4%D7%95%D7%AA-%D7%9C%D7%9E%D7%95%D7%A2%D7%93%D7%95%D7%9F/"); // כתובת העמוד שלך
        reg = new RegistrationPage(driver);
    }
*/
/*    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }*/

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

    @Test
    public void testEmptyFieldsRegistration() {
        RegistrationPage reg = new RegistrationPage(driver);
        reg.openPage();
        reg.clickCheckBox();
        reg.submitForm();

        Assert.assertFalse(reg.isSubmitButtonEnabled(), "Submit button should be disabled for empty fields.");
    }

    @Test
    public void testInvalidEmailRegistration() {
        RegistrationPage reg = new RegistrationPage(driver);
        reg.openPage();

        reg.enterFirstName("Bracha");
        reg.enterLastName("Rosenfeld");
        reg.selectGender("female");
        reg.enterEmail("invalid-email"); // אימייל לא חוקי
        reg.enterPhone("0500000000");
        reg.enterAddress("Some Street");
        reg.enterCity("Jerusalem");
        reg.clickCheckBox();
        reg.submitForm();

        // כאן אפשר לבדוק הודעת שגיאה שמופיעה על האימייל
        // Assert.assertTrue(reg.isEmailErrorDisplayed(), "Error message should appear for invalid email.");
    }
}

