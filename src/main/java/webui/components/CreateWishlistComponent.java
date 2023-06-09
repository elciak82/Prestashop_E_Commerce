package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.EditField;
import webui.pages.BasePage;

public class CreateWishlistComponent extends BasePage {
    private final EditField wishlistNameField;
    private final Button createWishListButton;

    public CreateWishlistComponent(WebDriver driver) {
        super(driver);

        wishlistNameField = new EditField(driver.findElement(By.xpath("//*[@id='input2']")));
        createWishListButton = new Button(driver.findElement(By.xpath("//button[contains(string(), 'Create wishlist')]")));
    }

    @Step ("Get the WishlistName Field")
    public EditField getWishlistNameField() {
        return wishlistNameField;
    }

    @Step("Get CreateWishList Button")
    public Button getCreateWishListButton(){
        return createWishListButton;
    }

    public String getNotificationText(){
        WebElement element = driver.findElement(By.cssSelector("p.wishlist-toast-text"));
        fluentWaitForElementDisplayed(element);
        System.out.println(getTextFromWebElement(element));
        return getTextFromWebElement(element);
    }
}
