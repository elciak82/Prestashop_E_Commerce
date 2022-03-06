package tests.pageTitlesTests;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.*;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ClothesPageTests extends BaseTest {

    @Test(description = "Verify Clothes Page title.")
    @Description("Test verifying Clothes Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-3")
    @Parameters("browser: chrome")
    public void verifyClothesPageTitleTest() {
        header.clickOnClothesLink();

        String title = header.getPageTitle();
//        Assert.assertEquals(title, "test");
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.CLOTHES_PAGE.getPageTitle());

    }
}
