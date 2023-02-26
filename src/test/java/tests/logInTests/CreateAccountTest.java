package tests.logInTests;

import helpers.enums.ColumnNameEnums;
import helpers.enums.GenderEnums;
import helpers.providers.CustomerFactory;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import mysqlconnection.Queries;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.CreateAccountPage;
import pages.LoginPage;
import tests.BaseTest;

import java.sql.SQLException;

public class CreateAccountTest extends BaseTest {

    @Test(description = "Create an account - all fields.")
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


    @Test(description = "Create an account - only required fields.")
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
}
