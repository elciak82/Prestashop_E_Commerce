package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Label;
import webui.pageobject.element.controls.RadioButton;

public class CheckoutPaymentPage extends HeaderComponent {
    private final WebElement paymentOptions;

    public CheckoutPaymentPage(WebDriver driver) {

        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("payment-options")));
        paymentOptions = driver.findElement(By.className("payment-options"));

    }

    public WebElement getPaymentOptions(){
        return paymentOptions;
    }

}