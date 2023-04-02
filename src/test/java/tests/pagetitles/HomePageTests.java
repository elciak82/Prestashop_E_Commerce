package tests.pagetitles;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.HeaderComponent;

public class HomePageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Home Page title.")
    @Description("Test verifying Home Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-1")
    @Parameters("browser: chrome")
    public void verifyHomePageTitleTest() {
        header = new HeaderComponent(driver);

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.HOME_PAGE.getPageTitle());
    }
}
