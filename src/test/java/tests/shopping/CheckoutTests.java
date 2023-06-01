package tests.shopping;

import com.sun.source.tree.AssertTree;
import helpers.models.Customer;
import helpers.providers.CustomerFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.ProductMiniatureComponent;
import webui.pages.*;

public class CheckoutTests extends BaseTest {
    ProductMiniatureComponent productMiniature;
    CartPage cartPage;
    Customer customer;
    HomePage homePage;

    @BeforeMethod
    public void addProductToCart() {

        homePage = new HomePage(driver);

        productMiniature = homePage
                .getProductList()
                .getAllProductsMiniatures()
                .get(2);

        cartPage = productMiniature
                .selectProduct()
                .addProductToCart()
                .proceedToCheckout();
    }

    @BeforeMethod
    public void generatePersonalData() {
        customer = CustomerFactory.getCustomerToRegisterRequired();

    }

    @Test(testName = "Proceed checkout - add a personal information without creating an account.", description = "Behavior = Positive")
    @Description("Test verifying the checkout process - adding a personal information without creating an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-..")
    @Parameters("browser: chrome")
    public void addPersonalInformationWithoutCreatingAccount() {

        CheckoutAddressesPage checkoutAddressesPage = cartPage.proceedToCheckout().fillRequiredPersonalInformationWithoutPassword(customer).continueCheckout();
        Assert.assertTrue(checkoutAddressesPage.getCompanyField().getBaseElement().isDisplayed());

        Assert.assertTrue(new HomePage(driver).goToHomePage().getSignInButton().getBaseElement().isDisplayed());

    }

    @Test(testName = "Proceed checkout - add a personal information without creating an account.", description = "Behavior = Positive")
    @Description("Test verifying the checkout process - adding a personal information without creating an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-..")
    @Parameters("browser: chrome")
    public void addPersonalInformationWithCreatingAccount() {

        CheckoutAddressesPage checkoutAddressesPage = cartPage.proceedToCheckout().fillRequiredPersonalInformation(customer).continueCheckout();
        Assert.assertTrue(checkoutAddressesPage.getCompanyField().getBaseElement().isDisplayed());

        Assert.assertTrue(new HomePage(driver).goToHomePage().getSignOutButton().getBaseElement().isDisplayed());
    }

}
