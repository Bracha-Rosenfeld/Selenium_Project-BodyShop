package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DynamicContentPage {
    private WebDriver driver;

    private By twoProductsPerRowButton = By.cssSelector(".shop-view.per-row-2");

    public DynamicContentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open(){ driver.get("https://www.bodyshop.co.il/products/");}

    public void clickTwoProductsPerRow() {
        driver.findElement(twoProductsPerRowButton).click();
    }

    public boolean isTwoPerRow() {
        WebElement twoPerRowButton = driver.findElement(By.cssSelector(".shop-view.per-row-2"));
        return twoPerRowButton.getAttribute("class").contains("current-variation");
    }

}
