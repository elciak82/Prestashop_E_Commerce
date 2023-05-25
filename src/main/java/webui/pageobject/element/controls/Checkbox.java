package webui.pageobject.element.controls;

import org.openqa.selenium.WebElement;
import webui.common.Control;

public class Checkbox extends Control {

    public Checkbox(WebElement element) {
        super(element);
    }

    public void click() {
        getBaseElement().click();

    }

}
