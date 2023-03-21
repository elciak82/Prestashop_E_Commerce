package tests.login;

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

import webui.pages.AccountPage;
import webui.pages.ForgotYourPasswordPage;
import webui.pages.HomePage;
import webui.pages.LoginPage;
import tests.BaseTest;

public class LogInTests extends BaseTest {

    @Test(testName = "Correct log in to the account.", description = "Behavior = Positive")
    @Description("Test verifying correct log in to the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-11")
    @Parameters("browser: chrome")
    public void correctLogInToAccountTest() {
        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();

        AccountPage accountPage = new HomePage(driver)
                .goToLoginPage()
                .logInToAccount(email, password);

        String firstName = Configuration.getConfiguration().getFirstname();
        String lastname = Configuration.getConfiguration().getLastname();
        String loggedUserData = firstName + " " + lastname;

        Assert.assertEquals(accountPage.getUserFirstnameLastnameFromPage(), loggedUserData);
    }

    @Test(testName = "Correct log out from the account.", description = "Behavior = Positive")
    @Description("Test verifying correct log out from the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-12")
    @Parameters("browser: chrome")
    public void correctLogInAndLogOutFromAccountTest() {
        String title = new HomePage(driver)
                .goToLoginPage()
                .correctLogInToAccount()
                .goToLoginPage()
                .logOutFromAccount()
                .getPageTitle();

        Assert.assertEquals(title, PageTitleEnums.Titles.LOGIN_PAGE.getPageTitle());

    }

    @Test(testName = "Incorrect log in to the account.", description = "Behavior = Negative")
    @Description("Test verifying incorrect log in to the account - the user has not an account.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-13")
    @Parameters("browser: chrome")
    public void incorrectLogInToAccountTest() {
        String email = "email@email.com";
        String password = "12345";

        LoginPage loginPage = new HomePage(driver)
                .goToLoginPage()
                .fillCredentials(email, password)
                .clickOnSignInButton();

        Assert.assertEquals(
                loginPage.getAlertText(),
                AlertEnums.AlertMessages.AUTHENTICATION_FIELD.getAlertMessage()
        );

    }

    @Test(testName = "User forgot the password.", description = "Behavior = Negative")
    @Description("Test verifying behavior when the user forgot the password.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-14")
    @Parameters("browser: chrome")
    public void forgotPasswordTest() {

        String email = "email@email.com";

        header.goToLoginPage();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnForgetPasswordButton().insertEmail(email);
        ForgotYourPasswordPage forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
        forgotYourPasswordPage.clickOnSendResetLinkButton();

        Assert.assertEquals(forgotYourPasswordPage.getResetYourPasswordAlertText(), AlertEnums.AlertMessages.RESET_YOUR_PASSWORD.getAlertMessage() + " " + email + ".");

    }

}