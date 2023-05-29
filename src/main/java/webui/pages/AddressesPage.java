package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;

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