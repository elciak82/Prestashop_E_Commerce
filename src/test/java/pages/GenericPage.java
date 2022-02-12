package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class GenericPage {
    WebDriver driver;

    GenericPage(WebDriver driver) {
        this.driver = driver;
//        documentReady();
    }

    public void fluentWaitForElementDisplayed(WebElement elementToBeDisplayed) {
        new FluentWait<>(elementToBeDisplayed)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(500))
                .ignoring(NoSuchElementException.class)
                .until(WebElement::isDisplayed);
    }

    public void documentReady() {
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

    public void mouseClickByLocator( WebElement cssLocator ) {
        Actions builder = new Actions(driver);
        builder.moveToElement(cssLocator);
        builder.perform();
    }

}