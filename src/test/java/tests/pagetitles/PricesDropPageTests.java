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

public class PricesDropPageTests extends BaseTest {

    @Test(testName = "Verify Prices Drop Page title.")
    @Description("Test verifying Prices Drop Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-28")
    @Parameters("browser: chrome")
    public void verifyPricesDropPageTitleTest() {
        var footer = new HomePage(driver).getFooter();
        footer.getProductsLinks().get(0).click();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.PRICES_DROP_PAGE.getPageTitle());

    }
}
