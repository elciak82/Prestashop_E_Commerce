package tests.pagetitles;

import org.testng.annotations.Test;
import tests.BaseTest;

import static verifactions.PrestashopAsserts.prestashopAsserts;

public class CartTests extends BaseTest {

    @Test
    public void verifyCartPageTitleTest() {
        // HomePage().goToCart();
        prestashopAsserts(driver).cartAsserts().verifyCartPageIsRendered();
    }
}
