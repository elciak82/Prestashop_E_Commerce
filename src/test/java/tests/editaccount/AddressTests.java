package tests.editaccount;

import helpers.enums.*;
import helpers.models.Customer;
import helpers.providers.AddressFactory;
import helpers.providers.CustomerFactory;
import io.qameta.allure.*;
import mysqlconnection.Queries;
import org.testng.Assert;
import org.testng.annotations.*;
import webui.pages.AddressPage;
import tests.BaseTest;

import java.sql.SQLException;

public class AddressTests extends BaseTest {

    CustomerFactory customerFactory = new CustomerFactory();
    Customer newCustomer = new Customer();

    @BeforeClass (description = "Creating a new Customer")
    public void createNewCustomer() throws SQLException {
        newCustomer = customerFactory.getCustomerToRegisterRequired();
        Queries queries = new Queries();
        queries.addNewCustomerToDatabase(newCustomer);

        //insert
    }
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
    public void addNewAddressWithRequiredFieldsTest() throws SQLException {


        header.clickOnSignInLink().correctLogInToAccountByNewCustomer(newCustomer).clickOnAddressesLink();

        AddressPage addressPage = new AddressPage(driver);
        addressPage.clickOnCreateNewAddressButton();

        AddressFactory addressFactory = new AddressFactory();
        addressPage.addNewCustomerAddress(addressFactory.getCustomerAddressRequired(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());

//        Queries queries = new Queries();
//        queries.executeDelete(queries.deleteAddress(addressFactory.customerAddress()));

    }

    @Test(testName = "Add a new Customer address - all fields for United States.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address with all fields - United States.")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-25")
    @Parameters("browser: chrome")
    public void addNewAddressWithAllFields_UnitedStatesTest() throws SQLException {

        header.clickOnSignInLink().correctLogInToAccount().clickOnAddressesLink();

        AddressPage addressPage = new AddressPage(driver);
        addressPage.clickOnCreateNewAddressButton();

        AddressFactory addressFactory = new AddressFactory();
        addressPage.addNewCustomerAddress(addressFactory.getCustomerAddressRequired(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());

//        Queries queries = new Queries();
//        queries.executeDelete(queries.deleteAddress(addressFactory.customerAddress()));

    }

}
