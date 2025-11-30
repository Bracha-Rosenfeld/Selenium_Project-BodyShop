package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage {
    private WebDriver driver;
    private By cartRows = By.cssSelector("tr.cart_item");
    private By productName = By.cssSelector("td.product-name a");
    private By productQuantity = By.cssSelector("td.product-quantity input.qty");
    private By productPrice = By.cssSelector("td.product-price .woocommerce-Price-amount");
    private By productSubtotal = By.cssSelector("td.product-subtotal .woocommerce-Price-amount");
    private By totalAmount = By.cssSelector("tr.order-total .woocommerce-Price-amount");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        driver.get("https://www.bodyshop.co.il/cart/");
    }

    public List<String> getProductNames() {
        return driver.findElements(cartRows).stream()
            .map(e -> e.findElement(productName).getText())
            .collect(Collectors.toList());
    }

    public List<Integer> getQuantities() {
        return driver.findElements(cartRows).stream()
                .map(e -> Integer.parseInt(e.findElement(productQuantity).getAttribute("value")))
                .collect(Collectors.toList());
    }

    public List<String> getPrices() {
        return driver.findElements(cartRows).stream()
                .map(e -> e.findElement(productPrice).getText())
                .collect(Collectors.toList());
    }

    public List<String> getSubtotals() {
        return driver.findElements(cartRows).stream()
                .map(e -> e.findElement(productSubtotal).getText())
                .collect(Collectors.toList());
    }

    public String getTotal() {
        return driver.findElement(totalAmount).getText();
    }
}