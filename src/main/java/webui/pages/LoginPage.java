package webui.pages;

import helpers.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class LoginPage extends HeaderComponent {

    @FindBy(id = "field-email")
    private WebElement emailField;

    @FindBy(id = "field-password")
    private WebElement passwordField;

    @FindBy(id = "submit-login")
    private WebElement signInButton;

    @FindBy(css = "[class*='alert']")
    private WebElement authenticationFailedAlert;

    @FindBy(className = "forgot-password")
    private WebElement forgotPasswordButton;

    @FindBy(className = "no-account")
    private WebElement createAccount;


    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailField() {
        return emailField;
    }

    public WebElement getPasswordField() {
        return passwordField;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getAuthenticationFailedAlert() {
        return authenticationFailedAlert;
    }

    public WebElement getForgotPasswordButton() {
        return forgotPasswordButton;
    }

    public WebElement getCreateAccount() {
        return createAccount;
    }

    @Step("Input correct email and password.")
    public LoginPage fillCredentials(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click on the Sign in button")
    public LoginPage clickOnSignInButton() {
        signInButton.click();
        return this;
    }

    @Step("Log in to account.")
    public AccountPage logInToAccount(String email, String password) {
        fillCredentials(email, password);
        clickOnSignInButton();
        return new AccountPage(driver);
    }

    @Step("Correct log in to an account.")
    public AccountPage correctLogInToAccount() {
        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();

        logInToAccount(email, password);
        return new AccountPage(driver);
    }

    @Step("Log out from an account.")
    public LoginPage logOutFromAccount() {
        signOut();
        return this;
    }

    @Step("Get alert text.")
    public String getAlertText() {
        return authenticationFailedAlert.getText();
    }

    @Step("Click on the Forgot your password? button.")
    public ForgotYourPasswordPage clickOnForgetPasswordButton() {
        forgotPasswordButton.click();
        return new ForgotYourPasswordPage(driver);
    }

    @Step("Click on the 'No account? Create one here.' link.")
    public void clickOnTheCreateAccountLink(){
        createAccount.click();
    }

}