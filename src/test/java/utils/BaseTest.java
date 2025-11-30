package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.CategoryPage;
import pages.HomePage;
import pages.ProductPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;

    protected HomePage home;
    protected CategoryPage category;
    protected ProductPage product;
    protected CartPage cart;

//    @BeforeClass
//    public void setUpClass() {
//        WebDriverManager.chromedriver().setup();
//    }

    //@BeforeMethod
    @BeforeClass
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        home = new HomePage(driver);
        category = new CategoryPage(driver);
        product = new ProductPage(driver);
        cart = new CartPage(driver);
    }

//    @AfterMethod(alwaysRun = true)
//    @AfterClass
//    public void tearDown() {
//        if (driver != null) {
//            driver.quit();
//        }
//    }
}
