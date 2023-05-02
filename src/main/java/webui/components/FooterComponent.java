package webui.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.BasePage;

public class FooterComponent extends BasePage {

    @FindBy(css = "[name = 'email']")
    private WebElement emailField;

    @FindBy(className = "input-wrapper")
    private WebElement subscribeButton;

    @FindBy(id = "link-product-page-prices-drop-1")
    private WebElement priceDropLink;

    @FindBy(id = "link-product-page-new-products-1")
    private WebElement newProductsLink;

    @FindBy(id = "link-product-page-best-sales-1")
    private WebElement bestSalesLink;

    @FindBy(id = "link-cms-page-1-2")
    private WebElement deliveryLink;

    @FindBy(id = "link-cms-page-2-2")
    private WebElement legalNoticeLink;

    @FindBy(id = "link-cms-page-3-2")
    private WebElement termsAndCondLink;

    @FindBy(id = "link-cms-page-4-2")
    private WebElement aboutUsLink;

    @FindBy(id = "link-cms-page-5-2")
    private WebElement securePaymentLink;

    @FindBy(id = "link-static-page-contact-2")
    private WebElement contactUsLink;

    @FindBy(id = "link-static-page-sitemap-2")
    private WebElement sitemapLink;

    @FindBy(id = "link-static-page-stores-2")
    private WebElement storesLink;

    @FindBy(css = "[title='Personal info']")
    private WebElement personalInfoLink;

    @FindBy(css = "[title='Orders']")
    private WebElement ordersLink;

    @FindBy(css = "[title='Credit slips']")
    private WebElement creditSlipsLink;

    @FindBy(css = "[title='Addresses']")
    private WebElement addressesLink;

    @FindBy(css = "[title='My wishlists']")
    private WebElement wishListLink;

    public FooterComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }




}
