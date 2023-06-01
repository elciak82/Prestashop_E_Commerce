package tests.shopping;

import com.sun.source.tree.AssertTree;
import helpers.models.Customer;
import helpers.providers.CustomerFactory;
import io.qameta.allure.Description;
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
import webui.components.ProductMiniatureComponent;
import webui.pages.*;

import java.sql.SQLException;

public class CheckoutTests extends BaseTest {
    ProductMiniatureComponent productMiniature;
    CartPage cartPage;
    Customer customer;
    HomePage homePage;
    Queries queries;

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

    @AfterMethod
    public void deleteNewCustomer() throws SQLException {
        queries = new Queries();
        statement.executeUpdate(queries.deleteCustomer(customer.getCustomerLastName()));
        System.out.println("Delete customer form the database.");
    }

    @AfterMethod
    public void logOut() {
        try {
            boolean displayed = homePage.getSignOutButton().getBaseElement().isDisplayed();
            if (displayed) {
                homePage.getSignOutButton().click();
                System.out.println("Log out from the account.");
            } else {
                System.out.println("Customer is not logged in.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    @Test(testName = "Proceed checkout - add a personal information without creating an account.", description = "Behavior = Positive")
    @Description("Test verifying the checkout process - adding a personal information without creating an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-45")
    @Parameters("browser: chrome")
    public void addPersonalInformationWithoutCreatingAccount() {

        CheckoutAddressesPage checkoutAddressesPage = cartPage.proceedToCheckout().fillRequiredPersonalInformationWithoutPassword(customer).continueCheckout();
        Assert.assertTrue(checkoutAddressesPage.getCompanyField().getBaseElement().isDisplayed());

        Assert.assertTrue(new HomePage(driver).goToHomePage().getSignInButton().getBaseElement().isDisplayed());
    }

    @Test(testName = "Proceed checkout - add a personal information with creating an account.", description = "Behavior = Positive")
    @Description("Test verifying the checkout process - adding a personal information with creating an account.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-47")
    @Parameters("browser: chrome")
    public void addPersonalInformationWithCreatingAccount() {

        CheckoutAddressesPage checkoutAddressesPage = cartPage.proceedToCheckout().fillRequiredPersonalInformation(customer).continueCheckout();
        Assert.assertTrue(checkoutAddressesPage.getCompanyField().getBaseElement().isDisplayed());

        Assert.assertEquals(new HomePage(driver).goToHomePage().getUserFirstnameLastnameFromPage(), customer.getCustomerFirstName() + " " + customer.getCustomerLastName());
    }

}
