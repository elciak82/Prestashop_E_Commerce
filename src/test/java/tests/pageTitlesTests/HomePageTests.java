package tests.pageTitlesTests;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class HomePageTests extends BaseTest {


    @Test(testName = "Verify Home Page title.")
    @Description("Test verifying Home Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-1")
    @Parameters("browser: chrome")
    public void verifyHomePageTitleTest() {
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.Titles.HOME_PAGE.getPageTitle());
    }
}
