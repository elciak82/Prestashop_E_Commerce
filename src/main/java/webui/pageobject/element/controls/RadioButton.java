package webui.pageobject.element.controls;

import org.openqa.selenium.WebElement;
import webui.common.Control;

public class RadioButton extends Control {

    public RadioButton(WebElement element) {
        super(element);
    }

    public void click() {
        getBaseElement().click();

    }

}
