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

public class StoresPageTest extends BaseTest {

    @Test(testName = "Verify Stores Page title.")
    @Description("Test verifying Stores Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-37")
    @Parameters("browser: chrome")
    public void verifyStoresPageTitleTest() {
        new FooterComponent(driver).clickOnStoresLink();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.STORES_PAGE.getPageTitle());

    }
}
