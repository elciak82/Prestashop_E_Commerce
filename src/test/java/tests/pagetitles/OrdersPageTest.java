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

public class OrdersPageTest extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Orders Page title.")
    @Description("Test verifying Orders Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-39")
    @Parameters("browser: chrome")
    public void verifyOrdersPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnSignIn()
                .correctLogInToAccount();

        new FooterComponent(driver).clickOnOrdersLink();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.ORDERS_PAGE.getPageTitle());

    }
}
