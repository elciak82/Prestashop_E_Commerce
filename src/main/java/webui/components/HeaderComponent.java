package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Dropdown;
import webui.pageobject.element.controls.Link;
import webui.pages.*;

public class HeaderComponent extends BasePage {

    private final SearchComponent searchBar;
    private final Link logo;
    private final Link contactUsLink;
    private final Button signInButton;
    private final Link cartLink;
    private final Link clothesLink;
    private final Link accessoriesLink;
    private final Link artLink;
    private final Link menLink;
    private final Link womenLink;

    public HeaderComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        searchBar = new SearchComponent(driver);
        logo = new Link(driver.findElement(By.cssSelector("[id = '_desktop_logo'] a")));
        contactUsLink = new Link(driver.findElement(By.id("contact-link")));
        signInButton = new Button(driver.findElement(By.className("user-info")));
        cartLink = new Link(driver.findElement(By.id("_desktop_cart")));
        clothesLink = new Link(driver.findElement(By.id("category-3")));
        accessoriesLink = new Link(driver.findElement(By.id("category-6")));
        artLink = new Link(driver.findElement(By.id("category-9")));
        menLink = new Link(driver.findElement(By.id("category-4")));
        womenLink = new Link(driver.findElement(By.id("category-5")));
    }

    public SearchComponent getSearchBar() {
        return searchBar;
    }

    @Step("Go to the Home Page.")
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

    @Step("Get Men link.")
    public Link getMenLink() {
        return menLink;
    }

    @Step("Men link click.")
    public MenPage clickOnMenLink() {
        hoverOnElement(getClothesLink().getBaseElement());
        menLink.click();
        return new MenPage(driver);
    }

    @Step("Get Women link.")
    public Link getWomenLink() {
        return womenLink;
    }

    @Step("Women link click.")
    public WomenPage clickOnWomenLink() {
        hoverOnElement(getClothesLink().getBaseElement());
        womenLink.click();
        return new WomenPage(driver);
    }

    @Step("Get user data from page header.")
    public String getUserFirstnameLastnameFromPage() {
        WebElement userFirstNameLastnameElement =  driver.findElement(By.cssSelector("[class = 'account'] span[class = 'hidden-sm-down']"));
        return userFirstNameLastnameElement.getText();
    }

    public FooterComponent getFooter() {
        return new FooterComponent(driver);
    }

    public void logOut() {
            boolean displayed = !driver.findElements(By.cssSelector("[class = 'logout hidden-sm-down']")).isEmpty();
            if (displayed) {
                getSignOutButton().click();
                System.out.println("Log out from the account.");
            } else {
                System.out.println("Customer is not logged in.");
            }
    }
}