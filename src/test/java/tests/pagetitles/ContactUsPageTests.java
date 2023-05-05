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

public class ContactUsPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Contact Us Page title.")
    @Description("Test verifying Contact Us Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-2")
    @Parameters("browser: chrome")
    public void verifyContactUsPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnContactUsPage();
        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.CONTACT_US_PAGE.getPageTitle());

        var footer = new HomePage(driver).getFooter();
        footer.getOurCompanyLinks().get(5).click();
        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.CONTACT_US_PAGE.getPageTitle());
    }
}
