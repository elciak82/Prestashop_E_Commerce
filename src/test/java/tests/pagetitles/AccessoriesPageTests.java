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

public class AccessoriesPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Accessories Page title.")
    @Description("Test verifying Accessories Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-4")
    @Parameters("browser: chrome")
    public void verifyAccessoriesPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnAccessoriesPage();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.ACCESSORIES_PAGE.getPageTitle());

    }
}
