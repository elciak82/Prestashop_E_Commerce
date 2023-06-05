package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Label;
import webui.pageobject.element.controls.RadioButton;

public class CheckoutShippingMethodPage extends HeaderComponent {
    private final WebElement deliveryOptions;
    private final RadioButton myPrestaShop;
    private final RadioButton myCheapCarrier;
    private final RadioButton myLightCarrier;
    private final RadioButton myCarrierPL;
    private final Label shippingValue;

    public CheckoutShippingMethodPage(WebDriver driver) {

        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='delivery-options-list']")));
        deliveryOptions = driver.findElement(By.cssSelector("[class='delivery-options-list']"));
        myPrestaShop = new RadioButton(driver.findElement(By.id("delivery_option_1")));
        myCheapCarrier = new RadioButton(driver.findElement(By.id("delivery_option_3")));
        myLightCarrier = new RadioButton(driver.findElement(By.id("delivery_option_4")));
        myCarrierPL = new RadioButton(driver.findElement(By.id("delivery_option_6")));
        shippingValue = new Label(driver.findElement(By.cssSelector("[id='cart-subtotal-shipping'] [class='value']")));

    }

    public WebElement getDeliveryOptions(){
        return deliveryOptions;
    }

    public Boolean myCheapCarrierIsSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(myCheapCarrier.getBaseElement()));
        return myCheapCarrier.getBaseElement().isSelected();
    }

    public Boolean myPrestaShopSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(myPrestaShop.getBaseElement()));
        return myPrestaShop.getBaseElement().isSelected();
    }

    public Boolean myLightCarrierIsSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(myLightCarrier.getBaseElement()));
        return myLightCarrier.getBaseElement().isSelected();
    }

    public Boolean myCarrierIsSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(myCarrierPL.getBaseElement()));
        return myCarrierPL.getBaseElement().isSelected();
    }

    public CheckoutShippingMethodPage selectMyCheapCarrier(){
        myCheapCarrier.click();
        return this;
    }

    public CheckoutShippingMethodPage selectMyPrestashop(){
        myPrestaShop.click();
        return this;
    }

    public CheckoutShippingMethodPage selectMyLightCarrier(){
        myLightCarrier.click();
        return this;
    }

    public CheckoutShippingMethodPage selectMyCarrierPL(){
        myCarrierPL.click();
        return this;
    }

    public String getShippingValue(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[id='cart-subtotal-shipping'] [class='value']")));
        System.out.println(shippingValue.getBaseElement().getText());
        return shippingValue.getBaseElement().getText();
    }

}