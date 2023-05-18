package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.pageobject.element.controls.Button;
import webui.pages.BasePage;

public class WishlistComponent extends BasePage {
    private final Button myWishlistButton;
    private final Button createNewWishlistButton;

    public WishlistComponent(WebDriver driver) {
        super(driver);

        myWishlistButton = new Button(driver.findElement(By.cssSelector("[class='modal-content'] ul")));
        createNewWishlistButton = new Button(driver.findElement(By.className("wishlist-add-to-new")));

    }

    public Button getMyWishlistButton() {
        return myWishlistButton;
    }

    public Button cetCreateNewWishlistButton() {
        return createNewWishlistButton;
    }

}
