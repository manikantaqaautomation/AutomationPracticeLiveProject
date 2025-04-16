package tutorialninja.register;

import java.time.Duration;
import java.util.Properties;

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
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtils;

public class TC_RF_017 extends Base{

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

	@Test(dataProvider = "passwordSupplier")
	public void verifyRegisteringAccountByCheckingPasswordComplexityStandards(String passwordText) {

		// Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
		// Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		// Expected Result

		String warningMessage = "Password entered is not matched with the complexity standards";
		boolean state = false;

		try {
			String actualWarningMessage = driver
					.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText();
			if (actualWarningMessage.equals(warningMessage)) {
				state = true;
			}

		} catch (NoSuchElementException e) {
			state = false;
		}
		Assert.assertTrue(state);
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());

	}

	@DataProvider(name = "passwordSupplier")
	public Object[][] supplyPasswords() {
		Object[][] data = { { "12345" }, { "abcdefghi" }, { "abcd1234" }, { "abcd123$" }, { "ABCDE12@" } };
		return data;

	}

}
