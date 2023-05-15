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

public class AddressesPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Addresses Page title.")
    @Description("Test verifying Addresses Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-41")
    @Parameters("browser: chrome")
    public void verifyAddressesPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnSignIn()
                .correctLogInToAccount();

        var footer = new HomePage(driver).getFooter();
        footer.getYourAccountLinks().get(3).click();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.ADDRESSES_PAGE.getPageTitle());

    }
}
