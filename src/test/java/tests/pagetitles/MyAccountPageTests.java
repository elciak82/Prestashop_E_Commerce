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
import webui.components.HeaderComponent;

public class MyAccountPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify My Account Page title.")
    @Description("Test verifying My Account Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-9")
    @Parameters("browser: chrome")
    public void verifyMyAccountPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnSignIn()
                .correctLogInToAccount();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.MY_ACCOUNT_PAGE.getPageTitle());

        header.getSignOutButton();

    }
}
