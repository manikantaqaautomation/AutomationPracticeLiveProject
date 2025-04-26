package tutorialninja.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_013 extends Base{

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

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void verifyPlaceHolderTextInputFieldsInRegisteringAccountPage() {

		String expectedPlaceHolderFirstName = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("placeholder"),
				expectedPlaceHolderFirstName);

		String expectedPlaceHolderLastName = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("placeholder"),
				expectedPlaceHolderLastName);

		String expectedPlaceHolderEmail = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("placeholder"),
				expectedPlaceHolderEmail);

		String expectedPlaceHolderTelephone = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("placeholder"),
				expectedPlaceHolderTelephone);

		String expectedPlaceHolderPassword = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getDomAttribute("placeholder"),
				expectedPlaceHolderPassword);

		String expectedPlaceHolderConfirmPassword = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getDomAttribute("placeholder"),
				expectedPlaceHolderConfirmPassword);

	}
}
