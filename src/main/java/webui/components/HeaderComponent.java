package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Dropdown;
import webui.pageobject.element.controls.Link;
import webui.pages.*;

public class HeaderComponent extends BasePage { //exception

    private final SearchComponent searchBar;
    private final Link logo;
    private final Link contactUsLink;
    private final Dropdown languageDropdown;
    private final Dropdown currencyDropdown;
    private final Button signInButton;
    private final Link cartLink;
    private final Link clothesLink;
    private final Link accessoriesLink;
    private final Link artLink;

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
        logo = new Link(driver.findElement(By.id("_desktop_logo")));
        contactUsLink = new Link(driver.findElement(By.id("contact-link")));
        languageDropdown = new Dropdown(driver.findElement(By.cssSelector("[class='expand-more']")));
        currencyDropdown = new Dropdown(driver.findElement(By.cssSelector("[class = 'expand-more _gray-darker']")));
        signInButton = new Button(driver.findElement(By.className("user-info")));
        cartLink = new Link(driver.findElement(By.id("_desktop_cart")));
        clothesLink = new Link(driver.findElement(By.id("category-3")));
        accessoriesLink = new Link(driver.findElement(By.id("category-6")));
        artLink = new Link(driver.findElement(By.id("category-9")));
    }

    public SearchComponent getSearchBar() {
        return searchBar;
    }

    public HomePage goToHomePage() {
        logo.click();
        return new HomePage(driver);
    }

    @Step("Get Contact Us link.")
    public Link getContactUsLink() {
        return contactUsLink;
    }

    @Step("Get Sign Out button.")
    public Button getSignOutButton() {
        return new Button(driver.findElement(By.cssSelector("[class = 'logout hidden-sm-down']")));
    }

    @Step("Sign In link click.")
    public LoginPage clickOnSignIn() {
        getSignInButton().click();
        return new LoginPage(driver);
    }

    @Step("Get Sign In.")
    public Button getSignInButton() {
        return signInButton;
    }

    @Step("Get Account link.")
    public Link getAccountLink() {
        return new Link(driver.findElement(By.className("account")));
    }

    @Step("Get Cart link.")
    public Link getCartLink() {
        return cartLink;
    }

    @Step("Click on the Cart.")
    public ShoppingCartPage clickOnCartLink() {
        getCartLink().click();
        return new ShoppingCartPage(driver);
    }

    @Step("Get Clothes link.")
    public Link getClothesLink() {
        return clothesLink;
    }

    @Step("Click Clothes link.")
    public ClothesPage clickOnClothesLink() {
        getClothesLink().click();
        return new ClothesPage(driver);
    }

    @Step("Get Accessories link.")
    public Link getAccessoriesLink() {
        return accessoriesLink;
    }

    @Step("Accessories link click.")
    public AccessoriesPage clickOnAccessoriesLink() {
        getAccessoriesLink().click();
        return new AccessoriesPage(driver);
    }

    @Step("Get Art link.")
    public Link getArtLink() {
        return artLink;
    }

    @Step("Art link click.")
    public ArtPage clickOnArtLink() {
        artLink.click();
        return new ArtPage(driver);
    }

    @Step("Men link click.")
    public MenPage clickOnMenPage() {
        hoverOnElement(getClothesLink().getBaseElement());
        menLink.click();
        return new MenPage(driver);
    }

    @Step("Women link click.")
    public WomenPage clickOnWomenPage() {
        hoverOnElement(getClothesLink().getBaseElement());
        womenLink.click();
        return new WomenPage(driver);
    }

    @Step("Get user data from page header.")
    public String getUserFirstnameLastnameFromPage() {
        fluentWaitForElementDisplayed(userFirstNameLastname);
        return getTextFromWebElement(userFirstNameLastname);
    }

    public FooterComponent getFooter() {
        return new FooterComponent(driver);
    }
}