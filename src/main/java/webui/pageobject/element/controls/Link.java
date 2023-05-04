package webui.pageobject.element.controls;

import org.openqa.selenium.WebElement;
import webui.common.Control;

public class Link extends Control {

    public Link(WebElement baseElement) {
        super(baseElement);
    }

    public void click() {
        getBaseElement().click();
    }

    public void getText() {
        getBaseElement().getText();
    }
}
