
package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import webui.WebEntity;
import webui.elements.SearchMenu;
import webui.pageobject.element.controls.Dropdown;
import webui.pageobject.element.controls.EditField;
import webui.pages.SearchResultsPage;

public class SearchComponent extends WebEntity {
    Dropdown searchDropdown;
    EditField searchBy;

    public SearchComponent(WebDriver driver) {
        super(driver);
        searchDropdown = new Dropdown(driver.findElement(By.id("ui-id-1")));
        searchBy = new EditField(driver.findElement(By.xpath("//*[@id='search_widget']/form/input[2]")));

    }

    @Step("Get the Search by field.")
    public EditField getSearchBy() {
        return searchBy;
    }

    @Step("Search by clicking on the Enter.")
    public SearchResultsPage search(String value) {
        getSearchBy().setText(value);
        searchBy.setKey(Keys.ENTER);
        return new SearchResultsPage(driver);
    }

    @Step("Get the Search by dropdown.")
    public Dropdown getSearchDropdown() {
        return searchDropdown;
    }

    @Step("Get list of all elements from the Search list.")
    public SearchMenu fillSearchField(String value) {
        searchBy.setText(value);
        new WebDriverWait(driver, 2)
                .until(ExpectedConditions.visibilityOf(searchDropdown.getBaseElement()));
        return new SearchMenu(driver, searchDropdown.getBaseElement());
    }
}