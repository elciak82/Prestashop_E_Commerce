package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Checkbox;
import webui.pageobject.element.controls.Label;
import webui.pageobject.element.controls.RadioButton;

public class CheckoutPaymentPage extends HeaderComponent {
    private final WebElement paymentOptions;
    private final RadioButton payByCheck;
    private final WebElement payByCheckAdditionalInformation;
    private final RadioButton payByBankWire;
    private final WebElement payByBankWireAdditionalInformation;
    private final Checkbox termsOfService;

    public CheckoutPaymentPage(WebDriver driver) {

        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-options")));
        paymentOptions = driver.findElement(By.className("payment-options"));
        payByCheck = new RadioButton(driver.findElement(By.cssSelector("input[id='payment-option-1']")));
        payByCheckAdditionalInformation = driver.findElement(By.id("payment-option-1-additional-information"));
        payByBankWire = new RadioButton(driver.findElement(By.cssSelector("input[id='payment-option-2']")));
        payByBankWireAdditionalInformation = driver.findElement(By.id("payment-option-2-additional-information"));
        termsOfService = new Checkbox(driver.findElement(By.id("conditions_to_approve[terms-and-conditions]")));

    }

    public WebElement getPaymentOptions(){
        return paymentOptions;
    }

    public WebElement getPayByCheckAdditionalInformation(){
        return payByCheckAdditionalInformation;
    }

    public WebElement getPayBankWireAdditionalInformation(){
        return payByBankWireAdditionalInformation;
    }

    public Boolean payByCheckIsSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(payByCheck.getBaseElement()));
        return payByCheck.getBaseElement().isSelected();
    }

    public CheckoutPaymentPage selectPayByCheck(){
        payByCheck.click();
        return this;
    }

    public Boolean payByBankWireIsSelected(){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeSelected(payByBankWire.getBaseElement()));
        return payByBankWire.getBaseElement().isSelected();
    }

    public CheckoutPaymentPage selectPayByBankWire(){
        payByBankWire.click();
        return this;
    }

    public CheckoutPaymentPage checkTermsOfService(){
        termsOfService.click();
        return this;
    }

    private Button getPlaceOrderButton(){
        return new Button(driver.findElement(By.cssSelector("button[class='btn btn-primary center-block']")));
    }

    public boolean placeOrderButtonIsEnabled(){
        return getPlaceOrderButton().getBaseElement().isEnabled();
    }

    public OrderConfirmationPage confirmPlaceOrder(){
        getPlaceOrderButton().getBaseElement().click();
        return new OrderConfirmationPage(driver);
    }

}