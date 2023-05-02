package webui.common;

import org.openqa.selenium.WebElement;

public abstract class Control {

    private final WebElement baseElement;

    public Control(WebElement baseElement){
        this.baseElement = baseElement;
    }

    public WebElement getBaseElement() {
        return baseElement;
    }

}
