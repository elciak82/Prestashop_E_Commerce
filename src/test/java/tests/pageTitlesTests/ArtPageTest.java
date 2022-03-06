package tests.pageTitlesTests;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ArtPageTest extends BaseTest {

    @Test(description = "Verify Art Page title.")
    @Description("Test verifying Art Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-5")
    @Parameters("browser: chrome")
    public void verifyArtPageTitleTest() {
        header.clickOnArtLink();

        String title = header.getPageTitle();
//        Assert.assertEquals(title, "test");
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.ART_PAGE.getPageTitle());

    }
}
