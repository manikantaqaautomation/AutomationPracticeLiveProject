package tutorialninja.register;

import java.time.Duration;
import java.util.Date;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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

import utils.commonUtils;

public class TC_RF_011 {

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

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void verifyRegisteringAccountByProvidingInvalidPhoneNumber() {
		// Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys("Test1");
		driver.findElement(By.id("input-lastname")).sendKeys("Test2");
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("abcde");
		driver.findElement(By.id("input-password")).sendKeys("Test@12345");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@12345");
		// Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		// Expected Result

		String expectedWarningMessage = "Telephone number does not appear to be valid!";
		
		boolean state = false;
		
		try {
			String actualWarningMessage = driver.findElement(By.xpath("//input[@id='input-telephone']/following-sibling::div")).getText();
			
			if(actualWarningMessage.equals(expectedWarningMessage)) {
				state =true;
			} 
		}catch(NoSuchElementException e){
			state =false;
		}
		
		Assert.assertTrue(state);

		/*
		 * Assert.assertEquals( driver.findElement(By.xpath(
		 * "//input[@id='input-telephone']/following-sibling::div")).getText(),
		 * expectedWarningMessage);
		 */
	}

}
