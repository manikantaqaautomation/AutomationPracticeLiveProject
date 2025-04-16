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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_016 extends Base{

	WebDriver driver;

	@BeforeMethod

	public void setup() {
		driver = openBrowserAndApplication();
		// Test Step-1
		// Click on 'My Account' drop down menu
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// Select the option from 'My Account' drop down menu
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		// User able to see Register Account page
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test

	public void verifyRegisterAccountWithSpacesOnly() {

		// Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys(" ");
		driver.findElement(By.id("input-lastname")).sendKeys(" ");
		driver.findElement(By.id("input-email")).sendKeys(" ");
		driver.findElement(By.id("input-telephone")).sendKeys(" ");
		driver.findElement(By.id("input-password")).sendKeys(" ");
		driver.findElement(By.id("input-confirm")).sendKeys(" ");
		// Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		// Expected Result
		String fistNameWarning = "First Name must be between 1 and 32 characters!";
		String lastNameWarning = "Last Name must be between 1 and 32 characters!";
		String emailWarning = "E-Mail Address does not appear to be valid!";
		String telephoneWarning = "Telephone must be between 3 and 32 characters!";
		String passwordWarning = "Password must be between 4 and 20 characters!";

		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-firstname']/following-sibling::div")).getText(),
				fistNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-lastname']/following-sibling::div")).getText(),
				lastNameWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div")).getText(),
				emailWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText(),
				telephoneWarning);
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(),
				passwordWarning);

	}

}
