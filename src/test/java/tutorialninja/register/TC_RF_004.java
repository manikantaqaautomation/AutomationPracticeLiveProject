package tutorialninja.register;


import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC_RF_004 {

	WebDriver driver;

	@BeforeMethod

	public void setup() {
		String browserName = "chrome";
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			driver = new SafariDriver();
		} else if (browserName.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		// Open the URL
		driver.get("https://tutorialsninja.com/demo/");
		// Test Step-1
		// Click on 'My Account' drop down menu
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// Select the option from 'My Account' drop down menu
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		// User able to see Register Account page
	}
	
	@AfterTest
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}

	@Test
	public void verifyRegisteringAccountWithoutFillingFields() {

		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Expected warning message with out filling the fields and click on Continue
		// button
		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),
				expectedFirstNameWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),
				expectedLastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),
				expectedEmailWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
				expectedTelephoneWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				expectedPasswordWarning);
		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(),
				expectedPrivacyPolicyWarning);

	}

}
