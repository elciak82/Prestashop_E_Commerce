package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.pages.GenericPage;

public class MenPage extends GenericPage {
    public MenPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}