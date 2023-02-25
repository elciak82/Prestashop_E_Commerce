package tests.logInTests;

import helpers.Configuration;
import helpers.enums.AlertEnums;
import helpers.enums.PageTitleEnums;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import pages.ForgotYourPasswordPage;
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

        header.clickOnSignInLink();
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

        header.clickOnSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.correctLogInToAccount();
        loginPage.logOutFromAccount();

        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.LOGIN_PAGE.getPageTitle());

    }

    @Test(description = "Incorrect log in to the account.")
    @Description("Test verifying incorrect log in to the account - the user has not an account.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-13")
    @Parameters("browser: chrome")
    public void incorrectLogInToAccountTest() {

        String email = "email@email.com";
        String password = "12345";

        header.clickOnSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.logIn_fillData(email, password);
        loginPage.clickOnSignInButton();

        Assert.assertEquals(loginPage.getAlertText(), AlertEnums.AlertMessageEnums.AUTHENTICATION_FIELD.getAlertMessage());

    }

    @Test(description = "User forgot the password.")
    @Description("Test verifying behaviour when the user forgot the password.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-14")
    @Parameters("browser: chrome")
    public void forgotPasswordTest() {

        String email = "email@email.com";

        header.clickOnSignInLink();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnForgetPasswordButton().insertEmail(email);
        ForgotYourPasswordPage forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
        forgotYourPasswordPage.clickOnSendResetLinkButton();

        Assert.assertEquals(forgotYourPasswordPage.getResetYourPasswordAlertText(), AlertEnums.AlertMessageEnums.RESET_YOUR_PASSWORD.getAlertMessage() + " " + email + ".");

    }

}
