package tests.pagesTests;

import helpers.enums.PageTitleEnums;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.TmsLink;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import tests.BaseTest;

public class ContactUsPageTests extends BaseTest {

    @Test(description = "Verify Contact Us Page Title")
    @Description("Test verifying Contact Us Page title")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-2")
    @Parameters("browser: chrome")
    public void verifyHomContactUsPageTitleTest(){
        header.clickOnContactUsLink();

        String title = header.getPageTitle();
        Assert.assertEquals(title, PageTitleEnums.TitlesEnums.CLOTHES_PAGE.getPageTitle());
    }
}
