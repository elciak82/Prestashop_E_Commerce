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

public class AboutUsPageTest extends BaseTest {

    @Test(testName = "Verify About Us Page title.")
    @Description("Test verifying About Us Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-34")
    @Parameters("browser: chrome")
    public void verifyAboutUsPageTitleTest() {
        var footer = new HomePage(driver).getFooter();
        footer.getOurCompanyLinks().get(3).click();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.ABOUT_US_PAGE.getPageTitle());

    }
}
