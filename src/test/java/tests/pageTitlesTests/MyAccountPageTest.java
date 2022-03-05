package tests.pageTitlesTests;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class MyAccountPageTest extends BaseTest {

    @Test(description = "Verify My Account Page title.")
    @Description("Test verifying My Account Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-9")
    @Parameters("browser: chrome")
    public void verifyMyAccountPageTitleTest() {
        header.clickOnLoginLink().correctLogInToAccount();

        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.MY_ACCOUNT_PAGE.getPageTitle());

    }
}
