package tutorialninja.register;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtils;

public class TC_RF_026 extends Base{

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
	public void verifyUIofRegisteringAccount() {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);

		try {
			FileHandler.copy(srcScreenshot,
					new File(System.getProperty("user.dir") + "\\Screenshots\\actualRegisterPageUI.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		Assert.assertTrue(commonUtils.compareTwoScreenshots(
				System.getProperty("user.dir") + "\\Screenshots\\actualRegisterPageUI.png",
				System.getProperty("user.dir") + "\\Screenshots\\expectedRegisteredPageUI.png"));

		// Assert.assertEquals(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUI.png",System.getProperty("user.dir")+"\\Screenshots\\expectedRegisteredPageUI.png");

		commonUtils.deleteTheImage("actualRegisteredPageUI.png");

	}

}
