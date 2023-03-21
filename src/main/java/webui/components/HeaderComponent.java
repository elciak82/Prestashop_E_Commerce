package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.*;

public class HeaderComponent extends BasePage {

    private final SearchComponent searchBar;

    @FindBy(className = "logo img-fluid")
    private WebElement logo;

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(css = "[class='expand-more']")
    private WebElement languageDropdown;

    @FindBy(css = "[class = 'expand-more _gray-darker']")
    private WebElement currencyDropdown;

    @FindBy(css = "[class = 'logout hidden-sm-down']")
    private WebElement signOut;

    @FindBy(className = "user-info")
    private WebElement signIn;

    @FindBy(className = "account")
    private WebElement account;

    @FindBy(id = "_desktop_cart")
    private WebElement cart;

    @FindBy(id = "category-3")
    private WebElement clothesLink;

    @FindBy(id = "category-6")
    private WebElement accessoriesLink;

    @FindBy(id = "category-9")
    private WebElement artLink;

    @FindBy(id = "category-4")
    private WebElement menLink;

    @FindBy(id = "category-5")
    private WebElement womenLink;

    @FindBy(css = "[class = 'account'] span[class = 'hidden-sm-down']")
    private WebElement userFirstNameLastname;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        searchBar = new SearchComponent(driver);
    }

    public SearchComponent getSearchBar() {
        return searchBar;
    }

    public WebElement getLogo() {
        return logo;
    }

    @Step("Contact Us link click.")
    public ContactUsPage openContactUsPage() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    @Step("Clothes link click.")
    public ClothesPage openClothePage() {
        clothesLink.click();
        return new ClothesPage(driver);
    }

    @Step("Accessories link click.")
    public AccessoriesPage openAccessoriesPage() {
        accessoriesLink.click();
        return new AccessoriesPage(driver);
    }

    @Step("Art link click.")
    public ArtPage openArtPage() {
        artLink.click();
        return new ArtPage(driver);
    }

    @Step("Men link click.")
    public MenPage openMenPage() {
        hoverOnElement(clothesLink);
        menLink.click();
        return new MenPage(driver);
    }

    @Step("Women link click.")
    public WomenPage openWomenPage() {
        hoverOnElement(clothesLink);
        womenLink.click();
        return new WomenPage(driver);
    }

    @Step("Sign In link click.")
    public LoginPage goToLoginPage() {
        signIn.click();
        return new LoginPage(driver);
    }

    @Step("Get user data from page header.")
    public String getUserFirstnameLastnameFromPage() {
        fluentWaitForElementDisplayed(userFirstNameLastname);
        return getTextFromWebElement(userFirstNameLastname);
    }

    public HomePage goToHomePage() {
        getLogo().click();
        return new HomePage(driver);
    }

    public void signOut(){
        signOut.click();
    }
}