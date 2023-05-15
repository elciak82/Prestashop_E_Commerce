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

public class SecurePaymentPageTests extends BaseTest {

    @Test(testName = "Verify Secure Payment Page title.")
    @Description("Test verifying Secure Payment Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-35")
    @Parameters("browser: chrome")
    public void verifySecurePaymentPageTitleTest() {
        var footer = new HomePage(driver).getFooter();
        footer.getOurCompanyLinks().get(4).click();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.SECURE_PAYMENT_PAGE.getPageTitle());

    }
}
