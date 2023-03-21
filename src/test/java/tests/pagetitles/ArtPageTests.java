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

public class ArtPageTests extends BaseTest {

    @Test(testName = "Verify Art Page title.")
    @Description("Test verifying Art Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-5")
    @Parameters("browser: chrome")
    public void verifyArtPageTitleTest() {
        String title = new HomePage(driver)
                .openArtPage()
                .getPageTitle();

        Assert.assertEquals(title, PageTitleEnums.Titles.ART_PAGE.getPageTitle());

    }
}
