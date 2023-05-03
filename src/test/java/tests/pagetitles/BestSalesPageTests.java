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

public class BestSalesPageTests extends BaseTest {

    @Test(testName = "Verify Best Sales Page title.")
    @Description("Test verifying Best Sales Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-30")
    @Parameters("browser: chrome")
    public void verifyBestSalesPageTitleTest() {
        new FooterComponent(driver).clickOnBestSalesLink();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.BEST_SALES_PAGE.getPageTitle());

    }
}
