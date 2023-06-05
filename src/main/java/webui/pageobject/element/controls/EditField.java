package webui.pageobject.element.controls;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import webui.common.Control;

public class EditField extends Control {

    public EditField(WebElement element) {
        super(element);
    }

    public String getText() {
       return getBaseElement().getText();
    }

    public void click() {
        getBaseElement().click();
    }

    public void clear() {
        getBaseElement().clear();
    }

    public void setText(String text) {
        getBaseElement().sendKeys(text);
    }

    public void setKey(Keys key) {
        getBaseElement().sendKeys(key);
    }

    public void isDisplayed() {
        getBaseElement().isDisplayed();
    }

}
