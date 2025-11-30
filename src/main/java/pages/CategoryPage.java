package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CategoryPage {
    private WebDriver driver;
    WebDriverWait wait;

    private By categoryHomeAmbience = By.cssSelector("#menu-item-210208 > a");
    private By categoryMen = By.cssSelector("#menu-item-209983>a");
    private By categoryGirls = By.cssSelector("#menu-item-209992>a");

    public CategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    private void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
    }
    public void openPerfumeCategory() {
        clickElement(categoryHomeAmbience);
    }

    public void openMenCategory() {
        clickElement(categoryMen);
    }

    public void openGirlsCategory() {
        clickElement(categoryGirls);
    }
}
