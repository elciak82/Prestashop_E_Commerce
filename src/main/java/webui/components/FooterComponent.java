package webui.components;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.EditField;
import webui.pageobject.element.controls.Link;
import webui.pages.*;

import java.util.ArrayList;
import java.util.List;

public class FooterComponent extends BasePage {

    private final List<Link> productsLinks;
    private final List<Link> ourCompanyLinks;
    private final List<Link> yourAccountLinks;
    private final EditField emailField;
    private final Button subscribeButton;

//    @FindBy(css = "[name = 'email']") /// can I save it (as a WebElement) for singe items?
//    private WebElement emailField;

//    @FindBy(className = "input-wrapper")
//    private WebElement subscribeButton;

    public FooterComponent(WebDriver driver) {
        super(driver);

//        PageFactory.initElements(driver, this);

        emailField = new EditField(driver.findElement(By.cssSelector("[name = 'email']")));
        subscribeButton = new Button(driver.findElement(By.className("input-wrapper")));

        productsLinks = new ArrayList<>();
        List<WebElement> productsElements = driver.findElements(By.cssSelector("#footer_sub_menu_1 a"));
        for (WebElement e : productsElements) {
            productsLinks.add(new Link(e));
        }

        ourCompanyLinks = new ArrayList<>();
        List<WebElement> ourCompanyElements = driver.findElements(By.cssSelector("#footer_sub_menu_2 a"));
        for (WebElement e : ourCompanyElements) {
            ourCompanyLinks.add(new Link(e));
        }

        yourAccountLinks = new ArrayList<>();
        List<WebElement> yourAccountElements = driver.findElements(By.cssSelector("#footer_account_list a"));
        for (WebElement e : yourAccountElements) {
            yourAccountLinks.add(new Link(e));
        }
    }

    public EditField getEmailField() {
        return emailField;
    }

    public Button getSubscribeButton() {
        return subscribeButton;
    }

    public List<Link> getProductsLinks() {
        return productsLinks;
    }

    public List<Link> getOurCompanyLinks() {
        return ourCompanyLinks;
    }

    public List<Link> getYourAccountLinks() {
        return yourAccountLinks;
    }


}
