package webui.pages;

import helpers.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.GenericPage;

public class CreateAccountPage extends GenericPage {
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-id_gender-1")
    WebElement genderMr;

    @FindBy(id = "field-id_gender-2")
    WebElement genderMrs;

    @FindBy(id = "field-firstname")
    WebElement customerFirstName;

    @FindBy(id = "field-lastname")
    WebElement customerLastName;

    @FindBy(id = "field-email")
    WebElement customerEmail;

    @FindBy(id = "field-password")
    WebElement customerPassword;

    @FindBy(id = "field-birthday")
    WebElement customerBirthDate;

    @FindBy(css = "[name='customer_privacy']")
    WebElement privacyCheckbox;

    @FindBy(css = "[name='psgdpr']")
    WebElement termsAndConditionsCheckbox;

    @FindBy(css = "[data-link-action='save-customer']")
    WebElement saveButton;

    @FindBy(css = "[class='alert alert-danger']")
    WebElement alertInvalidFormat;

    @FindBy(css = "[data-action='show-password']")
    WebElement showPasswordButton;


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
    public void createAnAccountAllFields(Customer customer, String gender) {
        fillAllFieldsInCreateAnAccountForm(customer, gender);
        saveButton.click();
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

    public void setCustomerFirstName(String firstName) {
        customerFirstName.sendKeys(firstName);
    }

    public void setCustomerLastName(String lastName) {
        customerLastName.sendKeys(lastName);
    }

    public void setCustomerPassword(String password) {
        customerPassword.sendKeys(password);
    }

    public void setCustomerBirthday(String birthday) {
        customerBirthDate.sendKeys(birthday);
    }

    @Step("Check the alert text")
    public String getAlertInvalidFormatText() {
        return alertInvalidFormat.getText();
    }

    @Step("Check the password text")
    public String getPasswordText() {
        return customerPassword.getText();
    }

    public void clearFirstnameField(){
        customerFirstName.clear();
    }

    public void clearLastnameField(){
        customerLastName.clear();
    }

    public void clearPasswordField(){
        customerPassword.clear();
    }

    public void showPasswordButtonClick(){
        showPasswordButton.click();
    }

}
