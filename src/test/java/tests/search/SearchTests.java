package tests.search;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.SearchComponent;
import webui.pages.AccessoriesPage;

import java.util.List;

public class SearchTests extends BaseTest {

    // TODO: 3/15/2023
    @Test(testName = "Search.")
    @Description("Search.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-..")
    @Parameters("browser: chrome")
    public void search() {
        new SearchComponent(driver).searchElement_enter("mug");
        String title = header.getPageTitle();
//        Assert.assertEquals(title, "test");
        Assert.assertEquals(title, "Search");

    }

    // TODO: 3/15/2023
    @Test(testName = "Search.")
    @Description("Search.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-..")
    @Parameters("browser: chrome")
    public void searchLists() {
        String searchingValue = "mug";
        SearchComponent search = new SearchComponent(driver);
        List<String> listsOfElements = search.getAllElementsFromSearchList(searchingValue);

        int elementNumber = 1;
        search.selectElementFromSearchList(elementNumber);

        Assert.assertEquals(listsOfElements.get(elementNumber), new AccessoriesPage(driver).getAccessoryTitle());




    }
}
