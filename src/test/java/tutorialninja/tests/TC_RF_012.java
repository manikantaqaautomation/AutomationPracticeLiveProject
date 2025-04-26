package tutorialninja.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import utils.commonUtils;

public class TC_RF_012 extends Base {

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
	public void verifyRigesteringAccountByUsingKeyBoardCommands() {

		Actions action = new Actions(driver);

		for (int i = 1; i <= 23; i++) {
			action.sendKeys(Keys.TAB).perform();
		}

		action.sendKeys("Test1").pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys("Test1").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(commonUtils.generateEmail())
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys("1234556679").sendKeys(Keys.TAB)
				.pause(Duration.ofSeconds(1)).sendKeys("12345").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys("12345").sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.LEFT).pause(Duration.ofSeconds(1)).sendKeys(Keys.TAB).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.SPACE).pause(Duration.ofSeconds(1))
				.sendKeys(Keys.TAB).pause(Duration.ofSeconds(1)).sendKeys(Keys.ENTER).build().perform();

		// Account will be created
		// Check the verification Account is Logged in
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		// Account creation message
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);

	}

}
