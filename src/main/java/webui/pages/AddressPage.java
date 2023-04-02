package webui.pages;

import helpers.models.Address;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AddressPage extends BasePage {

    @FindBy(id = "field-alias")
    private WebElement fieldAlias;

    @FindBy(id = "field-company")
    private WebElement fieldCompany;

    @FindBy(id = "field-address1")
    private WebElement fieldAddress1;

    @FindBy(id = "field-address2")
    private WebElement fieldAddressComplement;

    @FindBy(id = "field-city")
    private WebElement fieldCity;

    @FindBy(id = "field-id_state")
    private WebElement fieldState;

    @FindBy(id = "field-postcode")
    private WebElement fieldZip;

    @FindBy(id = "field-id_country")
    private WebElement fieldCountry;

    @FindBy(id = "field-phone")
    private WebElement fieldPhone;

    @FindBy(xpath = "//*[@id='content']/div/div/form/footer/button")
    private WebElement saveButton;

    @FindBy(css = "[data-link-action='add-address']")
    private WebElement createNewAddressButton;

    @FindBy(css = "[class*='alert']")
    private WebElement successAlert;

    public AddressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

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
        WebDriverWait wait = new WebDriverWait(driver, 2);
        wait.until(ExpectedConditions.visibilityOf(successAlert));
        return successAlert.getText();
    }

}
