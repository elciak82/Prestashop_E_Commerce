package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import webui.WebEntity;

import java.time.Duration;

public abstract class BasePage extends WebEntity {
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";

    public BasePage(WebDriver driver) {
        super(driver);
//        documentReady();
    }

    protected void fluentWaitForElementDisplayed(WebElement elementToBeDisplayed) {
        new FluentWait<>(elementToBeDisplayed)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(WebElement::isDisplayed);
    }

    protected void documentReady() {
        boolean readyStateComplete = false;
        while (!readyStateComplete) {
            JavascriptExecutor executor = (JavascriptExecutor) driver;
            executor.executeScript("window.scrollTo(0, document.body.offsetHeight)");
            readyStateComplete = executor.executeScript("return document.readyState").equals("complete");
        }
    }

    @Step("Get page title.")
    public String getPageTitle() {
        String title = driver.getTitle();
        System.out.println("The page title is " + title + ".");
        return title;
    }

    protected String getTextFromWebElement (WebElement webElement) {
        return webElement.getText();
    }

    protected static String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }
}