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
import webui.pages.HomePage;

public class BestSalesPageTests extends BaseTest {

    @Test(testName = "Verify Best Sales Page title.")
    @Description("Test verifying Best Sales Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-30")
    @Parameters("browser: chrome")
    public void verifyBestSalesPageTitleTest() {
        var footer = new HomePage(driver).getFooter();
        footer.getProductsLinks().get(2).click();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.BEST_SALES_PAGE.getPageTitle());

    }
}
