package stepdefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.When;

public class LoginStepsMultiple {
	
	WebDriver driver;
	
	@When("I enter multiple credentials")
	public void i_enter_multiple_credentials() {
	    String[][] credentials = {
	        {"student", "Password123"},
	        {"admin", "Admin123"},
	        {"test", "Test123"}
	    };

	    for (String[] pair : credentials) {
	        driver.get("https://practicetestautomation.com/practice-test-login/");
	        driver.findElement(By.id("username")).sendKeys(pair[0]);
	        driver.findElement(By.id("password")).sendKeys(pair[1]);
	        driver.findElement(By.id("submit")).click();
	        driver.navigate().back();
	    }
	}


}
