package tests.login;

import helpers.enums.AlertEnums;
import helpers.enums.GenderEnums;
import helpers.models.Customer;
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
import webui.components.HeaderComponent;
import webui.pages.CreateAccountPage;
import tests.BaseTest;

import java.lang.reflect.Method;
import java.sql.SQLException;

public class CreateAccountTests extends BaseTest {
    HeaderComponent header;
    CreateAccountPage createAccountPage;
    Queries queries;
    Customer customer;

    @BeforeMethod
    public void clickOnCreateAccount() {
        header = new HeaderComponent(driver);
        header.clickOnSignIn()
                .clickOnCreateAccountLink();
        System.out.println("Click on the create account link.");

        createAccountPage = new CreateAccountPage(driver);
        customer = new Customer();
    }

    @BeforeMethod()
    public void name(Method method) {
        System.out.println("Test name is: " + method.getName());
        System.out.println("Test description is: " + method.getAnnotation(Test.class).testName());
    }

    @AfterMethod
    public void deleteNewCustomer() throws SQLException {
        queries = new Queries();
        statement.executeUpdate(queries.deleteCustomer(CustomerFactory.customerRandomLastName()));
        System.out.println("Delete customer form the database.");
    }

    @Test(testName = "Create an account - all fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of creating an account with all data.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-15")
    @Parameters("browser: chrome")
    public void createAccountAllFieldsTest() {
        createAccountPage.createAnAccountAllFields(CustomerFactory.getCustomerToRegister_all(), GenderEnums.Gender.GENDER_MRS.getGender());

        Assert.assertEquals(header.getUserFirstnameLastnameFromPage(), CustomerFactory.getCustomerFirstNameLastName());

        header.getSignOutButton();
    }

    @Test(testName = "Create an account - only required fields.", description = "Behavior = Positive")
    @Description("Test verifying the correctness of creating an account only with required data.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-16")
    @Parameters("browser: chrome")
    public void createAccountOnlyRequiredFieldsTest() {
        createAccountPage.createAnAccountRequiredFields(CustomerFactory.getCustomerToRegisterRequired());

        Assert.assertEquals(header.getUserFirstnameLastnameFromPage(), CustomerFactory.getCustomerFirstNameLastName());

        header.getSignOutButton();
    }

    @Test(testName = "Try to create an account - all fields are empty.", description = "Behavior = Negative")
    @Description("Test verifying the app behaviour when the User tries to create an account when all fields are empty.")
    @Severity(SeverityLevel.MINOR)
    @TmsLink("PRESTASHOP-17")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_allFieldsAreEmpty() {
        createAccountPage.clickOnSaveButton();

        Assert.assertTrue(createAccountPage.saveButtonIsVisible());
    }

    @Test(testName = "Try to create an account - Firstname is incorrect.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with incorrect Firstname - warning message appears.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-18")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_firstnameIsIncorrect() {
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(CustomerFactory.getCustomerToRegisterRequired());

        String incorrectFirstname = "1234567";
        customer.setCustomerFirstName(incorrectFirstname);
        createAccountPage
                .setCustomerFirstName(incorrectFirstname)
                .clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_FORMAT.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Lastname is incorrect.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with incorrect Lastname - warning message appears.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-19")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_lastnameIsIncorrect() {
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(CustomerFactory.getCustomerToRegisterRequired());

        String incorrectLastname = "1234567";
        customer.setCustomerLastName(incorrectLastname);
        createAccountPage
                .setCustomerFirstName(incorrectLastname)
                .clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_FORMAT.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Firstname is too long.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with too long Firstname (more than 255 characters) - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-20")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_firstnameIsTooLong() {
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(CustomerFactory.getCustomerToRegisterRequired());

        String tooLongFirstname = CustomerFactory.randomAlphaString(256);
        customer.setCustomerFirstName(tooLongFirstname);
        createAccountPage
                .clearFirstnameField()
                .setCustomerFirstName(tooLongFirstname)
                .clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.FIRST_NAME_TOO_LONG.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Lastname is too long.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with too long Lastname (more than 255 characters) - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-21")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_lastnameIsTooLong() {
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(CustomerFactory.getCustomerToRegisterRequired());

        String tooLongLastname = CustomerFactory.randomAlphaString(256);
        customer.setCustomerLastName(tooLongLastname);
        createAccountPage
                .clearLastnameField()
                .setCustomerLastName(tooLongLastname)
                .clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.LAST_NAME_TOO_LONG.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Password is too long.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with too long Password (more than 72 characters) - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-22")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_passwordIsTooLong() {
        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(CustomerFactory.getCustomerToRegisterRequired());

        String tooLongPassword = CustomerFactory.randomAlphaString(73);
        customer.setCustomerPassword(tooLongPassword);
        createAccountPage
                .clearPasswordField()
                .setCustomerPassword(tooLongPassword)
                .clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_PASSWORD.getAlertMessage());
    }

    @Test(testName = "Try to create an account - Birthdate is incorrect.", description = "Behavior = Negative")
    @Description("Test verifying the app behavior when the User tries to create an account with an incorrect Birthdate - warning message appears.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-23")
    @Parameters("browser: chrome")
    public void tryToCreateAccount_birthdateIsInvalid() {

        createAccountPage.fillRequiredFieldsInCreateAnAccountForm(CustomerFactory.getCustomerToRegisterRequired());

        String invalidBirthday = CustomerFactory.randomAlphaString(9);
        customer.setCustomerBirthday(invalidBirthday);
        createAccountPage
                .setCustomerBirthday(invalidBirthday)
                .clickOnSaveButton();

        Assert.assertEquals(createAccountPage.getAlertInvalidFormatText(), AlertEnums.AlertMessages.INVALID_DATE_FORMAT.getAlertMessage());
    }

}
