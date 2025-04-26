package oopsconcepts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

//Abstraction + Factory Design
public class DriverFactory {

	    public static WebDriver initDriver(String browser) {
	        if (browser.equalsIgnoreCase("chrome")) {
	            return new ChromeDriver();
	        }
	        // can add more browser types here
	        throw new RuntimeException("Browser not supported");
	    }
	}
