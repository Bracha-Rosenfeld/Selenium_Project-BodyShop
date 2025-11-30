package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CategoryPage;
import utils.BaseTest;
import utils.ExcelUtils;

import java.util.List;

public class CartTest extends BaseTest {

//    @Test
//    public void addFirstProductToCart() throws Exception {
//        home.open();
//        category.openPerfumeCategory();
//        product.openSpecificProduct(product.white_musk_edt);
//        product.addToCart();
//    }
//
//    @Test
//    public void addSecondProductToCart() throws Exception {
//        //home.open();
//        category.openMenCategory();
//        product.openSpecificProduct(product.hand_cream_for_man);
//        product.addToCart();
//    }
//    @Test
//    public void addThirdProductToCart() throws Exception {
//        //home.open();
//        category.openGirlsCategory();
//        product.openSpecificProduct(product.girls_marshmallow_fairy);
//        product.addToCart();
//        product.increase_quantity(3);
//    }

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

        // go to cart
        cart.open();

//        // extract data
//        List<String> productNames = cart.getProductNames();
//        List<Integer> quantities = cart.getQuantities();
//        String total = cart.getTotal();
//
//        // write to excel
//        ExcelUtils.writeCartToExcel(
//                "CartResults.xlsx",
//                productNames,
//                quantities,
//                total
//        );
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

