package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.pageobject.element.controls.Button;
import webui.pages.BasePage;
import webui.pages.CartPage;

public class ProductAddedToCartComponent extends BasePage {
    Button proceedToCheckoutButton;

    public ProductAddedToCartComponent(WebDriver driver) {
        super(driver);
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[aria-labelledby='myModalLabel'] .modal-content")));
        proceedToCheckoutButton = new Button(driver.findElement(By.cssSelector("div.cart-content-btn > a.btn")));
    }

    public Button getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    public CartPage proceedToCheckout(){
        getProceedToCheckoutButton().click();
        return new CartPage(driver);
    }

}
