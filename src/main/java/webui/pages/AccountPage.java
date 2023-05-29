package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Link;

public class AccountPage extends HeaderComponent {

    public AccountPage(WebDriver driver) {
        super(driver);
    }

    private Link getAddressLink (){
        return new Link(driver.findElement(By.id("address-link")));
    }

    @Step("Click on the Addresses link.")
    public AddressPage openAddressPage() {
        getAddressLink().click();
        return new AddressPage(driver);
    }
}

