package oopsconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Encapsulation + Polymorphism

//Encapsulation	LoginPage class hides locators & logic

//login() vs loginAsAdmin() in LoginPage

public class LoginPage {
	
	private WebDriver driver;

    // Encapsulated locators
    private By username = By.id("username");
    private By password = By.id("password");
    private By loginBtn = By.id("login");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Polymorphism: Can be overloaded
    public void login(String user, String pass) {
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }

    public void loginAsAdmin() {
        login("admin", "admin123");
    }

}
