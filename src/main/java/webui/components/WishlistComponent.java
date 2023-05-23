package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.pageobject.element.controls.Button;
import webui.pages.BasePage;

public class WishlistComponent extends BasePage {
    private final Button myWishlistButton;
    private final Button createNewWishlistButton;
    private final Button closeButton;

    public WishlistComponent(WebDriver driver) {
        super(driver);

        myWishlistButton = new Button(driver.findElement(By.cssSelector("[class='modal-content'] ul")));
        createNewWishlistButton = new Button(driver.findElement(By.className("wishlist-add-to-new")));
        closeButton = new Button(driver.findElement(By.xpath("//*[@id=\"index\"]/div[1]/div[1]/div/div/div[1]/button")));

    }

    public Button getMyWishlistButton() {
        return myWishlistButton;
    }

    public Button cetCreateNewWishlistButton() {
        return createNewWishlistButton;
    }

    public Button getCloseButton(){
        return closeButton;
    }

    public void closeWishlistComponent(){
        getCloseButton().click();
    }

}
