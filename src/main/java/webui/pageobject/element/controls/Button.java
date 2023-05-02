package webui.pageobject.element.controls;

import org.openqa.selenium.WebElement;

import webui.common.Control;

public class Button extends Control {

    public Button(WebElement element) {
        super(element);
    }

    public void click() {
        getBaseElement().click();
    }

    public void getText() {

    }

}
