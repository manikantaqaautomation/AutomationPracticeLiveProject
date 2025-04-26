package elementScreenShot;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class ElementScreenshotExample {

	public static void main(String[] args) throws IOException {
        // Set up WebDriver
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Navigate to a website
        driver.get("https://www.google.com");

        // Locate a WebElement (e.g., the Google logo)
        WebElement logo = driver.findElement(By.cssSelector("body > div.L3eUgb > div.o3j99.LLD4me.yr19Zb.LS8OJ > div > svg"));

        // Take screenshot of the WebElement
        File screenshot = logo.getScreenshotAs(OutputType.FILE);

        // Save the screenshot to your system
        File destination = new File("Screenshots/google-logo.png");
        FileHandler.copy(screenshot, destination);

        System.out.println("Element screenshot saved at: " + destination.getAbsolutePath());

        driver.quit();
    }
}
