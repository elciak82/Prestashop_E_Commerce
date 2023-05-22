package webui.pageobject.element.controls;

import org.openqa.selenium.WebElement;
import webui.common.Control;

public class Label extends Control {

    public Label(WebElement element) {
        super(element);
    }

    public String getText() {
       return getBaseElement().getText();
    }

}
