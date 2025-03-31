package practice;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class verifyMultipleWindowsHandle {
	
	WebDriver driver;
	String mainWindowHandle;
	
	@Test
	public void verifyOmaYoWebSiteMultipleWindowsHandle() throws InterruptedException {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		 // Open website
        driver.get("https://demo.automationtesting.in/Windows.html");

        // Click on a link that opens a new window
        WebElement newTabLink = driver.findElement(By.xpath("//a[contains(text(),'Open New Seperate Windows')]"));
        newTabLink.click();

        WebElement button = driver.findElement(By.xpath("//div[@id='Seperate']//button[text()='click']"));
        button.click();

        // Get current window handle
        mainWindowHandle = driver.getWindowHandle();
        
        switchToWindow("Selenium");

		/*
		 * // Get all window handles Set<String> windowHandles =
		 * driver.getWindowHandles(); Iterator<String> iterator =
		 * windowHandles.iterator();
		 * 
		 * while (iterator.hasNext()) { String childWindow = iterator.next();
		 * 
		 * // Switch to new window if (!mainWindowHandle.equals(childWindow)) {
		 * driver.switchTo().window(childWindow);
		 * System.out.println("Switched to new window: " + driver.getTitle());
		 * 
		 * // Perform actions in the new window Thread.sleep(2000); // Just to observe
		 * driver.close(); // Close the new window } }
		 */

        // Switch back to the main window
        driver.switchTo().window(mainWindowHandle);
        System.out.println("Switched back to main window: " + driver.getTitle());

        // Close the main window
        driver.quit();
	}
	
	public void switchToWindow(String title) throws InterruptedException {
		
		// Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> iterator = windowHandles.iterator();

            while (iterator.hasNext()) {
            String childWindow = iterator.next();

            // Switch to new window
            if (!mainWindowHandle.equals(childWindow)) {
                driver.switchTo().window(childWindow);
                System.out.println("Switched to new window: " + driver.getTitle());

                // Perform actions in the new window
                Thread.sleep(2000);  // Just to observe
                driver.close();  // Close the new window
            }
        }
		
	}
}
