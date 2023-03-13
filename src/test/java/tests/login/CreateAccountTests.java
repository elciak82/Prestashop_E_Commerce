package tests.login;

import helpers.enums.AlertEnums;
import helpers.enums.ColumnNameEnums;
import helpers.enums.GenderEnums;
import helpers.models.Customer;
import helpers.providers.CustomerFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import mysqlconnection.Queries;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import webui.pages.CreateAccountPage;
import webui.pages.LoginPage;
import tests.BaseTest;

import java.sql.SQLException;

public class CreateAccountTests extends BaseTest {

    @Test(testName = "Create an account - all fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of creating an account with all data.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-15")
    @Parameters("browser: chrome")
    public void createAccountAllFieldsTest() throws SQLException {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.createAnAccountAllFields(customerFactory.getCustomerToRegister_all(), GenderEnums.Gender.GENDER_MRS.getGender());

        String customerFirstNameLastName = header.getUserFirstnameLastnameFromPage();
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());

        Queries queries = new Queries();
        String lastNameResult = queries.checkSavedDataInDatabase(ColumnNameEnums.Columns.LAST_NAME_COLUMN.getColumnName(), ColumnNameEnums.Columns.EMAIL_COLUMN.getColumnName(), customerFactory.customerRandomEmail());
        Assert.assertEquals(lastNameResult, customerFactory.customerRandomLastName());
    }


    @Test(testName = "Create an account - only required fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of creating an account only with required data.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-16")
    @Parameters("browser: chrome")
    public void createAccountOnlyRequiredFieldsTest() throws SQLException {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.createAnAccountRequiredFields(customerFactory.getCustomerToRegister_required());

        String customerFirstNameLastName = header.getUserFirstnameLastnameFromPage();
        Assert.assertEquals(customerFirstNameLastName, customerFactory.getCustomerFirstNameLastName());

        Queries queries = new Queries();
        String lastNameResult = queries.checkSavedDataInDatabase(ColumnNameEnums.Columns.LAST_NAME_COLUMN.getColumnName(), ColumnNameEnums.Columns.EMAIL_COLUMN.getColumnName(), customerFactory.customerRandomEmail());
        Assert.assertEquals(lastNameResult, customerFactory.customerRandomLastName());
    }


    @Test(testName = "Try to create an account - all fields are empty.", description = "Behavior = Negative")
    @Description("Test verifying the app behaviour when the User tries to create an account when all fields are empty.")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-17")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_allFieldsAreEmpty() {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        createAccountPage.clickOnSaveButton();

        Assert.assertTrue(createAccountPage.saveButtonIsVisible());
    }

    @Test(testName = "Try to create an account - Firstname is incorrect.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with incorrect Firstname - warning message appears.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-18")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_firstnameIsIncorrect() {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(customerFactory.getCustomerToRegister_required());

        String incorrectFirstname = "1234567";
        Customer customer = new Customer();
        customer.setCustomerFirstName(incorrectFirstname);
        createAccountPage.setCustomerFirstName(incorrectFirstname);

        createAccountPage.clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_FORMAT.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Lastname is incorrect.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with incorrect Lastname - warning message appears.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-19")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_lastnameIsIncorrect() {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(customerFactory.getCustomerToRegister_required());

        String incorrectLastname = "1234567";
        Customer customer = new Customer();
        customer.setCustomerLastName(incorrectLastname);
        createAccountPage.setCustomerFirstName(incorrectLastname);

        createAccountPage.clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_FORMAT.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Firstname is too long.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with too long Firstname (more than 255 characters) - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-20")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_firstnameIsTooLong() {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(customerFactory.getCustomerToRegister_required());

        String tooLongFirstname = CustomerFactory.randomAlphaString(256);
        Customer customer = new Customer();
        customer.setCustomerFirstName(tooLongFirstname);
        createAccountPage.clearFirstnameField();
        createAccountPage.setCustomerFirstName(tooLongFirstname);

        createAccountPage.clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.FIRST_NAME_TOO_LONG.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Lastname is too long.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with too long Lastname (more than 255 characters) - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-21")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_lastnameIsTooLong() {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(customerFactory.getCustomerToRegister_required());

        String tooLongLastname = CustomerFactory.randomAlphaString(256);
        Customer customer = new Customer();
        customer.setCustomerLastName(tooLongLastname);
        createAccountPage.clearLastnameField();
        createAccountPage.setCustomerLastName(tooLongLastname);

        createAccountPage.clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.LAST_NAME_TOO_LONG.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Password is too long.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with too long Password (more than 72 characters) - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-22")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_passwordIsTooLong() {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(customerFactory.getCustomerToRegister_required());

        String tooLongPassword = CustomerFactory.randomAlphaString(73);
        Customer customer = new Customer();
        customer.setCustomerPassword(tooLongPassword);
        createAccountPage.clearPasswordField();
        createAccountPage.setCustomerPassword(tooLongPassword);

        createAccountPage.clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_PASSWORD.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Birthdate is incorrect.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with an incorrect Birthdate - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-23")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_birthdateIsInvalid() {

        header.clickOnSignInLink();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnTheCreateAccountLink();

        CreateAccountPage createAccountPage = new CreateAccountPage(driver);
        CustomerFactory customerFactory = new CustomerFactory();
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(customerFactory.getCustomerToRegister_required());

        String invalidBirthday = CustomerFactory.randomAlphaString(9);
        Customer customer = new Customer();
        customer.setCustomerBirthday(invalidBirthday);
        createAccountPage.setCustomerBirthday(invalidBirthday);

        createAccountPage.clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_DATE_FORMAT.getAlertMessage());
    }

}
