package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import webui.WebEntity;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class BasePage extends WebEntity {

    public BasePage(WebDriver driver) {
        super(driver);
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

    public List<String> getAllResults(List<WebElement> webElements) {
        List<WebElement> links = new ArrayList<>(webElements);
        List<String> filterLinks = links
                .stream()
                .map(WebElement::getText)
                .filter(text -> !text.equals(""))
                .collect(Collectors.toList());
        System.out.println(filterLinks);
        return filterLinks;
    }


}