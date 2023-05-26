package webui.pages;

import helpers.enums.CountryEnums;
import helpers.enums.StateEnums;
import helpers.models.Address;
import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.EditField;


public class AddressPage extends HeaderComponent {

    EditField aliasField;
    EditField companyField;
    EditField address1Field;
    EditField addressComplementField;
    EditField cityField;
    EditField stateFiled;
    EditField zipField;
    EditField countryField;
    EditField phoneField;
    Button saveButton;

//    @FindBy(css = "[class*='alert']")
//    private WebElement successAlert; !!!!!
//
//    @FindBy(css = "[value='1']")
//    private WebElement AAstate;!!!

    public AddressPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        aliasField = new EditField(driver.findElement(By.id("field-alias")));
        companyField = new EditField(driver.findElement(By.id("field-company")));
        address1Field = new EditField(driver.findElement(By.id("field-address1")));
        addressComplementField = new EditField(driver.findElement(By.id("field-address2")));
        cityField = new EditField(driver.findElement(By.id("field-city")));
        stateFiled = new EditField(driver.findElement(By.id("field-id_state")));
        zipField = new EditField(driver.findElement(By.id("field-postcode")));
        countryField = new EditField(driver.findElement(By.id("field-id_country")));
        phoneField = new EditField(driver.findElement(By.id("field-phone")));
        saveButton = new Button(driver.findElement(By.xpath("//*[@id='content']/div/div/form/footer/button")));
    }

    @Step("Get the Alias field.")
    public EditField getAliasFiled() {
        return aliasField;
    }

    @Step("Get the Save button.")
    public Button getSaveButton() {
        return saveButton;
    }

    public AddressPage setAddress1(String address1) {
        address1Field.setText(address1);
        return this;
    }

    public AddressPage setCity(String city) {
        cityField.setText(city);
        return this;
    }

    public AddressPage setZip(String zip) {
        zipField.setText(zip);
        return this;
    }

    public AddressPage setState(String state) {
        stateFiled.setText(state);
        return this;
    }

    public AddressPage setCountry(String country) {
        countryField.setText(country);
        return this;
    }

    @Step("Fill required fields: {method}")
    public void fillRequiredFieldsAddressForm(Address address) {
        getAliasFiled().isDisplayed();
        setAddress1(address.getCustomerAddress());
        setCity(address.getCustomerCity());
        setZip(address.getCustomerZip());
        setState(StateEnums.State.AA.getState());
        setCountry(CountryEnums.Country.UNITED_STATES.getCountry());

    }

    @Step("Add the new Customer address - only required fields.")
    public AddressesPage addNewCustomerAddress(Address address) {
        fillRequiredFieldsAddressForm(address);
        clickOnSaveButton();
        new AddressesPage(driver).getCreateNewAddressButton().getBaseElement().isDisplayed();
        return new AddressesPage(driver);
    }

    @Step("Click on the Save button.")
    public void clickOnSaveButton() {
        getSaveButton().click();
    }

    @Step("Get alert text.")
    public String getSuccessAlertText(){
        WebDriverWait wait = new WebDriverWait(driver, 2);
        WebElement element = driver.findElement(By.cssSelector("[class*='alert']"));
        wait.until(ExpectedConditions.visibilityOf(element));
        return element.getText();
    }

}
