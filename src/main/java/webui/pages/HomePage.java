package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.components.ProductListComponent;

public class HomePage extends HeaderComponent {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Step("Get the list of products.")
    public ProductListComponent getProductList(){
        return new ProductListComponent(driver.findElement(By.cssSelector("div.products.row")), driver);
    }
}
