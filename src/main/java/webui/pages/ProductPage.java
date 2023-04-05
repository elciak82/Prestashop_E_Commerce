package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.WebEntity;
import webui.components.HeaderComponent;

public class ProductPage extends HeaderComponent {

    @FindBy(css = "div[class*='product-container'] .col-md-6:last-child h1")
    private WebElement productTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public WebElement getProductTitle() {
        return productTitle;
    }

    public String getProductTitleText() {
        return productTitle.getText();
    }
}
