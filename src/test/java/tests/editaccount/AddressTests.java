package tests.editaccount;

import helpers.enums.*;
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
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webui.pages.AccountPage;
import webui.pages.AddressPage;
import webui.pages.CreateAccountPage;
import webui.pages.LoginPage;
import tests.BaseTest;

import java.sql.SQLException;

public class AddressTests extends BaseTest {

    @Test(testName = "Add a new Customer address - only required fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address only with required fields.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-24")
    @Parameters("browser: chrome")
    public void addNewAddressWithRequiredFieldsTest() throws SQLException {

        header.clickOnSignInLink().correctLogInToAccount().clickOnAddressesLink();

        AddressPage addressPage = new AddressPage(driver);
        addressPage.clickOnCreateNewAddressButton();

        AddressFactory addressFactory = new AddressFactory();
        addressPage.addNewCustomerAddress(addressFactory.getCustomerAddress_required(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());

        Queries queries = new Queries();
        queries.executeDelete(queries.deleteAddress(addressFactory.customerAddress()));

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
        addressPage.addNewCustomerAddress(addressFactory.getCustomerAddress_required(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());

        Queries queries = new Queries();
        queries.executeDelete(queries.deleteAddress(addressFactory.customerAddress()));

    }

}
