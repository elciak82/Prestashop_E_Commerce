package tests.product;

import helpers.enums.NotificationEnums;
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
import webui.components.CreateWishlistComponent;
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
    public void selectProductVariantInBlack() {

        productMiniature = new HomePage(driver).clickOnSignIn().correctLogInToAccount().goToHomePage().getProductList().getAllProductsMiniatures().get(0);
        productMiniature.getVariantLinks().get(1).click();

        Assert.assertEquals(new ProductPage(driver).getProductColour(), ProductDetailsEnums.ProductDetails.BLACK.getProductDetail());

    }

    @Test(testName = "Adding the product to the new Wishlist")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-44")
    @Parameters("browser: chrome")
    public void addProductToNewWishList() {

        productMiniature = new HomePage(driver).clickOnSignIn().correctLogInToAccount().goToHomePage().getProductList().getAllProductsMiniatures().get(2);
        productMiniature.getAddToWishlistButton().click();
        productMiniature.getAddToWishlist().cetCreateNewWishlistButton().click();
        productMiniature.getCreteWishlistComponent().getWishlistNameField().setText("New Wishlist");
        productMiniature.getCreteWishlistComponent().getCreateWishListButton().click();

        Assert.assertEquals(new CreateWishlistComponent(driver).getNotificationText(), NotificationEnums.Notifications.LIST_HAS_BEEN_PROPERLY_CREATED.getNotification());

    }
}
