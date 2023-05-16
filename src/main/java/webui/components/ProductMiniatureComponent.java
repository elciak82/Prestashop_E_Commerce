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
    private final Link productLink;
    private final Button addToWishlistButton;
    private final Link quickViewLink;
    private final List<Link> variantLinks;

    public ProductMiniatureComponent(WebDriver driver, int index) {
        super(driver);

        String xpath = "//*[@id=\"content\"]/section/div/div[" + index + "]";

        productLink = new Link(driver.findElement(By.xpath(xpath + "/article/div/div[1]/a")));
        //*[@id="content"]/section/div/div[1]/article/div/div[1]/a

        addToWishlistButton = new Button(driver.findElement(By.xpath(xpath + "/article/div/button")));
        //*[@id="content"]/section/div/div[1]/article/div/button

        quickViewLink = new Link(driver.findElement(By.xpath(xpath + "/article/div/div[1]/div/a")));
        //*[@id="content"]/section/div/div[1]/article/div/div[1]/div/a

        variantLinks = new ArrayList<>();
        List<WebElement> variants = driver.findElements(By.xpath(xpath + "/article/div/div[1]/div/div/a"));
        //*[@id="content"]/section/div/div[1]/article/div/div[1]/div/div
        for (WebElement e : variants) {
            variantLinks.add(new Link(e));
        }

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

}
