package tests.pagetitles;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.pages.HomePage;

public class AccessoriesPageTests extends BaseTest {

    @Test(testName = "Verify Accessories Page title.")
    @Description("Test verifying Accessories Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-4")
    @Parameters("browser: chrome")
    public void verifyAccessoriesPageTitleTest() {
        String title = new HomePage(driver)
                .openAccessoriesPage()
                .getPageTitle();

        Assert.assertEquals(title, PageTitleEnums.Titles.ACCESSORIES_PAGE.getPageTitle());

    }
}
