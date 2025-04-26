package oopsconcepts;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//Inheritance Implementation

public class BaseTest {
	protected WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.initDriver("chrome");
        driver.get("https://example.com/login");
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

}
