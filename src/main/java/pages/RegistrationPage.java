package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class RegistrationPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final String PAGE_URL = "https://www.bodyshop.co.il/%D7%94%D7%A6%D7%98%D7%A8%D7%A4%D7%95%D7%AA-%D7%9C%D7%9E%D7%95%D7%A2%D7%93%D7%95%D7%9F/";

    private By firstName = By.cssSelector("#form-field-name");
    private By lastName = By.cssSelector("#form-field-field_60edae3");
    private By genderMale = By.cssSelector("#form-field-field_579f0e8-0");
    private By genderFemale = By.cssSelector("#form-field-field_579f0e8-1");
    private By email = By.cssSelector("#form-field-field_f19d3d6");
    private By phone = By.cssSelector("#form-field-email");
    private By address = By.cssSelector("#form-field-field_883df88");
    private By city = By.cssSelector("#form-field-field_5a281aa");
    private By submitBtn = By.cssSelector(".elementor-button.elementor-size-sm");

    public void openPage() {
        driver.get(PAGE_URL);
    }

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void enterFirstName(String v) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstName));
        element.clear();
        element.sendKeys(v);
    }

    public void enterLastName(String v) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(lastName));
        element.clear();
        element.sendKeys(v);
    }

    public void enterEmail(String v) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(email));
        element.clear();
        element.sendKeys(v);
    }

    public void enterPhone(String v) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(phone));
        element.clear();
        element.sendKeys(v);
    }

    public void enterAddress(String v) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(address));
        element.clear();
        element.sendKeys(v);
    }

    public void enterCity(String v) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(city));
        element.clear();
        element.sendKeys(v);
    }

    public void selectGender(@org.jetbrains.annotations.NotNull String gender) {
        if (gender.equalsIgnoreCase("male")) {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(genderMale));
            element.click();
        } else if (gender.equalsIgnoreCase("female")) {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(genderFemale));
            element.click();
        }
    }
//    public void clickCheckBox() {
//        WebElement checkbox1 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form-field-field_801783e")));
//        if (!checkbox1.isSelected()) {
//            checkbox1.click();
//        }
//
//        WebElement checkbox2 = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#form-field-field_2e50be6")));
//        if (!checkbox2.isSelected()) {
//            checkbox2.click();
//        }
//    }
public void clickCheckBox() {
    safeClick(By.cssSelector("#form-field-field_801783e"));
    safeClick(By.cssSelector("#form-field-field_2e50be6"));
}

    private void safeClick(By locator) {
    WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));

    try {
        element.click();
    } catch (Exception e) {
        try {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].scrollIntoView(true);", element);
            element.click();
        } catch (Exception ex) {
            ((org.openqa.selenium.JavascriptExecutor) driver)
                    .executeScript("arguments[0].click();", element);
        }
    }
}

    public void submitForm() {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));
        element.click();
    }
    public boolean isSubmitButtonEnabled() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(submitBtn));
        return element.isEnabled();
    }
}
