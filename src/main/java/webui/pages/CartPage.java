package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Label;

public class CartPage extends HeaderComponent {
    private final Label cartProductCountsLabel;
    private final Label productTitleLabel;
    private final Button proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        cartProductCountsLabel = new Label(driver.findElement(By.className("cart-products-count")));
        productTitleLabel = new Label(driver.findElement(By.cssSelector("[data-id_customization='0']")));
        proceedToCheckoutButton = new Button(driver.findElement(By.xpath("//*[@id=\"main\"]/div/div[2]/div[1]/div[2]/div/a"))); //class does not work

    }

    public Label getCartProductCountsLabel(){
        return cartProductCountsLabel;
    }

    public String getCartProductCounts(){
        return getCartProductCountsLabel().getText();
    }
    public Label getProductTitleLabel(){
        return productTitleLabel;
    }

    public String getProductTitle(){
        return getProductTitleLabel().getText();
    }

    public Button getProceedToCheckoutButton(){
        return proceedToCheckoutButton;
    }

    public CheckoutPersonalInfoPage proceedToCheckout(){
        proceedToCheckoutButton.click();
        return new CheckoutPersonalInfoPage(driver);
    }

}