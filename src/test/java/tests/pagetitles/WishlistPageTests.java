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

public class WishlistPageTests extends BaseTest {
    HeaderComponent header;

    @Test(testName = "Verify Wishlist title.")
    @Description("Test verifying Wishlist title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-42")
    @Parameters("browser: chrome")
    public void verifyWishlistPageTitleTest() {
        header = new HeaderComponent(driver);
        header.clickOnSignIn()
                .correctLogInToAccount();

        var footer = new HomePage(driver).getFooter();
        footer.getYourAccountLinks().get(4).click();

        Assert.assertEquals(header.getPageTitle(), PageTitleEnums.Titles.WISHLIST_PAGE.getPageTitle());

        header.getSignOutButton();

    }
}
