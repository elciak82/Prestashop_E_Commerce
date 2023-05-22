package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;
import webui.components.ProductListComponent;

public class HomePage extends HeaderComponent {

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductListComponent getProductList(){
        return new ProductListComponent(driver.findElement(By.cssSelector("div.products.row")), driver);
    }
}
