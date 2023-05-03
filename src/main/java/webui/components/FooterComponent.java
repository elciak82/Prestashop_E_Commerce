package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.*;

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

    @Step("Prices drop link click.")
    public PricesDropPage clickOnPricesDropLink() {
        priceDropLink.click();
        return new PricesDropPage(driver);
    }

    @Step("New products link click.")
    public NewProductsPage clickOnNewProductsLink() {
        newProductsLink.click();
        return new NewProductsPage(driver);
    }

    @Step("Best sales link click.")
    public BestSellersPage clickOnBestSalesLink() {
        bestSalesLink.click();
        return new BestSellersPage(driver);
    }

    @Step("Delivery link click.")
    public DeliveryPage clickOnDeliveryLink() {
        deliveryLink.click();
        return new DeliveryPage(driver);
    }

    @Step("Legal notice link click.")
    public LegalNoticePage clickOnLegalNoticeLink() {
        legalNoticeLink.click();
        return new LegalNoticePage(driver);
    }

    @Step("Terms and conditions link click.")
    public TermsAndConditionsPage clickOnTermsAndConditionsLink() {
        termsAndCondLink.click();
        return new TermsAndConditionsPage(driver);
    }

    @Step("About us link click.")
    public AboutUsPage clickOnAboutUsLink() {
        aboutUsLink.click();
        return new AboutUsPage(driver);
    }

    @Step("Secure payment link click.")
    public SecurePaymentPage clickOnSecurePaymentLink() {
        securePaymentLink.click();
        return new SecurePaymentPage(driver);
    }

    @Step("Contact us link click.")
    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    @Step("Site map link click.")
    public SitemapPage clickOnSiteMapLink() {
        sitemapLink.click();
        return new SitemapPage(driver);
    }

    @Step("Stores link click.")
    public StoresPage clickOnStoresLink() {
        storesLink.click();
        return new StoresPage(driver);
    }

    @Step("Personal info link click.")
    public PersonalInfoPage clickOnPersonalInfoLink() {
        personalInfoLink.click();
        return new PersonalInfoPage(driver);
    }

    @Step("Orders link click.")
    public OrdersPage clickOnOrdersLink() {
        ordersLink.click();
        return new OrdersPage(driver);
    }

    @Step("Credit slips link click.")
    public CreditSlipsPage clickOnCreditSlipsLink() {
        creditSlipsLink.click();
        return new CreditSlipsPage(driver);
    }

    @Step("Addresses link click.")
    public AddressesPage clickOnAddressesLink() {
        addressesLink.click();
        return new AddressesPage(driver);
    }

    @Step("Wishlist link click.")
    public WishlistPage clickOnWishlistLink() {
        wishListLink.click();
        return new WishlistPage(driver);
    }

}
