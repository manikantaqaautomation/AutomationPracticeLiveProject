package tutorialninja.register;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtils;

public class TC_RF_003 extends Base{

	WebDriver driver;

	Properties prop;
	
	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

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

	@Test
	public void verifyRegisterWithAllFields() {
		// Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		// Click on Newsletter option
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		// Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		// Expected Result
		// Account will be created
		// Check the verification Account is Logged in
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		// Check Account success Message
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

		// Account creation message
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		// Check the proper details message
		String actualproperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualproperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualproperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualproperDetailsFour = "contact us";

		String expectedProperDetails = driver.findElement(By.id("content")).getText();

		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsFour));

		// Navigate back to Account page click on Continue button

		driver.findElement(By.xpath("//a[text()='Continue']")).click();

		// Verify the Account page

		driver.findElement(By.linkText("Edit your account information")).isDisplayed();

	}

}
