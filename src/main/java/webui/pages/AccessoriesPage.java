package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Label;

public class AccessoriesPage extends HeaderComponent {
    Label accessoryTitle;

    public AccessoriesPage(WebDriver driver) {
        super(driver);
        accessoryTitle = new Label(driver.findElement(By.xpath("//*[@id='wrapper']/div/nav/ol/li[4]/span")));
    }

    public String getAccessoryTitle(){
        return accessoryTitle.getText();
    }
}