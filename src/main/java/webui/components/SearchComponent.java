
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
import webui.elements.SearchMenu;
import webui.pages.SearchResultsPage;

public class SearchComponent extends WebEntity {

    @FindBy(id="ui-id-1")
    private WebElement searchWidget;

    @FindBy (xpath = "//*[@id='search_widget']/form/input[2]")
    private WebElement searchBy;

    public SearchComponent(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step("Search by clicking on the Enter.")
    public SearchResultsPage search(String value) {
        searchBy.sendKeys(value);
        searchBy.sendKeys(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    @Step("Get list of all elements from the Search list.")
    public SearchMenu fillSearchField(String value) {
        searchBy.sendKeys(value);
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOf(searchWidget));
        return new SearchMenu(driver, searchWidget);
    }
}