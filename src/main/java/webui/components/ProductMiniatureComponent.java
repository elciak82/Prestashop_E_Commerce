package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Link;
import webui.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductMiniatureComponent extends BasePage {

    private final Button addToWishlistButton;

    public ProductMiniatureComponent(WebDriver driver) {
        super(driver);


        addToWishlistButton = new Button(driver.findElement(By.className("wishlist-button-add")));
    }


    public Button getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public WishlistComponent getWishlist() {
        return new WishlistComponent(driver);
    }

}
