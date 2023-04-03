package webui.pages;

import helpers.Configuration;
import helpers.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.components.WebEntity;

public class LoginPage extends WebEntity {

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
        header = new HeaderComponent(driver);
        PageFactory.initElements(driver, this);
    }

    private final HeaderComponent header;


    @Step("Input correct email and password.")
    public LoginPage logIn_fillData(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        return this;
    }

    @Step("Click on the Sign in button")
    public AccountPage clickOnSignInButton() {
        signInButton.click();
        return new AccountPage(driver);
    }

    @Step("Log in to account.")
    public AccountPage logInToAccount(String email, String password) {
        logIn_fillData(email, password);
        signInButton.click();
        return new AccountPage(driver);
    }

    @Step("Correct log in to an account.")
    public AccountPage correctLogInToAccount() {
        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();

        logInToAccount(email, password);
        return new AccountPage(driver);
    }

    @Step("Correct log in to an account - new customer.")
    public AccountPage correctLogInToAccountByNewCustomer(Customer customer) {
        String email = customer.getCustomerEmail();
        String password = customer.getCustomerPassword();

        logInToAccount(email, password);
        return new AccountPage(driver);
    }

    @Step("Correct log in to an account - customer without an address.")
    public AccountPage logInToAccountByCustomerWithoutAddress() {
        String email = Configuration.getConfiguration().getNoAddressEmail();
        String password = Configuration.getConfiguration().getNDefaultPassword();

        logInToAccount(email, password);
        return new AccountPage(driver);
    }

    @Step("Get alert text.")
    public String getAlertText() {
        return authenticationFailedAlert.getText();
    }

    @Step("Click on the Forgot your password? button.")
    public ForgotYourPasswordPage clickOnForgetPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(forgotPasswordButton));
        forgotPasswordButton.click();
        return new ForgotYourPasswordPage(driver);
    }

    @Step("Click on the 'No account? Create one here.' link.")
    public void clickOnCreateAccountLink(){
        createAccount.click();
    }

}