package webui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public abstract class WebEntity {
    public WebDriver driver;

    public WebEntity(WebDriver driver) {
        this.driver = driver;
    }

    protected void hoverOnElement(WebElement cssLocator) {
        Actions builder = new Actions(driver);
        builder.moveToElement(cssLocator);
        builder.perform();
    }

    public String getTextFromWebElement(WebElement webElement) {
        System.out.println(webElement.getText());
        return webElement.getText();
    }
}