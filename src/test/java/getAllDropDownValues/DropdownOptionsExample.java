package getAllDropDownValues;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropdownOptionsExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.opencart.com/index.php?route=account/register");

        // Locate the drop-down element (e.g., country drop-down)
        WebElement countryDropdown = driver.findElement(By.id("input-country"));

        // Create Select object
        Select select = new Select(countryDropdown);

        // Get all options from the drop-down
        List<WebElement> allOptions = select.getOptions();

        // Print all the values (visible text)
        System.out.println("Available values in drop-down:");
        for (WebElement option : allOptions) {
            System.out.println(option.getText());
        }

        driver.quit();
		

	}

}
