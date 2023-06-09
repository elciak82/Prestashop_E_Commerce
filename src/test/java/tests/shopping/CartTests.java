package tests.shopping;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.ProductMiniatureComponent;
import webui.pages.CartPage;
import webui.pages.HomePage;

public class CartTests extends BaseTest {
    ProductMiniatureComponent productMiniature;

    @Test(testName = "Add a product to the cart.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a product to the cart.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-46")
    @Parameters("browser: chrome")
    public void addProductToCartWithoutSigningInTest()  {
        productMiniature = new HomePage(driver)
                .getProductList()
                .getAllProductsMiniatures()
                .get(2);

        CartPage productInCart = productMiniature
                .selectProduct()
                .addProductToCart()
                .proceedToCheckout();

        Assert.assertEquals(productInCart.getCartProductCounts(), "(2)");
    }

}
