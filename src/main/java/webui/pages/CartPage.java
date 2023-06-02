package webui.pages;

import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Label;

public class CartPage extends HeaderComponent {

    private Label label;

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Label getLabel() {
        return label;
    }
}
