package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.Label;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CartPage extends HeaderComponent {
    private final Label cartProductCountsLabel;
    private final Label productTitleLabel;
    private final Button proceedToCheckoutButton;

    public CartPage(WebDriver driver) {
        super(driver);
        cartProductCountsLabel = new Label(driver.findElement(By.className("cart-products-count")));
        productTitleLabel = new Label(driver.findElement(By.cssSelector("[data-id_customization='0']")));
        proceedToCheckoutButton = new Button(driver.findElement(By.xpath("//a[contains(string(), 'Proceed to checkout')]")));

    }

    public Label getCartProductCountsLabel() {
        return cartProductCountsLabel;
    }

    public String getCartProductCounts() {
        return getShippingPrice(getCartProductCountsLabel().getText());
    }

    public Label getProductTitleLabel() {
        return productTitleLabel;
    }

    public String getProductTitle() {
        return getProductTitleLabel().getText();
    }

    public Button getProceedToCheckoutButton() {
        return proceedToCheckoutButton;
    }

    public CheckoutPersonalInfoPage proceedToCheckoutOnCartPage() {
        proceedToCheckoutButton.click();
        return new CheckoutPersonalInfoPage(driver);
    }

    private String getShippingPrice(String numbersOfProducts) {
        Pattern p = Pattern.compile("[^()]+(?=\\))");
        Matcher m = p.matcher(numbersOfProducts);
        while (m.find()) {
            return m.group();

        }
        return null;
    }

}