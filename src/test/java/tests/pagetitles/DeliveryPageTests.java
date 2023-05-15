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

public class DeliveryPageTests extends BaseTest {

    @Test(testName = "Verify Delivery Page title.")
    @Description("Test verifying Delivery Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-31")
    @Parameters("browser: chrome")
    public void verifyDeliveryPageTitleTest() {
        var footer = new HomePage(driver).getFooter();
        footer.getOurCompanyLinks().get(0).click();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.DELIVERY_PAGE.getPageTitle());

    }
}
