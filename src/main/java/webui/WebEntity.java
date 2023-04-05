package webui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.List;


public abstract class WebEntity {
    public WebDriver driver;

    public WebEntity(WebDriver driver) {
        this.driver = driver;
    }

    protected void hoverOnElement(WebElement cssLocator ) {
        Actions builder = new Actions(driver);
        builder.moveToElement(cssLocator);
        builder.perform();
    }

//    protected List<String> getAllResults(List<WebElement> webElements){
//        List<String> searchResultsLists = new ArrayList<>(); //deklarujemy listę stringów
//        //dekladujemy listę webelementów
//        List<WebElement> searchResultsWebElementsList = new ArrayList<>(webElements); //UZYJ EWALUATE (NOTATKI) dodajemy wszystkie wyszukane wartości do listy
//        for (WebElement element : searchResultsWebElementsList) { //dla kazdego elementu z listy webelementów iteracja
//            searchResultsLists.add(element.getText()); //pobierz jego text i dodaj do do listy stringów
//        }
//        System.out.println(searchResultsLists);
//        return searchResultsLists; //na końcu ją zwróć. To jest cała lista. lista jest ok dla list, dla tebael lepsza jest mapa


}