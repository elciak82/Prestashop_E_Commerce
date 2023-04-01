package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.pages.*;

public class HeaderComponent extends BasePage {

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
    }

    @Step("Contact Us link click.")
    public ContactUsPage clickOnContactUsLink() {
        contactUsLink.click();
        return new ContactUsPage(driver);
    }

    @Step("Clothes link click.")
    public ClothesPage clickOnClothesLink() {
        clothesLink.click();
        return new ClothesPage(driver);
    }

    @Step("Accessories link click.")
    public AccessoriesPage clickOnAccessoriesLink() {
        accessoriesLink.click();
        return new AccessoriesPage(driver);
    }

    @Step("Art link click.")
    public ArtPage clickOnArtLink() {
        artLink.click();
        return new ArtPage(driver);
    }

    @Step("Men link click.")
    public MenPage clickOnMenLink() {
        mouseClickByLocator(clothesLink);
        menLink.click();
        return new MenPage(driver);
    }

    @Step("Women link click.")
    public WomenPage clickOnWomenLink() {
        mouseClickByLocator(clothesLink);
        womenLink.click();
        return new WomenPage(driver);
    }

    @Step("Sign In link click.")
    public LoginPage clickOnSignInLink() {
//        WebDriverWait wait = new WebDriverWait(driver, 2);
//        wait.until(ExpectedConditions.stalenessOf(signIn));
        signIn.click();
        return new LoginPage(driver);
    }

    @Step("Sign Out link click.")
    public LoginPage clickOnSignOutLink() {
        signOut.click();
        return new LoginPage(driver);
    }

    @Step("Get user data from page header.")
    public String getUserFirstnameLastnameFromPage() {
        fluentWaitForElementDisplayed(userFirstNameLastname);
        return getTextFromWebElement(userFirstNameLastname);
    }

    public void clickOnSignOutButton(){
        signOut.click();
    }
}