package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class PersonalInfoPage extends HeaderComponent {
    public PersonalInfoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
}