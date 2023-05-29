package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.WebEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductListComponent extends WebEntity {

    private final List<ProductMiniatureComponent> productMiniaturesList;
    protected final WebElement baseElement;

    public ProductListComponent(WebElement baseElement, WebDriver driver) {
        super(driver);
        this.baseElement = baseElement;

        productMiniaturesList = new ArrayList<>();
        List<WebElement> productMiniatures = baseElement.findElements(By.cssSelector("div.products.row > div"));
        for (WebElement element : productMiniatures) {
            productMiniaturesList.add(new ProductMiniatureComponent(element, driver));
        }
    }

    public WebElement getBaseElement(){
        return baseElement;
    }

    @Step("Get all products miniatures.")
    public List<ProductMiniatureComponent> getAllProductsMiniatures() {
        return productMiniaturesList;
    }


}
