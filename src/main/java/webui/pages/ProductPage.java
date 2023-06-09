package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.components.HeaderComponent;
import webui.components.ProductAddedToCartComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Label;

public class ProductPage extends HeaderComponent {
    Label productTitleLabel;
    Button addToCartButton;

    public ProductPage(WebDriver driver) {
        super(driver);;
        productTitleLabel = new Label(driver.findElement(By.cssSelector("div[class*='product-container'] .col-md-6:last-child h1")));
        addToCartButton = new Button(driver.findElement(By.cssSelector("button[class='btn btn-primary add-to-cart']")));

    }

    public String getProductColour(){
        String text  = driver.findElements(By.cssSelector("span.control-label")).get(1).getText();
        System.out.println(text);
        return text;
    }

    public Label getProductTitle() {
        return productTitleLabel;
    }

    public String getProductTitleText() {
        return productTitleLabel.getText();
    }

    public Button getAddToCartButton(){
        return addToCartButton;
    }

    public ProductAddedToCartComponent addProductToCart() {
        getAddToCartButton().click();
        return new ProductAddedToCartComponent(driver);
    }
}
