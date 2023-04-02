package tests.editaccount;

import helpers.enums.*;
import helpers.models.Address;
import helpers.providers.AddressFactory;
import io.qameta.allure.*;
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
    HeaderComponent header;

    @BeforeMethod(description = "Creating a new Address")
//cannot insert a new customer - a password issue in the prestashop
    public void createNewAddress() {
        newAddress = AddressFactory.getCustomerAddress(CountryEnums.Country.UNITED_STATES, StateEnums.State.ALABAMA);
        System.out.println("Create address");
    }

    @BeforeMethod(description = "Log In to the account")
    public void logIn() {
        header = new HeaderComponent(driver);
        customerEmail = "noaddress@noaddress.com";
        customerPasswd = "noaddress";

        header.clickOnSignInLink()
                .logInToAccount(customerEmail, customerPasswd).clickOnAddressesLink();
        System.out.println("Log in");

        addressPage = new AddressPage(driver);
    }

    @AfterMethod(description = "Deleting customer address")
    public void deleteNewAddress() throws SQLException {
        statement.executeUpdate("DELETE FROM prestashop.address WHERE address1 = '" + AddressFactory.customerAddress() + "'");
        System.out.println("Delete address");
    }

    @AfterMethod(description = "Log Out from the account")
    public void logOut() {
        header.clickOnSignOutLink();
        System.out.println("Log out");
    }


    @Test(testName = "Add a new Customer address - only required fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address only with required fields.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-24")
    @Parameters("browser: chrome")
    public void addNewAddressWithRequiredFieldsTest() {
        addressPage.addNewCustomerAddress(AddressFactory.getCustomerAddressRequired(CountryEnums.Country.UNITED_STATES, StateEnums.State.AA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());
    }

    @Test(testName = "Add a new Customer address - all fields for United States.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of adding a new customer address with all fields - United States.")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-25")
    @Parameters("browser: chrome")
    public void addNewAddressWithAllFields_UnitedStatesTest() {
        addressPage.addNewCustomerAddress(AddressFactory.getCustomerAddressAllForUnitedStates(StateEnums.State.ALABAMA));

        Assert.assertEquals(AlertEnums.AlertMessages.ADDRESS_SUCCESSFULLY_ADDED.getAlertMessage(), addressPage.getSuccessAlertText());
    }

}
