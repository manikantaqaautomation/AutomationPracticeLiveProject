package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC_RF_012 {

	@Test
	public void verifyRigesteringAccountByUsingKeyBoardCommands() {

		WebDriver driver = new ChromeDriver();
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

		driver.quit();
	}

}
