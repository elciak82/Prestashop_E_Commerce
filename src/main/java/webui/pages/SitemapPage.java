package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class SitemapPage extends HeaderComponent {
    public SitemapPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}