package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.EditField;
import webui.pages.BasePage;

public class CreateWishlistComponent extends BasePage {
    private final EditField wishlistNameField;
    private final Button createWishListButton;

    public CreateWishlistComponent(WebDriver driver) {
        super(driver);

        wishlistNameField = new EditField(driver.findElement(By.xpath("//*[@id=\"input2\"]")));
        createWishListButton = new Button(driver.findElement(By.xpath("//*[@id=\"index\"]/div[2]/div[1]/div/div/div[3]/button[2]")));
    }

    public EditField getWishlistNameField() {
        return wishlistNameField;
    }

    public Button getCreateWishListButton(){
        return createWishListButton;
    }

    public String getNotificationText(){
        return getTextFromWebElement(driver.findElement(By.cssSelector("p.wishlist-toast-text")));
    }
}
