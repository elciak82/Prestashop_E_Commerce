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

    public void clear() {
        getBaseElement().clear();
    }

    public void setText(String text) {
        getBaseElement().sendKeys(text);
    }

}
