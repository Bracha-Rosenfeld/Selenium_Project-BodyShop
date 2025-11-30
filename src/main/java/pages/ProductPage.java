package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import org.openqa.selenium.WebElement;

public class ProductPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public By white_musk_edt = By.cssSelector("h3.wd-entities-title a[href='https://www.bodyshop.co.il/product/white-musk-edt/']");
    public By hand_cream_for_man = By.cssSelector("div.product-wrapper a.product-image-link[href*='hand-cream-men']");
    public By girls_marshmallow_fairy=By.cssSelector("div[data-id='1388']");
    private By addToCartButton = By.cssSelector("button.single_add_to_cart_button");
    private By plusButton = By.cssSelector(".woocommerce-mini-cart-item .quantity .plus");
    // --- Methods ---

    public void openSpecificProduct(By specificProduct) {
        WebElement product = wait.until(ExpectedConditions.elementToBeClickable(specificProduct));
        product.click();
    }

    public void addToCart() {
        WebElement button = wait.until(ExpectedConditions.visibilityOfElementLocated(addToCartButton));
        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();
        wait.until(ExpectedConditions.elementToBeClickable(button)).click();
    }
    public void increase_quantity(int quantity) {
        for (int i = 0; i < quantity-1; i++) {
            wait.until(ExpectedConditions.elementToBeClickable(plusButton)).click();
        }
    }
}
