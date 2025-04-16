package tutorialninja.register;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtils;

public class TC_RF_011 extends Base{

	WebDriver driver;
	Properties prop;

	@BeforeMethod

	public void setup() {
		driver = openBrowserAndApplication();
		prop = commonUtils.loadProperties();
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
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("abcde");
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
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
