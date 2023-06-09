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
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        myLightCarrier = new RadioButton(driver.findElement(By.cssSelector("[id='delivery_option_4']")));
        myCarrierPL = new RadioButton(driver.findElement(By.id("delivery_option_6")));
        continueOnPaymentPage = new Button(driver.findElement(By.xpath("//*[@id='js-delivery']/button")));

    }

    public WebElement getDeliveryOptions(){
        return deliveryOptions;
    }

    public Boolean myCheapCarrierIsSelected(){
//        WebDriverWait wait = new WebDriverWait(driver,10);
//        wait.until(ExpectedConditions.elementToBeSelected(myCheapCarrier.getBaseElement()));
        return myCheapCarrier.getBaseElement().isSelected();
    }

    public Boolean myPrestashopSelected(){
        return myPrestashop.getBaseElement().isSelected();
    }

    public Boolean myLightCarrierIsSelected(){
        return myLightCarrier.getBaseElement().isSelected();
    }

    public Boolean myCarrierIsSelected(){
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

    public String getShippingPriceFromSummary(){
        WebElement oldShippingPrice = driver.findElement(By.cssSelector("[id='cart-subtotal-shipping'] [class='value']"));
        System.out.println("Before change:" + oldShippingPrice.getText());
        WebDriverWait wait = new WebDriverWait(driver, 10);
// wait for the original oldShippingPrice to go stale... change
        wait.until(ExpectedConditions.stalenessOf(oldShippingPrice));
// grab the new element by whatever the new cssSelector is
        WebElement newShippingPrice = driver.findElement(By.cssSelector("[id='cart-subtotal-shipping'] [class='value']"));
        System.out.println("After change:" + newShippingPrice.getText());
        return newShippingPrice.getText().substring(1);
    }

    public String getShippingValueFromShippingOption(){///method HOMEWORK
        List<WebElement> radioButtons = driver.findElements(By.cssSelector("[class='custom-radio float-xs-left'] input"));
        int i = 0;
        for (WebElement element : radioButtons) {
            if (element.isSelected()) {
                List<WebElement> carrierPrice = driver.findElements(By.className("carrier-price"));
//                System.out.println(carrierPrice.get(i).getText());
                return carrierPrice.get(i).getText();
            }
            i++;
        }
        return null;
    }

    public CheckoutPaymentPage continueOnShippingMethodPage(){
        continueOnPaymentPage.click();
        return new CheckoutPaymentPage(driver);

    }

    private double getShippingPrice(String priceText){
//        String priceText = getShippingValueFromShippingOption();
        if(priceText.equalsIgnoreCase("Free")){
            return 0;
        }else{
            Pattern p = Pattern.compile("[0-9.]+[0-9.]"); //I have to change it
            Matcher m = p.matcher(priceText);
            while(m.find()) {
//                System.out.println(Double.parseDouble(m.group()));
                return Double.parseDouble(m.group());
            }

        }
        return 0;
    }

    public double getPriceFromSummary(){
        String priceText = getShippingPriceFromSummary();
        return getShippingPrice(priceText);
    }


    public double getPriceFromShippingOption(){
        String priceText = getShippingValueFromShippingOption();
        return getShippingPrice(priceText);
    }

}