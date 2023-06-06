package tests.shopping.checkout;

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

public class ShippingMethodsTests extends BaseTest {
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
    @TmsLink("PRESTASHOP-..")
    @Parameters("browser: chrome")
    public void selectShippingMethodForPoland() {

        CheckoutShippingMethodPage checkoutShippingMethodPage = checkoutDeliveryAddressPage
                .continueCheckoutOnDeliveryAddressPage()
                .selectMyCarrierPL();

        Assert.assertTrue(checkoutShippingMethodPage.myCarrierIsSelected());
//        Assert.assertEquals(checkoutShippingMethodPage.getShippingValue(), ///potrzebny timeout??
//                ShippingValueEnums.ShippingValue.MY_CARRIER.getShippingValue());

        checkoutShippingMethodPage.selectMyLightCarrier();

        Assert.assertTrue(checkoutShippingMethodPage.myLightCarrierIsSelected());
//        Assert.assertEquals(checkoutShippingMethodPage.getShippingValue(), ///potrzebny timeout??
//                ShippingValueEnums.ShippingValue.MY_LIGHT_CARRIER_PL.getShippingValue());

        checkoutShippingMethodPage.selectMyPrestashop();

        Assert.assertTrue(checkoutShippingMethodPage.myPrestashopSelected());
                Assert.assertEquals(checkoutShippingMethodPage.getShippingValue(),
                ShippingValueEnums.ShippingValue.MY_PRESTASHOP.getShippingValue());

        checkoutShippingMethodPage.selectMyCheapCarrier();

        Assert.assertTrue(checkoutShippingMethodPage.myCheapCarrierIsSelected());
//        Assert.assertEquals(checkoutShippingMethodPage.getShippingValue(), ///potrzebny timeout??
//                ShippingValueEnums.ShippingValue.MY_CHEAP_CARRIER.getShippingValue());

        CheckoutPaymentPage checkoutPaymentPage = checkoutShippingMethodPage.continueOnShippingMethodPage();

        Assert.assertTrue(checkoutPaymentPage.getPaymentOptions().isDisplayed());

    }

}
