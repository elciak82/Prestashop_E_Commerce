package tests.product;

import helpers.enums.NotificationEnums;
import helpers.enums.ProductDetailsEnums;
import helpers.providers.CustomerFactory;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import mysqlconnection.Queries;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.CreateWishlistComponent;
import webui.components.ProductMiniatureComponent;
import webui.pages.HomePage;
import webui.pages.ProductPage;

import java.sql.SQLException;

public class ProductTests extends BaseTest {
    Queries queries;
    String newWishlist = "New_Wishlist";

    @BeforeMethod
    public void deleteWishlist() throws SQLException {
        queries = new Queries();
        statement.executeUpdate(queries.deleteWishlist(newWishlist));
        System.out.println("Delete the Whishlist form the database - just in case.");
    }

    @BeforeMethod
    public void LogIn(){
        new HomePage(driver).clickOnSignIn().correctLogInToAccount().goToHomePage();
    }

    @AfterMethod
    public void LogOut(){
        new HomePage(driver).getSignOutButton().click();
    }

    @AfterMethod
    public void deleteNewWishlist() throws SQLException {
        queries = new Queries();
        statement.executeUpdate(queries.deleteWishlist(newWishlist));
        System.out.println("Delete the Whishlist form the database.");
    }

    ProductMiniatureComponent productMiniature;

    @Test(testName = "Selecting the product variant in black")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-43")
    @Parameters("browser: chrome")
    public void selectProductVariantInBlack() {

        productMiniature = new HomePage(driver).getProductList().getAllProductsMiniatures().get(0);
        productMiniature.getVariantLinks().get(1).click();

        Assert.assertEquals(new ProductPage(driver).getProductColour(), ProductDetailsEnums.ProductDetails.BLACK.getProductDetail());

    }

    @Test(testName = "Adding the product to the new Wishlist")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-44")
    @Parameters("browser: chrome")
    public void addProductToNewWishlist() {

        productMiniature = new HomePage(driver).getProductList().getAllProductsMiniatures().get(2);
        productMiniature.getAddToWishlistButton().click();
        productMiniature.getAddToWishlist().cetCreateNewWishlistButton().click();
        productMiniature.getCreteWishlistComponent().getWishlistNameField().setText(newWishlist);
        productMiniature.getCreteWishlistComponent().getCreateWishListButton().click();

        Assert.assertEquals(new CreateWishlistComponent(driver).getNotificationText(), NotificationEnums.Notifications.LIST_HAS_BEEN_PROPERLY_CREATED.getNotification());

        productMiniature.getAddToWishlist().closeWishlistComponent();

    }
}
