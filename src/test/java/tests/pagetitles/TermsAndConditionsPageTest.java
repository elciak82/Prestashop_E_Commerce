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

public class TermsAndConditionsPageTest extends BaseTest {

    @Test(testName = "Verify Terms and Conditions Page title.")
    @Description("Test verifying Terms and Conditions Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-33")
    @Parameters("browser: chrome")
    public void verifyTermsAndConditionsPageTitleTest() {
        new FooterComponent(driver).clickOnTermsAndConditionsLink();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.TERMS_AND_CONDITIONS_PAGE.getPageTitle());

    }
}
