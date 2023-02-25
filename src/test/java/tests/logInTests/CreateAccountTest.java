package tests.logInTests;

import helpers.enums.ColumnNameEnums;
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

    @Test(description = "Create an account - only required fields.")
    @Description("Test verifying the correctness of creating an account only with required data.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-15")
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
        String lastNameResult = queries.checkSavedDataInDatabase(ColumnNameEnums.ColumnEnums.LAST_NAME_COLUMN.getColumnName(), ColumnNameEnums.ColumnEnums.EMAIL_COLUMN.getColumnName(), customerFactory.customerRandomEmail());
        Assert.assertEquals(lastNameResult, customerFactory.customerRandomLastName());
    }
}
