package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Label;

public class AccessoriesPage extends HeaderComponent {

    public AccessoriesPage(WebDriver driver) {
        super(driver);
    }

    public String getAccessoryTitle(){
        return new Label(driver.findElement(By.xpath("//*[@id='wrapper']/div/nav/ol/li[4]/span"))).getText();
    }
}