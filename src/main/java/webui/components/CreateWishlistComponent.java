package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.pageobject.element.controls.EditField;
import webui.pages.BasePage;

public class CreateWishlistComponent extends BasePage {
    private final EditField wishlistNameField;

    public CreateWishlistComponent(WebDriver driver) {
        super(driver);

        wishlistNameField = new EditField(driver.findElement(By.xpath("//*[@id=\"input2\"]")));
    }

    public EditField getWishlistNameField() {
        return wishlistNameField;
    }
}
