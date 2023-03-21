package tests.pagetitles;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.pages.HomePage;

public class ClothesPageTests extends BaseTest {

    @Test(testName = "Verify Clothes Page title.")
    @Description("Test verifying Clothes Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-3")
    @Parameters("browser: chrome")
    public void verifyClothesPageTitleTest() {
        String title = new HomePage(driver)
                .openClothePage()
                .getPageTitle();

        Assert.assertEquals(title, PageTitleEnums.Titles.CLOTHES_PAGE.getPageTitle());

    }
}
