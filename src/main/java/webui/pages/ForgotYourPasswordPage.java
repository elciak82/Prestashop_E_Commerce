package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webui.WebEntity;
import webui.components.HeaderComponent;
import webui.pageobject.element.controls.Button;
import webui.pageobject.element.controls.EditField;
import webui.pageobject.element.controls.Label;


public class ForgotYourPasswordPage extends HeaderComponent {

    private final EditField emailAddressField;
    private final Button sendResetLinkButton;

    public ForgotYourPasswordPage(WebDriver driver) {
        super(driver);
        sendResetLinkButton = new Button(driver.findElement(By.id("send-reset-link")));
        emailAddressField = new EditField(driver.findElement(By.id("email")));
    }

    @Step("Set the email field.")
    public ForgotYourPasswordPage setEmailAddress(String email) {
        emailAddressField.setText(email);
        return this;
    }

    @Step("Get the Send Reset Link Button.")
    public Button getSendResetLinkButton() {
        return sendResetLinkButton;
    }

    @Step("Click on the Send reset link button.")
    public ForgotYourPasswordPage clickOnSendResetLinkButton() {
        getSendResetLinkButton().click();
        return this;
    }

    @Step("Get Reset Your Password alert text.")
    public String getResetYourPasswordAlertText() {
        return new Label(driver.findElement(By.className("item"))).getText();
    }
}