package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Checkbox;
import webui.pageobject.element.controls.RadioButton;

public class OrderConfirmationPage extends HeaderComponent {
    private final WebElement orderConfirmation;


    public OrderConfirmationPage(WebDriver driver) {

        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[class='h1 card-title']")));
        orderConfirmation = driver.findElement(By.cssSelector("h3[class='h1 card-title']"));

    }

    public WebElement getOrderConfirmation(){
        return orderConfirmation;
    }

}