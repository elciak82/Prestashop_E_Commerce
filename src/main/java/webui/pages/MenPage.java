package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.WebEntity;
import webui.components.HeaderComponent;

public class MenPage extends HeaderComponent {
    public MenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}