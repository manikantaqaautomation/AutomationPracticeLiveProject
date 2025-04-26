package getMultipleWindowAlert;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SimpleAlertExample {
	
	public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://demo.automationtesting.in/Alerts.html");

        // Click on the button to trigger alert
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        // Switch to alert
        Alert alert = driver.switchTo().alert();

        // Get text and accept
        System.out.println("Alert Text: " + alert.getText());
        alert.accept();

        driver.quit();
    }

}
