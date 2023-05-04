package webui.pageobject.element.controls;

import org.openqa.selenium.WebElement;
import webui.common.Control;

public class EditField extends Control {

    public EditField(WebElement element) {
        super(element);
    }

    public String getText() {
       return getBaseElement().getText();
    }

    public String getValue() {
        return getBaseElement().getAttribute("value");
    }

    public EditField setText(String text) {
        getBaseElement().sendKeys(text);
        return this;
    }

    public EditField clear() {
        getBaseElement().clear();
        return this;
    }
}
