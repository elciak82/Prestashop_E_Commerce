package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.pages.*;

import java.util.List;

public class SearchComponent extends HeaderComponent {
    public SearchComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className ="ui-menu-item")
    List<WebElement> searchListItem;

    @FindBy(id="ui-id-1")
    WebElement searchWidget;

    @Step("Search by clicking on the lookup button.")
    public void searchElement_enter(String value) {
        searchBy.sendKeys(value);
        searchBy.sendKeys(Keys.ENTER);
    }

    @Step("Get list of all elements from the Search list.")
    public List<String> getAllElementsFromSearchList(String value) {
        searchBy.sendKeys(value);
        WebElement myDynamicElement = (new WebDriverWait(driver, 2))
                .until(ExpectedConditions.visibilityOf(searchWidget));
        return new GenericPage(driver).getAllResults(searchListItem);
    }

    @Step("Select element from the Search list")
    public void selectElementFromSearchList(int elementFromTheList){
        searchListItem.get(elementFromTheList).click();

    }


}