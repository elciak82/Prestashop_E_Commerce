package tests.pagetitles;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;
import webui.components.HeaderComponent;

public class ClothesPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Clothes Page title.")
    @Description("Test verifying Clothes Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-3")
    @Parameters("browser: chrome")
    public void verifyClothesPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnClothesPage();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.CLOTHES_PAGE.getPageTitle());

    }
}
