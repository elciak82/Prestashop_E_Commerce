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

public class AccessoriesPageTest extends BaseTest {

    @Test(description = "Verify Accessories Page title.")
    @Description("Test verifying Accessories Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-4")
    @Parameters("browser: chrome")
    public void verifyAccessoriesPageTitleTest() {
        header.clickOnAccessoriesLink();

        String title = header.getPageTitle();
//        Assert.assertEquals(title, "test");
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.ACCESSORIES_PAGE.getPageTitle());

    }
}
