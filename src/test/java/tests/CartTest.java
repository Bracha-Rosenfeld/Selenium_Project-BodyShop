package tests;

import org.testng.annotations.Test;
import utils.BaseTest;
import utils.ExcelUtils;

import java.util.List;

public class CartTest extends BaseTest {
    @Test
    public void verifyAndExportCartDetails() throws Exception {
        home.open();

        category.openPerfumeCategory();
        product.openSpecificProduct(product.white_musk_edt);
        product.addToCart();

        category.openMenCategory();
        product.openSpecificProduct(product.hand_cream_for_man);
        product.addToCart();

        category.openGirlsCategory();
        product.openSpecificProduct(product.girls_marshmallow_fairy);
        product.addToCart();

        product.increase_quantity(3);

        cart.open();

        List<String> productNames = cart.getProductNames();
        List<Integer> quantities = cart.getQuantities();
        List<String> prices = cart.getPrices();
        List<String> subtotals = cart.getSubtotals();
        String total = cart.getTotal();

        ExcelUtils.writeCartToExcel(
                "CartResults.xlsx",
                productNames,
                quantities,
                prices,
                subtotals,
                total
        );
    }

}

