package webui.pages;

import helpers.models.Address;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.GenericPage;

public class AccountPage extends GenericPage {
    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "addresses-link")
    WebElement addressesLink;

    @Step("Click on the Addresses link.")
    public void clickOnAddressesLink () {
        addressesLink.click();
    }
}

