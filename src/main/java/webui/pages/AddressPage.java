package webui.pages;

import helpers.models.Address;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class AddressPage extends BasePage {
    public AddressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "field-alias")
    WebElement fieldAlias;

    @FindBy(id = "field-company")
    WebElement fieldCompany;

    @FindBy(id = "field-address1")
    WebElement fieldAddress1;

    @FindBy(id = "field-address2")
    WebElement fieldAddressComplement;

    @FindBy(id = "field-city")
    WebElement fieldCity;

    @FindBy(id = "field-id_state")
    WebElement fieldState;

    @FindBy(id = "field-postcode")
    WebElement fieldZip;

    @FindBy(id = "field-id_country")
    WebElement fieldCountry;

    @FindBy(id = "field-phone")
    WebElement fieldPhone;

    @FindBy(xpath = "//*[@id='content']/div/div/form/footer/button")
    WebElement saveButton;

    @FindBy(css = "[data-link-action='add-address']")
    WebElement createNewAddressButton;

    @FindBy(css = "[class*='alert']")
    WebElement successAlert;

    @Step("Fill required fields: {method}")
    public void fillRequiredFieldsAddressForm(Address address) {
        fieldAlias.isDisplayed();
        fieldAddress1.sendKeys(address.getCustomerAddress());
        fieldCity.sendKeys(address.getCustomerCity());
        fieldState.sendKeys(address.getCustomerState());
        fieldZip.sendKeys(address.getCustomerZip());
        fieldCountry.sendKeys(address.getCustomerCountry());
    }

    @Step("Add the new Customer address - only required fields.")
    public void addNewCustomerAddress(Address address) {
        fillRequiredFieldsAddressForm(address);
        clickOnSaveButton();
    }

    @Step("Click on the Save button.")
    public void clickOnSaveButton() {
        saveButton.click();
    }

    @Step("Click on the create new address button.")
    public void clickOnCreateNewAddressButton() {
        createNewAddressButton.click();
    }

    @Step("Get alert text.")
    public String getSuccessAlertText(){
        return successAlert.getText();
    }

}
