package webui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import webui.components.HeaderComponent;
import webui.elements.EditField;

// EXAMPLE
public class TestPage extends HeaderComponent {

    private EditField firstName;
    private EditField lastName;
    private EditField email;
    private EditField password;

    public TestPage(WebDriver driver) {
        super(driver);
        initElements();
    }

    private void initElements() {
        firstName = new EditField(driver, driver.findElement(By.name("sdfsdfdsf")));
        lastName = new EditField(driver, driver.findElement(By.name("sdfsdfdsf")));
        email = new EditField(driver, driver.findElement(By.name("sdfsdfdsf")));
        password = new EditField(driver, driver.findElement(By.name("sdfsdfdsf")));
    }

    public EditField getFirstName() {
        return firstName;
    }

    public EditField getLastName() {
        return lastName;
    }

    public EditField getEmail() {
        return email;
    }

    public EditField getPassword() {
        return password;
    }
}
