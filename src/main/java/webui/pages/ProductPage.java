package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Label;

public class ProductPage extends HeaderComponent {
    Label productTitleLabel;

    public ProductPage(WebDriver driver) {
        super(driver);
        productTitleLabel = new Label(driver.findElement(By.cssSelector("div[class*='product-container'] .col-md-6:last-child h1")));
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
}
