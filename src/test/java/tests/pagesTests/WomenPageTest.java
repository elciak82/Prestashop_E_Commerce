package tests.pagesTests;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class WomenPageTest extends BaseTest {

    @Test(description = "Verify Women Page title.")
    @Description("Test verifying Women Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-7")
    @Parameters("browser: chrome")
    public void verifyWomenPageTitleTest() {
        header.clickOnWomenLink();

        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.WOMEN_PAGE.getPageTitle());

    }
}
