package tests.login;

import helpers.Configuration;
import helpers.enums.AlertEnums;
import helpers.enums.PageTitleEnums;

import helpers.providers.AddressFactory;
import helpers.providers.UserProvider;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;

import mysqlconnection.Queries;
import org.testng.Assert;
import org.testng.annotations.*;

import webui.components.HeaderComponent;
import webui.pages.ForgotYourPasswordPage;
import webui.pages.LoginPage;
import tests.BaseTest;

import java.lang.reflect.Method;
import java.sql.SQLException;

public class LogInTests extends BaseTest {
    HeaderComponent header;
    LoginPage loginPage;
    ForgotYourPasswordPage forgotYourPasswordPage;

    @BeforeMethod
    public void signIn() {
        header = new HeaderComponent(driver);
        header.clickOnSignIn();

        loginPage = new LoginPage(driver);
        forgotYourPasswordPage = new ForgotYourPasswordPage(driver);
    }

    @BeforeMethod()
    public void name(Method method) {
        System.out.println("Test name is: " + method.getName());
        System.out.println("Test description is: " + method.getAnnotation(Test.class).testName());
    }


    @AfterMethod
    public void logOut() {
        header.clickOnSignOut();
        System.out.println("Log out from the account.");
    }

    @Test(testName = "Correct log in to the account.", description = "Behavior = Positive")
    @Description("Test verifying correct log in to the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-11")
    @Parameters("browser: chrome")
    public void correctLogInToAccountTest() {
        String email = user.getUsername();
        String password = user.getPassword();

        loginPage
                .logIn_fillData(email, password)
                .clickOnSignInButton();

        String firstName = user.getFirstname();
        String lastName = user.getLastname();

        String loggedUserData = firstName + " " + lastName;

        Assert.assertEquals(header.getUserFirstnameLastnameFromPage(), loggedUserData);

    }

    @Test(testName = "Correct log out from the account.", description = "Behavior = Positive")
    @Description("Test verifying correct log out from the account - the user has an account.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-12")
    @Parameters("browser: chrome")
    public void correctLogInAndLogOutFromAccountTest() {
        loginPage.correctLogInToAccount();
        header.clickOnSignOut();

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

        loginPage
                .logIn_fillData(email, password)
                .clickOnSignInButton();

        Assert.assertEquals(loginPage.getAlertText(), AlertEnums.AlertMessages.AUTHENTICATION_FIELD.getAlertMessage());
    }

    @Test(testName = "User forgot the password.", description = "Behavior = Negative")
    @Description("Test verifying behavior when the user forgot the password.")
    @Severity(SeverityLevel.NORMAL)
    @TmsLink("PRESTASHOP-14")
    @Parameters("browser: chrome")
    public void forgotPasswordTest() {
        String email = "email@email.com";

        loginPage
                .clickOnForgetPasswordButton()
                .insertEmail(email)
                .clickOnSendResetLinkButton();

        Assert.assertEquals(forgotYourPasswordPage.getResetYourPasswordAlertText(), AlertEnums.AlertMessages.RESET_YOUR_PASSWORD.getAlertMessage() + " " + email + ".");
    }

}
