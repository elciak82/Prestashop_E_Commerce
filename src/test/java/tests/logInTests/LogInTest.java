package tests.logInTests;

import helpers.Configuration;
import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.AccountPage;
import pages.LoginPage;
import tests.BaseTest;

public class LogInTest extends BaseTest {

    @Test(description = "Correct log in to the account.")
    @Description("Test verifying correct log in to the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-11")
    @Parameters("browser: chrome")
    public void correctLogInToAccountTest() {
        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();

        header.clickOnLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn_fillData(email, password);
        loginPage.clickOnSignInButton();

        String firstName = Configuration.getConfiguration().getFirstname();
        String lastname = Configuration.getConfiguration().getLastname();
        String loggedUserData = firstName + " " + lastname;

        Assert.assertEquals(header.getUserFirstnameLastnameFromPage(), loggedUserData);
    }

    @Test(description = "Correct log out from the account.")
    @Description("Test verifying correct log out from the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-12")
    @Parameters("browser: chrome")
    public void correctLogInAndLogOutFromAccountTest() {

        header.clickOnLoginLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.correctLogInToAccount();
        loginPage.logOutFromAccount();

        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.LOGIN_PAGE.getPageTitle());

    }

}
