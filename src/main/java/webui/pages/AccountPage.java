package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class AccountPage extends HeaderComponent {

    @FindBy(id = "address-link")
    private WebElement addressesLink;

    public AccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Click on the Addresses link.")
    public AddressPage openAddressPage() {
        addressesLink.click();
        return new AddressPage(driver);
    }
}

