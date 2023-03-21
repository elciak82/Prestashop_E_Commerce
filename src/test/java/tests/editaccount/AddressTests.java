package tests.editaccount;

import helpers.enums.*;
import helpers.models.Address;
import helpers.providers.AddressFactory;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.*;
import webui.pages.AddressPage;
import tests.BaseTest;
import webui.pages.HomePage;

import java.sql.SQLException;

public class AddressTests extends BaseTest {

    @BeforeClass (description = "Creating new Customer")
    // create new Customer

    @AfterMethod
    // delete customer address

    @AfterClass
    // delete Customer

    @Test(testName = "Add a new Customer address - only required fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address only with required fields.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-24")
    @Parameters("browser: chrome")
    public void addNewAddressWithRequiredFieldsTest() {
        Address address = new AddressFactory()
                .getCustomerAddressWithRequiredFields(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA);

        AddressPage addressPage = new HomePage(driver)
                .goToLoginPage()
                .correctLogInToAccount()
                .openAdressPage()
                .clickOnCreateNewAddressButton()
                .addNewCustomerAddress(address);

        Assert.assertEquals(
                AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(),
                addressPage.getSuccessAlertText()
        );
    }

    @Test(testName = "Add a new Customer address - all fields for United States.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address with all fields - United States.")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-25")
    @Parameters("browser: chrome")
    public void addNewAddressWithAllFields_UnitedStatesTest() {
        Address address = new AddressFactory()
                .getCustomerAddressWithRequiredFields(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA);

        AddressPage addressPage = new HomePage(driver)
                .goToLoginPage()
                .correctLogInToAccount()
                .openAdressPage()
                .clickOnCreateNewAddressButton()
                .addNewCustomerAddress(address);

        Assert.assertEquals(
                AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(),
                addressPage.getSuccessAlertText()
        );

//        Queries queries = new Queries();
//        queries.executeDelete(queries.deleteAddress(addressFactory.customerAddress()));
    }

}
