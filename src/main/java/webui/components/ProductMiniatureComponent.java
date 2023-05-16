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
    private final Link quickViewLink;
    private final List<Link> variantLinks;

    public ProductMiniatureComponent(WebDriver driver) {
        super(driver);

        addToWishlistButton = new Button(driver.findElement(By.className("wishlist-button-add")));

        hoverOnElement(addToWishlistButton.getBaseElement());
        quickViewLink = new Link(driver.findElement(By.xpath("//*[@id='content']/section/div/div[1]/article/div/div[1]/div/a")));

        variantLinks = new ArrayList<>();
        List<WebElement> variants = driver.findElements(By.cssSelector("[class = 'variant-links'] a"));
        for (WebElement e : variants) {
            variantLinks.add(new Link(e));
        }

    }

    public Button getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public Link getGetQuickViewLink() {
        return quickViewLink;
    }

    public WishlistComponent getWishlist() {
        return new WishlistComponent(driver);
    }

    public ProductQuickViewComponent getQuickView() {
        return new ProductQuickViewComponent(driver);
    }

}
