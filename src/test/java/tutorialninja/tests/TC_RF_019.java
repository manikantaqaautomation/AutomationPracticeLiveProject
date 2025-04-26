package tutorialninja.tests;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import base.Base;
import utils.commonUtils;

public class TC_RF_019 extends Base{

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
	public void verifyLeadingTrailingSpacesRegisteringAccount() {
		SoftAssert softAssert = new SoftAssert();
		String enterFirstName = "   "+prop.getProperty("firstName")+"   ";
		driver.findElement(By.id("input-firstname")).sendKeys(enterFirstName);
		String enterLastName = "   "+prop.getProperty("lastName")+"   ";
		driver.findElement(By.id("input-lastname")).sendKeys(enterLastName);
		String enterEmail = "    " + commonUtils.generateEmail() + "   ";
		driver.findElement(By.id("input-email")).sendKeys(enterEmail);
		String enterTelephone = "   "+prop.getProperty("telephoneNumber")+"   ";
		driver.findElement(By.id("input-telephone")).sendKeys(enterTelephone);
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@name='agree'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		driver.findElement(By.xpath("//a[@class='btn btn-primary'][text()='Continue']")).click();
		driver.findElement(By.xpath("//a[text()='Edit your account information']")).click();
		driver.findElement(By.id("input-firstname")).getText();

		softAssert.assertEquals(driver.findElement(By.id("input-firstname")).getDomAttribute("value"),
				enterFirstName.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-lastname")).getDomAttribute("value"),
				enterLastName.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-email")).getDomAttribute("value"), enterEmail.trim());
		softAssert.assertEquals(driver.findElement(By.id("input-telephone")).getDomAttribute("value"),
				enterTelephone.trim());
		softAssert.assertAll();
	}

}
