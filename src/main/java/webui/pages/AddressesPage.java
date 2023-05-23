package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;

import java.lang.management.BufferPoolMXBean;

public class AddressesPage extends HeaderComponent {

    private final Button createNewAddress;

    public AddressesPage(WebDriver driver) {
        super(driver);

        createNewAddress = new Button(driver.findElement(By.cssSelector("[data-link-action = 'add-address']")));

    }

    public Button getCreateNewAddressButton(){
        return createNewAddress;
    }
}