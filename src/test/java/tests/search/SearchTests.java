package tests.search;

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
import webui.pages.HomePage;
import webui.pages.ProductPage;

import java.util.List;

public class SearchTests extends BaseTest {

    // TODO: 3/15/2023
    @Test(testName = "Search.")
    @Description("Search.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-..")
    @Parameters("browser: chrome")
    public void search() {
        new SearchComponent(driver).search("mug");
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
        String searchingValue = "CUSTOMIZABLE MUG";
        ProductPage productPage = new HomePage(driver)
                .getSearchBar()
                .fillSearchField(searchingValue)
                .selectItemByName(searchingValue);
        String foundProductTitle = productPage.getProductTitleText();

        Assert.assertEquals(searchingValue.toLowerCase(), foundProductTitle.toLowerCase());
    }
}
