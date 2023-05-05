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

public class NewProductsPageTests extends BaseTest {

    @Test(testName = "Verify New Products Page title.")
    @Description("Test verifying New Products Page title.")
    @Severity(SeverityLevel.CRITICAL)
    @TmsLink("PRESTASHOP-29")
    @Parameters("browser: chrome")
    public void verifyNewProductsPageTitleTest() {
        var footer = new HomePage(driver).getFooter();
        footer.getProductsLinks().get(1).click();

        Assert.assertEquals(new HeaderComponent(driver).getPageTitle(), PageTitleEnums.Titles.NEW_PRODUCTS_PAGE.getPageTitle());

    }
}
