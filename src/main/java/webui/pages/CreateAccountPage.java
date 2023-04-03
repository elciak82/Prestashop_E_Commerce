package webui.pages;

import helpers.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.components.WebEntity;

public class CreateAccountPage extends WebEntity {

    @FindBy(id = "field-id_gender-1")
    private WebElement genderMr;

    @FindBy(id = "field-id_gender-2")
    private WebElement genderMrs;

    @FindBy(id = "field-firstname")
    private WebElement customerFirstName;

    @FindBy(id = "field-lastname")
    private WebElement customerLastName;

    @FindBy(id = "field-email")
    private WebElement customerEmail;

    @FindBy(id = "field-password")
    private WebElement customerPassword;

    @FindBy(id = "field-birthday")
    private WebElement customerBirthDate;

    @FindBy(css = "[name='customer_privacy']")
    private WebElement privacyCheckbox;

    @FindBy(css = "[name='psgdpr']")
    private WebElement termsAndConditionsCheckbox;

    @FindBy(css = "[data-link-action='save-customer']")
    private WebElement saveButton;

    @FindBy(css = "[class='alert alert-danger']")
    private WebElement alertInvalidFormat;

    @FindBy(css = "[data-action='show-password']")
    private WebElement showPasswordButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Fill required fields: {method}")
    public void fillRequiredFieldsInCreateAnAccountForm(Customer customer) {
        customerLastName.isDisplayed();
        customerFirstName.sendKeys(customer.getCustomerFirstName());
        customerLastName.sendKeys(customer.getCustomerLastName());
        customerEmail.sendKeys(customer.getCustomerEmail());
        customerPassword.sendKeys(customer.getCustomerPassword());
        privacyCheckbox.click();
        termsAndConditionsCheckbox.click();
    }

    @Step("Fill all fields: {method}")
    public void fillAllFieldsInCreateAnAccountForm(Customer customer, String gender) {
        customerLastName.isDisplayed();

        if (gender.equals("Mr")) {
            genderMr.click();
        } else
            genderMrs.click();
        ;

        customerFirstName.sendKeys(customer.getCustomerFirstName());
        customerLastName.sendKeys(customer.getCustomerLastName());
        customerEmail.sendKeys(customer.getCustomerEmail());
        customerPassword.sendKeys(customer.getCustomerPassword());
        customerBirthDate.sendKeys(customer.getCustomerBirthday().toString());
        privacyCheckbox.click();
        termsAndConditionsCheckbox.click();
    }

    @Step("Create an account Step with required fields: {method}")
    public void createAnAccountRequiredFields(Customer customer) {
        fillRequiredFieldsInCreateAnAccountForm(customer);
        saveButton.click();
    }

    @Step("Create an account Step with all fields: {method}")
    public LoginPage createAnAccountAllFields(Customer customer, String gender) {
        fillAllFieldsInCreateAnAccountForm(customer, gender);
        saveButton.click();
        return new LoginPage(driver);
    }

    public String getValidationMessageForFirstname() {
        return customerFirstName.getAttribute("validationMessage");
    }

    @Step("Click on the Save button")
    public void clickOnSaveButton() {
        saveButton.click();
    }

    @Step("Check if the Save button is visible")
    public boolean saveButtonIsVisible() {
        boolean element = false;
        if (saveButton.isDisplayed()) {
            return element = true;
        }
        return false;
    }

    public CreateAccountPage setCustomerFirstName(String firstName) {
        customerFirstName.sendKeys(firstName);
        return this;
    }

    public CreateAccountPage setCustomerLastName(String lastName) {
        customerLastName.sendKeys(lastName);
        return this;
    }

    public CreateAccountPage setCustomerPassword(String password) {
        customerPassword.sendKeys(password);
        return this;
    }

    public CreateAccountPage setCustomerBirthday(String birthday) {
        customerBirthDate.sendKeys(birthday);
        return this;
    }

    @Step("Check the alert text")
    public String getAlertInvalidFormatText() {
        return alertInvalidFormat.getText();
    }

    @Step("Check the password text")
    public String getPasswordText() {
        return customerPassword.getText();
    }

    public CreateAccountPage clearFirstnameField(){
        customerFirstName.clear();
        return this;
    }

    public CreateAccountPage clearLastnameField(){
        customerLastName.clear();
        return this;
    }

    public CreateAccountPage clearPasswordField(){
        customerPassword.clear();
        return this;
    }

    public void showPasswordButtonClick(){
        showPasswordButton.click();
    }

}
