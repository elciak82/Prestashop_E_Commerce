package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.pageobject.element.controls.Link;
import webui.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductListComponent extends BasePage {

    private final List<ProductMiniatureComponent> productMiniaturesList;

    public ProductListComponent(WebDriver driver) {
        super(driver);

        productMiniaturesList = new ArrayList<>();
        List<WebElement> productMiniatures = driver.findElements(By.cssSelector("[id='content'] article"));
        int i = 1;
        for (WebElement element : productMiniatures) {
            productMiniaturesList.add(new ProductMiniatureComponent(driver, i++));
        }
    }

    public List<ProductMiniatureComponent> getAllProductsMiniatures() {
        return productMiniaturesList;
    }
}
