package tests.shopping.checkout.shippingmethods.poland;

import helpers.enums.CountryEnums;
import helpers.enums.ShippingValueEnums;
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
import webui.pages.CheckoutAddressesPage;
import webui.pages.CheckoutPaymentPage;
import webui.pages.CheckoutShippingMethodPage;
import webui.pages.HomePage;

import java.sql.SQLException;
import java.util.concurrent.Delayed;

public class ShippingMethodsForPolandTests extends BaseTest {
    ProductMiniatureComponent productMiniature;
    Customer customer;
    HomePage homePage;
    Queries queries;
    Address address;
    CheckoutAddressesPage checkoutDeliveryAddressPage;

    @BeforeMethod
    public void addProductToCart() {

        homePage = new HomePage(driver);
        customer = CustomerFactory.getCustomerToRegisterRequired();
        address = AddressFactory.getCustomerAddressWithRequiredFieldsForPoland(CountryEnums.Country.POLAND);

        productMiniature = homePage
                .getProductList()
                .getAllProductsMiniatures()
                .get(2);

        checkoutDeliveryAddressPage = productMiniature
                .selectProduct()
                .addProductToCart()
                .proceedToCheckout()
                .proceedToCheckoutOnCartPage()
                .fillRequiredPersonalInformationWithoutPassword(customer)
                .continueCheckoutOnPersonalInfoPage()
                .fillRequiredFieldsAddressFormForPoland(address);

    }

    @AfterMethod
    public void deleteNewCustomer() throws SQLException {
        queries = new Queries();
        statement.executeUpdate(queries.deleteCustomer(customer.getCustomerLastName()));
        System.out.println("Delete customer form the database.");
    }

    @Test(testName = "Proceed checkout - select a shipping method for Poland without creating an account.", description = "Behavior = Positive")
    @Description("Test verifying the checkout process - select a shipping method for delivery.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-49")
    @Parameters("browser: chrome")
    public void selectShippingMethodForPoland() {

        CheckoutShippingMethodPage checkoutShippingMethodPage = checkoutDeliveryAddressPage
                .continueCheckoutOnDeliveryAddressPage()
                .selectMyCarrierPL();

        Double myCarrierPriceValue = checkoutShippingMethodPage.getPriceFromShippingOption();
        Double myCarrierPriceInSummary = checkoutShippingMethodPage.getPriceFromSummary();

        Assert.assertTrue(checkoutShippingMethodPage.myCarrierIsSelected());
        Assert.assertEquals(myCarrierPriceValue, myCarrierPriceInSummary);

        checkoutShippingMethodPage.selectMyLightCarrier();
        Double myLightPriceValue = checkoutShippingMethodPage.getPriceFromShippingOption();
        Double myLightPriceInSummary = checkoutShippingMethodPage.getPriceFromSummary();

        Assert.assertTrue(checkoutShippingMethodPage.myLightCarrierIsSelected());
        Assert.assertEquals(myLightPriceValue, myLightPriceInSummary);

        checkoutShippingMethodPage.selectMyPrestashop();
        Double myPrestashopValue = checkoutShippingMethodPage.getPriceFromShippingOption();
        Double myPrestashopInSummary = checkoutShippingMethodPage.getPriceFromSummary();

        Assert.assertTrue(checkoutShippingMethodPage.myPrestashopSelected());
        Assert.assertEquals(myPrestashopValue, myPrestashopInSummary);

        checkoutShippingMethodPage.selectMyCheapCarrier();
        Double myCheapCarrierValue = checkoutShippingMethodPage.getPriceFromShippingOption();
        Double myCheapCarrierInSummary = checkoutShippingMethodPage.getPriceFromSummary();

        Assert.assertTrue(checkoutShippingMethodPage.myCheapCarrierIsSelected());
        Assert.assertEquals(myCheapCarrierValue, myCheapCarrierInSummary);

        CheckoutPaymentPage checkoutPaymentPage = checkoutShippingMethodPage.continueOnShippingMethodPage();

        Assert.assertTrue(checkoutPaymentPage.getPaymentOptions().isDisplayed());

    }

}
