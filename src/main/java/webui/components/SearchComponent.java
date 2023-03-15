package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pages.*;

public class SearchComponent extends HeaderComponent {
    public SearchComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Search by clicking on the lookup button.")
    public void searchElement_enter(String value) {
        searchBy.sendKeys(value);
        searchBy.sendKeys(Keys.ENTER);
    }


}