package tests.editaccount;

import helpers.enums.*;
import helpers.models.Customer;
import helpers.providers.AddressFactory;
import helpers.providers.CustomerFactory;
import io.qameta.allure.*;
import mysqlconnection.Queries;
import org.testng.Assert;
import org.testng.annotations.*;
import webui.components.HeaderComponent;
import webui.pages.AddressPage;
import tests.BaseTest;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AddressTests extends BaseTest {

    CustomerFactory customerFactory = new CustomerFactory();
    Customer newCustomer = new Customer();
    HeaderComponent header;

    Queries queries = new Queries();

    @BeforeClass (description = "Creating a new Customer")
    public void createNewCustomer() throws SQLException {
        ResultSet result = (statement.executeQuery("SELECT * FROM prestashop.address where address1 = 33333"));
        result.next();
        System.out.println(result.getString("address1"));


        //execute query
        newCustomer = customerFactory.getCustomerToRegisterRequired();
        statement.executeLargeUpdate(
                "INSERT INTO `prestashop.customer` SET " +
                "`id_shop_group`= 1, " +
                "`id_shop` = 1," +
                "`id_gender` = 0," +
                "`id_default_group` = 3," +
                "`id_lang` = 1," +
                "`id_risk` = 0," +
                "`company` = NULL," +
                "`siret` = NULL," +
                "`ape` = NULL," +
                "`firstname` = '" + newCustomer.getCustomerFirstName() + "'," +
                "`lastname` = '" + newCustomer.getCustomerLastName() + "'," +
                "`email` = '" + newCustomer.getCustomerEmail() + "'," +
                "`passwd` = '" + newCustomer.getCustomerPassword() + "'," +
                "`birthday` = NULL," +
                "`newsletter` = 0," +
                "`ip_registration_newsletter` = NULL," +
                "`optin` = 0," +
                "`website` = NULL," +
                "`outstanding_allow_amount` = 0," +
                "`show_public_prices` = 0," +
                "`max_payment_days` = 0," +
                "`note` = NULL," +
                "`active` = 1," +
                "`is_guest` = 0," +
                "`deleted` = 0," +
                "`date_add` = '2023-02-27 20:33:20'," +
                "`date_upd` = '2023-02-27 20:33:20'");
        System.out.println(newCustomer.getCustomerFirstName());

//        ResultSet result = (statement.executeQuery("SELECT * FROM prestashop.address where firstname = '" + newCustomer.getCustomerFirstName() + "'"));
//        result.next();
//        System.out.println(result.getString("firstname"));

        header = new HeaderComponent(driver);

    }
    @BeforeMethod
    // create customer address

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

        System.out.println(addressFactory.customerAddress());

        Queries queries = new Queries();
//        queries.executeDelete(queries.deleteAddress(addressFactory.customerAddress()));
        statement.executeUpdate("DELETE FROM prestashop.address WHERE address1 = '" + addressFactory.customerAddress() + "'");
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
