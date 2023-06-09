package tests.login;

import helpers.enums.MessagesEnums;
import helpers.enums.PageTitleEnums;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;

import org.testng.Assert;
import org.testng.annotations.*;

import webui.components.HeaderComponent;
import webui.pages.ForgotYourPasswordPage;
import webui.pages.LoginPage;
import tests.BaseTest;

import java.lang.reflect.Method;

public class LogInTests extends BaseTest {
    HeaderComponent header;
    LoginPage loginPage;
    ForgotYourPasswordPage forgotYourPasswordPage;

    @BeforeMethod
    public void signIn() {
        header = new HeaderComponent(driver);
        header.clickOnSignIn();
    }

    @BeforeMethod()
    public void name(Method method) {
        System.out.println("Test name is: " + method.getName());
        System.out.println("Test description is: " + method.getAnnotation(Test.class).testName());
    }

    @Test(testName = "Correct log in to the account.", description = "Behavior = Positive")
    @Description("Test verifying correct log in to the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-11")
    @Parameters("browser: chrome")
    public void correctLogInToAccountTest() {
        String email = user.getUsername();
        String password = user.getPassword();

        new LoginPage(driver)
                .logIn_fillData(email, password)
                .clickOnSignInButton();

        String firstName = user.getFirstname();
        String lastName = user.getLastname();

        String loggedUserData = firstName + " " + lastName;

        Assert.assertEquals(header.getUserFirstnameLastnameFromPage(), loggedUserData);

        header.getSignOutButton().click();

    }

    @Test(testName = "Correct log out from the account.", description = "Behavior = Positive")
    @Description("Test verifying correct log out from the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-12")
    @Parameters("browser: chrome")
    public void correctLogInAndLogOutFromAccountTest() {
        new LoginPage(driver).correctLogInToAccount();
        header.getSignOutButton().click();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.LOGIN_PAGE.getPageTitle());
    }

    @Test(testName = "Incorrect log in to the account.", description = "Behavior = Negative")
    @Description("Test verifying incorrect log in to the account - the user has not an account.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-13")
    @Parameters("browser: chrome")
    public void incorrectLogInToAccountTest() {
        String email = "email@email.com";
        String password = "12345";

        loginPage = new LoginPage(driver);
        loginPage
                .logIn_fillData(email, password)
                .clickOnSignInButton();

        Assert.assertEquals(loginPage.getAuthenticationFailedAlertText(), MessagesEnums.Messages.AUTHENTICATION_FIELD.getMessage());
    }

    @Test(testName = "User forgot the password.", description = "Behavior = Negative")
    @Description("Test verifying behavior when the user forgot the password.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-14")
    @Parameters("browser: chrome")
    public void forgotPasswordTest() {
        String email = "email@email.com";

        forgotYourPasswordPage = new LoginPage(driver)
                .clickOnForgetPasswordButton()
                .setEmailAddress(email)
                .clickOnSendResetLinkButton();

        Assert.assertEquals(forgotYourPasswordPage.getResetYourPasswordAlertText(), MessagesEnums.Messages.RESET_YOUR_PASSWORD.getMessage() + " " + email + ".");
    }

}
