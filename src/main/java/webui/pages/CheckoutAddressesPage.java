package webui.pages;

import helpers.enums.CountryEnums;
import helpers.enums.StateEnums;
import helpers.models.Address;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.EditField;
import webui.pageobject.element.controls.Label;

public class CheckoutAddressesPage extends HeaderComponent {
    WebElement element;
    private final EditField companyField;
    private final EditField address1Field;
    private final EditField addressComplementField;
    private final EditField cityField;
    private final EditField stateFiled;
    private final EditField zipField;
    private final EditField countryField;
    private final EditField phoneField;

    public CheckoutAddressesPage(WebDriver driver) {

        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout-personal-information-step")));
        element = driver.findElement(By.id("checkout-personal-information-step"));
        companyField = new EditField(driver.findElement(By.id("field-company")));
        address1Field = new EditField(driver.findElement(By.id("field-address1")));
        addressComplementField = new EditField(driver.findElement(By.id("field-address2")));
        cityField = new EditField(driver.findElement(By.id("field-city")));
        stateFiled = new EditField(driver.findElement(By.id("field-id_state")));
        zipField = new EditField(driver.findElement(By.id("field-postcode")));
        countryField = new EditField(driver.findElement(By.id("field-id_country")));
        phoneField = new EditField(driver.findElement(By.id("field-phone")));

    }

    public EditField getCompanyField(){
        return companyField;
    }

    public CheckoutAddressesPage setAddress1(String address1) {
        address1Field.setText(address1);
        return this;
    }

    public CheckoutAddressesPage setCity(String city) {
        cityField.setText(city);
        return this;
    }

    public CheckoutAddressesPage setZip(String zip) {
        zipField.setText(zip);
        return this;
    }

    public CheckoutAddressesPage setState(String state) {
        stateFiled.click();
        stateFiled.setText(state);
        return this;
    }

    public CheckoutAddressesPage setCountry(String country) {
        countryField.setText(country);
        return this;
    }

    @Step("Fill required fields: {method}")
    public CheckoutAddressesPage fillRequiredFieldsAddressFormForPoland(Address address) {
        setAddress1(address.getCustomerAddress());
        setCity(address.getCustomerCity());
        setZip(address.getCustomerZipForPoland());
        setCountry(CountryEnums.Country.POLAND.getCountry());
        return this;
    }

    public Button getContinueButton(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/footer/button")));
        return new Button(driver.findElement(By.xpath("//*[@id=\"checkout-addresses-step\"]/div/div/form/footer/button")));
    }

    public CheckoutShippingMethodPage continueCheckoutOnDeliveryAddressPage(){
        getContinueButton().click();
        return new CheckoutShippingMethodPage(driver);
    }




}