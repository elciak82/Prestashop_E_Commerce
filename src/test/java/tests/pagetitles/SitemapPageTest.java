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
import webui.components.FooterComponent;
import webui.components.HeaderComponent;

public class SitemapPageTest extends BaseTest {

    @Test(testName = "Verify Sitemap Page title.")
    @Description("Test verifying Sitemap Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-36")
    @Parameters("browser: chrome")
    public void verifySitemapPageTitleTest() {
        new FooterComponent(driver).clickOnSitemapLink();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.SITEMAP_PAGE.getPageTitle());

    }
}
