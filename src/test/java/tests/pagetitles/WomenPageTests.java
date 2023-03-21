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

public class WomenPageTests extends BaseTest {

    @Test(testName = "Verify Women Page title.")
    @Description("Test verifying Women Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-7")
    @Parameters("browser: chrome")
    public void verifyWomenPageTitleTest() {
        String title = new HomePage(driver)
                .openWomenPage()
                .getPageTitle();

        Assert.assertEquals(title, PageTitleEnums.Titles.WOMEN_PAGE.getPageTitle());

    }
}