package webui.pages;

import helpers.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Checkbox;
import webui.pageobject.element.controls.EditField;
import webui.pageobject.element.controls.RadioButton;

public class CheckoutPersonalInfoPage extends HeaderComponent {
    private final RadioButton genderMrRadioButton;
    private final RadioButton genderMrsRadioButton;
    private final EditField customerFirstNameField;
    private final EditField customerLastNameField;
    private final EditField customerEmailField;
    private final EditField customerPasswordField;
    private final EditField customerBirthDateField;
    private final Checkbox privacyCheckbox;
    private final Checkbox termsAndConditionsCheckbox;
    private final Button continueButton;

    public CheckoutPersonalInfoPage(WebDriver driver) {

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
        continueButton = new Button(driver.findElement(By.cssSelector("[data-link-action='register-new-customer']")));
    }


    public CheckoutPersonalInfoPage setCustomerFirstName(String firstName) {
        customerFirstNameField.setText(firstName);
        return this;
    }

    public CheckoutPersonalInfoPage setCustomerLastName(String lastName) {
        customerLastNameField.setText(lastName);
        return this;
    }

    public CheckoutPersonalInfoPage setCustomerEmail(String email) {
        customerEmailField.setText(email);
        return this;
    }
    public CheckoutPersonalInfoPage setCustomerPassword(String password) {
        customerPasswordField.setText(password);
        return this;
    }

    public CheckoutPersonalInfoPage setCustomerBirthday(String birthday) {
        customerBirthDateField.setText(birthday);
        return this;
    }

    @Step("Fill required fields: {method}")
    public CheckoutPersonalInfoPage fillRequiredPersonalInformation(Customer customer) {
        customerLastNameField.isDisplayed();
        setCustomerFirstName(customer.getCustomerFirstName());
        setCustomerLastName(customer.getCustomerLastName());
        setCustomerEmail(customer.getCustomerEmail());
        setCustomerPassword(customer.getCustomerPassword());
        privacyCheckbox.click();
        termsAndConditionsCheckbox.click();
        return this;
    }

    @Step("Fill required fields without password: {method}")
    public CheckoutPersonalInfoPage fillRequiredPersonalInformationWithoutPassword(Customer customer) {
        customerLastNameField.isDisplayed();
        setCustomerFirstName(customer.getCustomerFirstName());
        setCustomerLastName(customer.getCustomerLastName());
        setCustomerEmail(customer.getCustomerEmail());
        privacyCheckbox.click();
        termsAndConditionsCheckbox.click();
        return this;
    }

    public Button getContinueButton(){
        return continueButton;
    }

    public CheckoutAddressesPage continueCheckout(){
        getContinueButton().click();
        return new CheckoutAddressesPage(driver);
    }

}