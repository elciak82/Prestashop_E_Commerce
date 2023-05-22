package tests.product;

import helpers.enums.ProductDetailsEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.HeaderComponent;
import webui.components.ProductListComponent;
import webui.components.ProductMiniatureComponent;
import webui.pages.HomePage;
import webui.pages.ProductPage;

public class ProductTests extends BaseTest {

    ProductMiniatureComponent productMiniature;
    ProductListComponent productList;

    @Test(testName = "Selecting the product variant in black")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-43")
    @Parameters("browser: chrome")
    public void productsTest() {

        productMiniature = new HomePage(driver).clickOnSignIn().correctLogInToAccount().goToHomePage().getProductList().getAllProductsMiniatures().get(0);
        productMiniature.getVariantLinks().get(1).click();

        Assert.assertEquals(new ProductPage(driver).getProductColour(), ProductDetailsEnums.ProductDetails.BLACK.getProductDetail());

    }

}
