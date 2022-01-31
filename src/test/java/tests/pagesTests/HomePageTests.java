package tests.pagesTests;

import helpers.enums.LinkEnums;
import helpers.enums.PageTitleEnums;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class HomePageTests extends BaseTest {

    //@Link(name = "PRESTASHOP-1", url = LinkEnums.SuiteLinks.PAGE_TITLES_SUITE.getLinkToCase())
    @TmsLink("PRESTASHOP-1")
    @Test(description = "Verify Home Page Title")
    @Description("Test verifying Home Page title")
    @Severity(SeverityLevel.CRITICAL)
    @Parameters("browser: chrome")
    public void verifyHomePageTitleTest(){
        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.HOME_PAGE.getPageTitle());
    }
}
