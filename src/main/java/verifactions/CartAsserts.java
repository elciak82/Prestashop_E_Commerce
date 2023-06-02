package verifactions;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import webui.pageobject.element.controls.Label;
import webui.pages.CartPage;

public class CartAsserts extends BaseAsserts {


    CartAsserts(WebDriver driver) {
        super(driver);
    }

    public CartAsserts verifyCartPageIsRendered() {
        Label label = new CartPage(driver).getLabel();
        Assert.assertEquals(label.getText(), "Cart");
        return this;
    }
}
