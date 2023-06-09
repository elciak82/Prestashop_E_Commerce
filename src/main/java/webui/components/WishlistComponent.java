package webui.components;

import io.qameta.allure.Step;
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
        closeButton = new Button(driver.findElement(By.cssSelector("[class='wishlist-modal modal fade show'] [class='close']")));

    }

    public Button getMyWishlistButton() {
        return myWishlistButton;
    }

    @Step("Get the CreateNewWishlist Button")
    public Button getCreateNewWishlistButton() {
        return createNewWishlistButton;
    }

    public Button getCloseButton(){
        return closeButton;
    }

    public void closeWishlistComponent(){
        getCloseButton().click();
    }

}
