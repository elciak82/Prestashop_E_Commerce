package webui.pages;

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
    private final Button continueButton;

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
        continueButton = new Button(driver.findElement(By.cssSelector("[name='confirm-addresses']")));

    }

    public EditField getCompanyField(){
        return companyField;
    }


}