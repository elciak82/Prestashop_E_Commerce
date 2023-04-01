package tests.editaccount;

import helpers.enums.*;
import helpers.models.Address;
import helpers.providers.AddressFactory;
import io.qameta.allure.*;
import mysqlconnection.Queries;
import org.testng.Assert;
import org.testng.annotations.*;
import webui.components.HeaderComponent;
import webui.pages.AddressPage;
import tests.BaseTest;

import java.sql.SQLException;

public class AddressTests extends BaseTest {

    Address newAddress;
    AddressPage addressPage;
    String customerEmail;
    String customerPasswd;
    String customerFirstName;
    HeaderComponent header;

    Queries queries = new Queries();

    @BeforeMethod(description = "Creating a new Address")
    //cannot insert a new customer - a password issue in the prestashop
    public void createNewAddress() {

        newAddress = AddressFactory.getCustomerAddress(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA);
        customerEmail = "noaddress@noaddress.com";
        customerPasswd = "noaddress";

        header = new HeaderComponent(driver);
        addressPage = new AddressPage(driver);

    }

    @AfterMethod
    // delete customer address
    public void deleteNewAddress() throws SQLException {
        statement.executeUpdate("DELETE FROM prestashop.address WHERE address1 = '" + AddressFactory.customerAddress() + "'");
    }


    @Test(testName = "Add a new Customer address - only required fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address only with required fields.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-24")
    @Parameters("browser: chrome")
    public void addNewAddressWithRequiredFieldsTest() {


        header.clickOnSignInLink()
                .logInToAccount(customerEmail, customerPasswd)
                .clickOnAddressesLink()
                .addNewCustomerAddress(AddressFactory.getCustomerAddressRequired(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());

        header.clickOnSignOutLink();
    }

    @Test(testName = "Add a new Customer address - all fields for United States.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address with all fields - United States.")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-25")
    @Parameters("browser: chrome")
    public void addNewAddressWithAllFields_UnitedStatesTest() throws SQLException {

//        header.clickOnSignInLink().correctLogInToAccount().clickOnAddressesLink();

        AddressPage addressPage = new AddressPage(driver);
        addressPage.clickOnCreateNewAddressButton();

        addressPage.addNewCustomerAddress(AddressFactory.getCustomerAddressRequired(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());

//        Queries queries = new Queries();
//        queries.executeDelete(queries.deleteAddress(addressFactory.customerAddress()));

    }

}
