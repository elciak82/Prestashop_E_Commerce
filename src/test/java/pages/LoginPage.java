package pages;

import helpers.Configuration;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.Header;


public class LoginPage extends GenericPage {
    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    Header header = new Header(driver);

    @FindBy(id = "field-email")
    WebElement emailField;

    @FindBy(id = "field-password")
    WebElement passwordField;

    @FindBy(id = "submit-login")
    WebElement signInButton;

    @Step("Input correct email and password.")
    public void logIn_fillData(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
    }

    @Step("Click on the Sign in button")
    public AccountPage clickOnSignInButton() {
        signInButton.click();
        return new AccountPage(driver);
    }

    @Step("Log in to account.")
    public void logInToAccount(String email, String password) {
        logIn_fillData(email, password);
        signInButton.click();
    }

    public AccountPage correctLogInToAccount() {
        String email = Configuration.getConfiguration().getEmail();
        String password = Configuration.getConfiguration().getPassword();

        logInToAccount(email, password);
        return new AccountPage(driver);
    }

    public void logOutFromAccount(){
        header.clickOnSignOutButton();
    }
}