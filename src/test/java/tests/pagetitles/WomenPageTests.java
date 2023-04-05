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

public class WomenPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Women Page title.")
    @Description("Test verifying Women Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-7")
    @Parameters("browser: chrome")
    public void verifyWomenPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnWomenPage();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.WOMEN_PAGE.getPageTitle());

    }
}
