package webui.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.WebEntity;
import webui.common.Control;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Label;
import webui.pageobject.element.controls.Link;
import webui.pages.BasePage;

import java.util.ArrayList;
import java.util.List;

public class ProductMiniatureComponent extends WebEntity {
    private final Link productLink;
    private final Button addToWishlistButton;
    private final Link quickViewLink;
    private final List<Link> variantLinks;
    private final Label productTitle;
    protected final WebElement baseElement;

    public ProductMiniatureComponent(WebElement baseElement, WebDriver driver) {
        super(driver);
        this.baseElement = baseElement;

        productLink = new Link(baseElement.findElement(By.cssSelector("a.product-thumbnail")));

        addToWishlistButton = new Button(baseElement.findElement(By.cssSelector("button.wishlist-button-add")));

        quickViewLink = new Link(baseElement.findElement(By.cssSelector("a.quick-view")));

        variantLinks = new ArrayList<>();
        List<WebElement> variants = baseElement.findElements(By.cssSelector("div.variant-links a"));
        for (WebElement e : variants) {
            variantLinks.add(new Link(e));
        }

        productTitle = new Label(baseElement.findElement(By.cssSelector("h3.product-title")));

    }

    public Link getProduct(){
        return productLink;
    }

    public Button getAddToWishlistButton() {
        return addToWishlistButton;
    }

    public Link getGetQuickViewLink() {
        hoverOnElement(quickViewLink.getBaseElement());
        return quickViewLink;
    }

    public List<Link> getVariantLinks(){
        hoverOnElement(quickViewLink.getBaseElement());
        return variantLinks;
    }

    public WishlistComponent getAddToWishlist() {
        return new WishlistComponent(driver);
    }

    public ProductQuickViewComponent getQuickView() {
        return new ProductQuickViewComponent(driver);
    }

    public CreateWishlistComponent getCreteWishlistComponent() {
        return new CreateWishlistComponent(driver);
    }

    public Label getProductTitle(){
        return productTitle;

    }


}
