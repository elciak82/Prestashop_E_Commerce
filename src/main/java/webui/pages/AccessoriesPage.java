package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;

public class AccessoriesPage extends HeaderComponent {

    // TODO: 3/16/2023
    @FindBy (xpath = "//*[@id='wrapper']/div/nav/ol/li[4]/span")
    private WebElement accessoryTitle;

    public AccessoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getAccessoryTitle(){
        return accessoryTitle.getText();
    }
}