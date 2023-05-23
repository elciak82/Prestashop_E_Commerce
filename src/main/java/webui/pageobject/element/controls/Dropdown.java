package webui.pageobject.element.controls;

import org.openqa.selenium.WebElement;
import webui.common.Control;

public class Dropdown extends Control {

    public Dropdown(WebElement element) {
        super(element);
    }

    public void click() {
        getBaseElement().click();

    }

}
