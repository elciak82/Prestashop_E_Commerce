package webui.elements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.WebEntity;
import webui.pages.ProductPage;

import java.util.List;

public class SearchMenu extends WebEntity {

    private final WebElement menuElement;

    public SearchMenu(WebDriver driver, WebElement menuElement) {
        super(driver);
        this.menuElement = menuElement;
    }

    public WebElement getMenuElement(){
        return menuElement;
    }

    public List<WebElement> getMenuItems(){
        return menuElement.findElements(By.className("ui-menu-item"));
    }

    public ProductPage selectItem (int index) {
        getMenuItems().get(index).click();
        return new ProductPage(driver);
    }

    public ProductPage selectItemByName(String name){
        getMenuItems()
                .stream()
                .filter(item -> item.findElement(By.cssSelector("span")).getText().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow()
                .click();
        return new ProductPage(driver);
    }
}
