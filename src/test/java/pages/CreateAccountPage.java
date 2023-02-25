package pages;

import helpers.models.Customer;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccountPage extends GenericPage{
    public CreateAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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


    @Step("Create an account Step with required fields: {method}")
    public void fillAllRequiredFieldsInCreateAnAccountForm(Customer customer) {
        customerLastName.isDisplayed();
        customerFirstName.sendKeys(customer.getCustomerFirstName());
        customerLastName.sendKeys(customer.getCustomerLastName());
        customerEmail.sendKeys(customer.getCustomerEmail());
        customerPassword.sendKeys(customer.getCustomerPassword());
        privacyCheckbox.click();
        termsAndConditionsCheckbox.click();
    }

    @Step("Create an account Step with required fields: {method}")
    public void createAnAccountRequiredFields(Customer customer) {
        fillAllRequiredFieldsInCreateAnAccountForm(customer);
        saveButton.click();
    }
}
