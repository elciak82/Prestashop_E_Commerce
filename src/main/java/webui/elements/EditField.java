package webui.elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import webui.WebEntity;

// EXAMPLE
public class EditField extends WebEntity {

    private final WebElement generalElement;

    public EditField(WebDriver driver, WebElement element) {
        super(driver);
        this.generalElement = element;
    }

    public void putValue(String value) {
        generalElement.sendKeys(value);
    }

    public void cleanValue() {
        generalElement.clear();
    }
}
