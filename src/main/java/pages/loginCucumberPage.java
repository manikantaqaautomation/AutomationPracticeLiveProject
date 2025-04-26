package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginCucumberPage {

	WebDriver driver;

    public loginCucumberPage(WebDriver driver) {
        this.driver = driver;
    }

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("submit");
    private By successMessage = By.tagName("h1");

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public void verifyLoginSuccess() {
        String text = driver.findElement(successMessage).getText();
        if (text.contains("Logged In Successfully")) {
            System.out.println("✅ Login successful");
        } else {
            System.out.println("❌ Login failed");
        }
    }
}
