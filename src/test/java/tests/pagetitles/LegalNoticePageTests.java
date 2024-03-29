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

public class LegalNoticePageTests extends BaseTest {

    @Test(testName = "Verify Legal Notice Page title.")
    @Description("Test verifying Legal Notice Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-32")
    @Parameters("browser: chrome")
    public void verifyLegalNoticePageTitleTest() {
        var footer = new HomePage(driver).getFooter();
        footer.getOurCompanyLinks().get(1).click();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.LEGAL_NOTICE_PAGE.getPageTitle());

    }
}
