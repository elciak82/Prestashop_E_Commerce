package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.WebEntity;
import webui.components.HeaderComponent;
import webui.components.ProductListComponent;

public class ProductPage extends HeaderComponent {

    @FindBy(css = "div[class*='product-container'] .col-md-6:last-child h1")
    private WebElement productTitle;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductColour(){
        String text  = driver.findElements(By.cssSelector("span.control-label")).get(1).getText();
        System.out.println(text);
        return text;
    }

    public WebElement getProductTitle() {
        return productTitle;
    }

    public String getProductTitleText() {
        return productTitle.getText();
    }
}
