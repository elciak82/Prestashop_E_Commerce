package tests.shopping.checkout.deliveryaddress;

import helpers.enums.CountryEnums;
import helpers.enums.StateEnums;
import helpers.models.Address;
import helpers.models.Customer;
import helpers.providers.AddressFactory;
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

public class DeliveryAddressesInPolandTests extends BaseTest {
    ProductMiniatureComponent productMiniature;
    Customer customer;
    HomePage homePage;
    Queries queries;
    Address address;
    CheckoutPersonalInfoPage checkoutPersonalInfoPage;

    @BeforeMethod
    public void addProductToCart() {

        homePage = new HomePage(driver);
        customer = CustomerFactory.getCustomerToRegisterRequired();

        productMiniature = homePage
                .getProductList()
                .getAllProductsMiniatures()
                .get(2);

        checkoutPersonalInfoPage = productMiniature
                .selectProduct()
                .addProductToCart()
                .proceedToCheckout()
                .proceedToCheckoutOnCartPage()
                .fillRequiredPersonalInformationWithoutPassword(customer);

    }

    @BeforeMethod
    public void generatePersonalData() {
        address = AddressFactory.getCustomerAddressWithRequiredFieldsForPoland(CountryEnums.Country.POLAND);

    }

    @AfterMethod
    public void deleteNewCustomer() throws SQLException {
        queries = new Queries();
        statement.executeUpdate(queries.deleteCustomer(customer.getCustomerLastName()));
        System.out.println("Delete customer form the database.");
    }

    @Test(testName = "Proceed checkout - add a poland address for delivery without creating an account.", description = "Behavior = Positive")
    @Description("Test verifying the checkout process - adding an address for delivery.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-48")
    @Parameters("browser: chrome")
    public void addPersonalAddressForPoland() {

        CheckoutShippingMethodPage checkoutShippingMethodPage = checkoutPersonalInfoPage
                .continueCheckoutOnPersonalInfoPage()
                .fillRequiredFieldsAddressFormForPoland(address)
                .continueCheckoutOnDeliveryAddressPage();

        Assert.assertTrue(checkoutShippingMethodPage.getDeliveryOptions().isDisplayed());
    }

}
