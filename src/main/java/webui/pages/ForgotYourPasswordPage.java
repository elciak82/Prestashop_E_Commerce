package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class ForgotYourPasswordPage extends BasePage {
    public ForgotYourPasswordPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "email")
    WebElement emailField;

    @FindBy(id = "send-reset-link")
    WebElement sendResetLinkButton;

    @FindBy(className = "item")
    WebElement alertResetYourPassword;

    @Step("Insert an email to the email field.")
    public void insertEmail(String email) {
        emailField.sendKeys(email);
    }

    @Step("Click on the Send reset link button.")
    public void clickOnSendResetLinkButton() {
        sendResetLinkButton.click();
    }

    @Step("Get Reset Your Password alert text.")
    public String getResetYourPasswordAlertText() {
        return alertResetYourPassword.getText();
    }
}