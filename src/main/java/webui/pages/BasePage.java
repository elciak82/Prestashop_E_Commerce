package webui.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasePage {
    public WebDriver driver;
    private static final String ALPHA_STRING = "abcdefghijklmnoprstuvwxyz";

    public BasePage(WebDriver driver) {
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

    public String getTextFromWebElement (WebElement webElement) {
        return webElement.getText();
    }

    public static String randomAlphaString(int count) {
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_STRING.length());
            builder.append(ALPHA_STRING.charAt(character));
        }
        return builder.toString();
    }

    public List<String> getAllResults(List<WebElement> webElements){
        List<String> searchResultsLists = new ArrayList<>(); //deklarujemy listę stringów
        //dekladujemy listę webelementów
        List<WebElement> searchResultsWebElementsList = new ArrayList<>(webElements); //UZYJ EWALUATE (NOTATKI) dodajemy wszystkie wyszukane wartości do listy
        for (WebElement element : searchResultsWebElementsList) { //dla kazdego elementu z listy webelementów iteracja
            searchResultsLists.add(element.getText()); //pobierz jego text i dodaj do do listy stringów
        }
        System.out.println(searchResultsLists);
        return searchResultsLists; //na końcu ją zwróć. To jest cała lista. lista jest ok dla list, dla tebael lepsza jest mapa
    }

    public List<String> getAllResultsStream(List<WebElement> webElements){
        List<WebElement> links = new ArrayList<>(webElements);
        List<String> filterLinks = links
                .stream()
                .map(WebElement::getText)
                .filter(text ->!text.equals(""))
                .collect(Collectors.toList());
        System.out.println(filterLinks);
        return filterLinks;
    }



}