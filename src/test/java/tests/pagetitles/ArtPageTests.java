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
import webui.components.HeaderComponent;

public class ArtPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Art Page title.")
    @Description("Test verifying Art Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-5")
    @Parameters("browser: chrome")
    public void verifyArtPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnArtPage();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.ART_PAGE.getPageTitle());

    }
}
