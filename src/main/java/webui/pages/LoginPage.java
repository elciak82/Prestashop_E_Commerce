package webui.pages;

import helpers.Configuration;
import helpers.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.EditField;
import webui.pageobject.element.controls.Link;

import java.time.Duration;

public class LoginPage extends HeaderComponent {
    private final EditField emailField;
    private final EditField passwordField;
    private final Button signInButton;
    private final Link forgotPasswordLink;
    private final Link createAccountLink;

    public LoginPage(WebDriver driver) {
        super(driver);
        emailField = new EditField(driver.findElement(By.id("field-email")));
        passwordField = new EditField(driver.findElement(By.id("field-password")));
        signInButton = new Button(driver.findElement(By.id("submit-login")));
        forgotPasswordLink = new Link(driver.findElement(By.className("forgot-password")));
        createAccountLink = new Link(driver.findElement(By.className("no-account")));

    }

    @Step("Input an email.")
    public LoginPage setEmail(String email) {
        emailField.setText(email);
        return this;
    }

    @Step("Input a password.")
    public LoginPage setPassword(String password) {
        passwordField.setText(password);
        return this;
    }

    @Step("Get the sign in button.")
    public Button getSignButton() {
        return signInButton;
    }

    @Step("Get the forgot password link.")
    public Link getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    @Step("Get the create account link.")
    public Link getCreateAccountLink() {
        return createAccountLink;
    }

    @Step("Input correct email and password.")
    public LoginPage logIn_fillData(String email, String password) {
        setEmail(email);
        setPassword(password);
        return this;
    }

    @Step("Get alert text.")
    public String getAuthenticationFailedAlertText() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement authenticationFailedAlert = driver.findElement(By.cssSelector("[class*='alert']"));
        wait.until(ExpectedConditions.visibilityOf(authenticationFailedAlert));
        return authenticationFailedAlert.getText();
    }

    @Step("Click on the Sign in button")
    public AccountPage clickOnSignInButton() {
        getSignButton().click();
        return new AccountPage(driver);
    }

    @Step("Log in to account.")
    public AccountPage logInToAccount(String email, String password) {
        logIn_fillData(email, password);
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

    @Step("Click on the Forgot your password? button.")
    public ForgotYourPasswordPage clickOnForgetPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(getForgotPasswordLink().getBaseElement()));
        getForgotPasswordLink().click();
        return new ForgotYourPasswordPage(driver);
    }

    @Step("Click on the 'No account? Create one here.' link.")
    public void clickOnCreateAccountLink() {
        getCreateAccountLink().click();
    }

}