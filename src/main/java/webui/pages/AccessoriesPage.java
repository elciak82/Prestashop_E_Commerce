package webui.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccessoriesPage extends GenericPage {
    public AccessoriesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // TODO: 3/16/2023
    @FindBy (xpath = "//*[@id='wrapper']/div/nav/ol/li[4]/span")
    WebElement accessoryTitle;

    public String getAccessoryTitle(){
        return accessoryTitle.getText();
    }
}