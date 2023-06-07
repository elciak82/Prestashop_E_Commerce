package tests.shopping.checkout.payments.account.poland;

import helpers.enums.CountryEnums;
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
import webui.pages.CheckoutPaymentPage;
import webui.pages.CheckoutShippingMethodPage;
import webui.pages.HomePage;
import webui.pages.OrderConfirmationPage;

import java.sql.SQLException;

public class PaymentTests extends BaseTest {
    ProductMiniatureComponent productMiniature;
    Customer customer;
    HomePage homePage;
    Queries queries;
    Address address;
    CheckoutShippingMethodPage checkoutShippingMethodPage;

    @BeforeMethod
    public void addProductToCart() {

        homePage = new HomePage(driver);
        customer = CustomerFactory.getCustomerToRegisterRequired();
        address = AddressFactory.getCustomerAddressWithRequiredFieldsForPoland(CountryEnums.Country.POLAND);

        productMiniature = homePage
                .getProductList()
                .getAllProductsMiniatures()
                .get(2);

        checkoutShippingMethodPage = productMiniature
                .selectProduct()
                .addProductToCart()
                .proceedToCheckout()
                .proceedToCheckoutOnCartPage()
                .fillRequiredPersonalInformation(customer)
                .continueCheckoutOnPersonalInfoPage()
                .fillRequiredFieldsAddressFormForPoland(address)
                .continueCheckoutOnDeliveryAddressPage()
                .selectMyCheapCarrier();

    }

    @AfterMethod
    public void logOutMethod() {
        homePage.logOut();
    }

    @AfterMethod
    public void deleteNewCustomer() throws SQLException {
        queries = new Queries();
        statement.executeUpdate(queries.deleteCustomer(customer.getCustomerLastName()));
        System.out.println("Delete customer form the database.");
    }

    @Test(testName = "Proceed checkout - select a payment option for Poland, new account has been created.", description = "Behavior = Positive")
    @Description("Test verifying the checkout process - select a payment method for Poland.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-..")
    @Parameters("browser: chrome")
    public void selectPaymentMethodForPolandWithoutCreatingAccount() {

        CheckoutPaymentPage paymentPage = checkoutShippingMethodPage
                .continueOnShippingMethodPage();
        Assert.assertTrue(paymentPage.getPaymentOptions().isDisplayed());

        paymentPage.selectPayByCheck();
        Assert.assertTrue(paymentPage.payByCheckIsSelected());

        paymentPage.selectPayByBankWire();
        Assert.assertTrue(paymentPage.payByBankWireIsSelected());

        paymentPage.checkTermsOfService();
        Assert.assertTrue(paymentPage.placeOrderButtonIsEnabled());

        OrderConfirmationPage orderConfirmationPage = paymentPage.confirmPlaceOrder();
        Assert.assertTrue(orderConfirmationPage.getOrderConfirmation().isDisplayed());

        Assert.assertEquals(orderConfirmationPage.getUserFirstnameLastnameFromPage(), customer.getCustomerFirstName() + " " + customer.getCustomerLastName());

    }

}
