package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class MenPage extends BasePage {
    public MenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}