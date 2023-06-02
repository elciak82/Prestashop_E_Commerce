package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;

public class CheckoutShippingMethodPage extends HeaderComponent {
    WebElement deliveryOptions;

    public CheckoutShippingMethodPage(WebDriver driver) {

        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[class='delivery-options-list']")));
        deliveryOptions = driver.findElement(By.cssSelector("[class='delivery-options-list']"));
    }

    public WebElement getDeliveryOptions(){
        return deliveryOptions;
    }

}