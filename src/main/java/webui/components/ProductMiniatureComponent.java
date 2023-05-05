package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.pageobject.element.controls.Button;
import webui.pages.BasePage;
import webui.pages.ProductPage;

import java.util.ArrayList;
import java.util.List;

public class ProductMiniatureComponent extends BasePage {

    private final List<Button> productMiniaturesList;

    public ProductMiniatureComponent(WebDriver driver) {
        super(driver);
        productMiniaturesList = new ArrayList<>();
        List<WebElement> productMiniatures = driver.findElements(By.cssSelector("[id='content'] article"));
        for (WebElement e : productMiniatures) {
            productMiniaturesList.add(new Button(e));

        }
    }

    public List<Button> getMiniatures() {
        return productMiniaturesList;
    }
}
