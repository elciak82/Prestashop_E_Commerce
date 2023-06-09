package webui.pages;

import helpers.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Checkbox;
import webui.pageobject.element.controls.EditField;
import webui.pageobject.element.controls.RadioButton;

public class CreateAccountPage extends HeaderComponent {
    private final RadioButton genderMrRadioButton;
    private final RadioButton genderMrsRadioButton;
    private final EditField customerFirstNameField;
    private final EditField customerLastNameField;
    private final EditField customerEmailField;
    private final EditField customerPasswordField;
    private final EditField customerBirthDateField;
    private final Checkbox privacyCheckbox;
    private final Checkbox termsAndConditionsCheckbox;
    private final Button saveButton;

    public CreateAccountPage(WebDriver driver) {
        super(driver);
        genderMrRadioButton = new RadioButton(driver.findElement(By.id("field-id_gender-1")));
        genderMrsRadioButton = new RadioButton(driver.findElement(By.id("field-id_gender-2")));
        customerFirstNameField = new EditField(driver.findElement(By.id("field-firstname")));
        customerLastNameField = new EditField(driver.findElement(By.id("field-lastname")));
        customerEmailField = new EditField(driver.findElement(By.id("field-email")));
        customerPasswordField = new EditField(driver.findElement(By.id("field-password")));
        customerBirthDateField = new EditField(driver.findElement(By.id("field-birthday")));
        privacyCheckbox = new Checkbox(driver.findElement(By.cssSelector("[name='customer_privacy']")));
        termsAndConditionsCheckbox = new Checkbox(driver.findElement(By.cssSelector("[name='psgdpr']")));
        saveButton = new Button(driver.findElement(By.cssSelector("[data-link-action='save-customer']")));
    }

    @Step("Fill required fields: {method}")
    public void fillRequiredPersonalData(Customer customer) {
        customerLastNameField.isDisplayed();
        setCustomerFirstName(customer.getCustomerFirstName());
        setCustomerLastName(customer.getCustomerLastName());
        setCustomerEmail(customer.getCustomerEmail());
        setCustomerPassword(customer.getCustomerPassword());
        privacyCheckbox.click();
        termsAndConditionsCheckbox.click();
    }

    @Step("Fill all fields: {method}")
    public void fillAllPersonalData(Customer customer, String gender) {
        customerLastNameField.isDisplayed();

        if (gender.equals("Mr")) {
            genderMrRadioButton.click();
        } else
            genderMrsRadioButton.click();

        setCustomerFirstName(customer.getCustomerFirstName());
        setCustomerLastName(customer.getCustomerLastName());
        setCustomerEmail(customer.getCustomerEmail());
        setCustomerPassword(customer.getCustomerPassword());
        setCustomerBirthday(customer.getCustomerBirthday().toString());
        privacyCheckbox.click();
        termsAndConditionsCheckbox.click();
    }

    @Step("Create an account Step with required fields: {method}")
    public void createAnAccountRequiredFields(Customer customer) {
        fillRequiredPersonalData(customer);
        saveButton.click();
    }

    @Step("Create an account Step with all fields: {method}")
    public AccountPage createAnAccountAllFields(Customer customer, String gender) {
        fillAllPersonalData(customer, gender);
        saveButton.click();
        return new AccountPage(driver);
    }

    public String getValidationMessageForFirstname() {
        return customerFirstNameField.getBaseElement().getAttribute("validationMessage");
    }

    @Step("Click on the Save button")
    public void clickOnSaveButton() {
        saveButton.click();
    }

    @Step("Check if the Save button is visible")
    public boolean saveButtonIsVisible() {
        return saveButton.getBaseElement().isDisplayed();
    }

    public CreateAccountPage setCustomerFirstName(String firstName) {
        customerFirstNameField.setText(firstName);
        return this;
    }

    public CreateAccountPage setCustomerLastName(String lastName) {
        customerLastNameField.setText(lastName);
        return this;
    }

    public CreateAccountPage setCustomerEmail(String email) {
        customerEmailField.setText(email);
        return this;
    }
    public CreateAccountPage setCustomerPassword(String password) {
        customerPasswordField.setText(password);
        return this;
    }

    public CreateAccountPage setCustomerBirthday(String birthday) {
        customerBirthDateField.setText(birthday);
        return this;
    }

    @Step("Check the alert text")
    public String getAlertInvalidFormatText() {
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement element = driver.findElement(By.cssSelector("[class='alert alert-danger']"));
        return element.getText();
    }

    @Step("Check the password text")
    public String getPasswordText() {
        return customerPasswordField.getText();
    }

    public CreateAccountPage clearFirstnameField() {
        customerFirstNameField.clear();
        return this;
    }

    public CreateAccountPage clearLastnameField() {
        customerLastNameField.clear();
        return this;
    }

    public CreateAccountPage clearPasswordField() {
        customerPasswordField.clear();
        return this;
    }
}
