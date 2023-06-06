package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Label;
import webui.pageobject.element.controls.RadioButton;

import java.time.Duration;

public class CheckoutShippingMethodPage extends HeaderComponent {
    private final WebElement deliveryOptions;
    private final RadioButton myPrestashop;
    private final RadioButton myCheapCarrier;
    private final RadioButton myLightCarrier;
    private final RadioButton myCarrierPL;
    private final Button continueOnPaymentPage;

    public CheckoutShippingMethodPage(WebDriver driver) {

        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='delivery-options-list']")));
        deliveryOptions = driver.findElement(By.cssSelector("[class='delivery-options-list']"));
        myPrestashop = new RadioButton(driver.findElement(By.id("delivery_option_1")));
        myCheapCarrier = new RadioButton(driver.findElement(By.id("delivery_option_3")));
        myLightCarrier = new RadioButton(driver.findElement(By.id("delivery_option_4")));
        myCarrierPL = new RadioButton(driver.findElement(By.id("delivery_option_6")));
        continueOnPaymentPage = new Button(driver.findElement(By.xpath("//*[@id='js-delivery']/button")));

    }

    public WebElement getDeliveryOptions(){
        return deliveryOptions;
    }

    public Boolean myCheapCarrierIsSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(myCheapCarrier.getBaseElement()));
        return myCheapCarrier.getBaseElement().isSelected();
    }

    public Boolean myPrestashopSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(myPrestashop.getBaseElement()));
        return myPrestashop.getBaseElement().isSelected();
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
        myPrestashop.click();
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
        Label shippingValue = new Label(driver.findElement(By.cssSelector("[id='cart-subtotal-shipping'] [class='value']")));
        System.out.println(shippingValue.getBaseElement().getText());
        return shippingValue.getBaseElement().getText();
    }

    public CheckoutPaymentPage continueOnShippingMethodPage(){
        continueOnPaymentPage.click();
        return new CheckoutPaymentPage(driver);

    }

}