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
import webui.pages.HomePage;

public class ContactUsPageTests extends BaseTest {

    @Test(testName = "Verify Contact Us Page title.")
    @Description("Test verifying Contact Us Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-2")
    @Parameters("browser: chrome")
    public void verifyContactUsPageTitleTest() {
        String title = new HomePage(driver)
                .openContactUsPage()
                .getPageTitle();

        Assert.assertEquals(title, PageTitleEnums.Titles.CONTACT_US_PAGE.getPageTitle());
    }
}
