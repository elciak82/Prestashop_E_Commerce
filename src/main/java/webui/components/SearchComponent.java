package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.WebEntity;

import java.util.List;

public class SearchComponent extends WebEntity {
    HeaderComponent header;

    @FindBy(className ="ui-menu-item")
    private List<WebElement> searchListItem;

    @FindBy(id="ui-id-1")
    private WebElement searchWidget;

    @FindBy (xpath = "//*[@id='search_widget']/form/input[2]")
    private WebElement searchBy;

    public SearchComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        header = new HeaderComponent(driver);
    }

    @Step("Search by clicking on the Enter.")
    public HeaderComponent searchElementByPressingOnEnter(String value) {
        searchBy.sendKeys(value);
        searchBy.sendKeys(Keys.ENTER);
        return new HeaderComponent(driver);
    }

    @Step("Get list of all elements from the Search list.")
    public List<String> getAllElementsFromSearchList(String value) {
        searchBy.sendKeys(value);
        new WebDriverWait(driver, 2).until(ExpectedConditions.visibilityOf(searchWidget));
        return new WebEntity(driver).getAllResults(searchListItem);
    }

    @Step("Select element from the Search list")
    public void selectElementFromSearchList(int elementFromTheList){
        searchListItem.get(elementFromTheList).click();
    }





}