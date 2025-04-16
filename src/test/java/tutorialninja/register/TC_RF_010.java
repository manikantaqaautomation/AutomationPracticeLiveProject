package tutorialninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import javax.imageio.ImageIO;

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
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;
import utils.commonUtils;

public class TC_RF_010 extends Base{

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

	@AfterTest
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@Test
	public void verifyRegisteringAccountByProvidingInvalidEmail() throws IOException, InterruptedException {

		String browserName = "chrome";

		// Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		// Examine the test data 1
		driver.findElement(By.id("input-email")).sendKeys("Test1");
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		// Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(2000);
		// Get the screen shot
		System.out.println(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"));
		if (browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please include an '@' in the email address. 'Test1' is missing an '@'.");
		} else if (browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter an email address.");
		}
		/*
		 * File screenShot1 =
		 * driver.findElement(By.xpath("//form[@class='form-horizontal']"))
		 * .getScreenshotAs(OutputType.FILE); FileHandler.copy(screenShot1, new
		 * File(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * Assert.assertFalse(compareTwoScreenShots(System.getProperty("user.dir") +
		 * "\\Screenshots\\sc1Actual.png", System.getProperty("user.dir") +
		 * "\\Screenshots\\sc1Expected.png"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * deleteTheImage("sc1Actual.png");
		 * 
		 * Thread.sleep(2000);
		 */

		// Examine the test data 2
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Test1@");
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		System.out.println(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"));
		if (browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter a part following '@'. 'Test1@' is incomplete.");
		} else if (browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter an email address.");
		}
		/*
		 * // Get the screen shot File screenShot2 =
		 * driver.findElement(By.xpath("//form[@class='form-horizontal']"))
		 * .getScreenshotAs(OutputType.FILE); FileHandler.copy(screenShot2, new
		 * File(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * Assert.assertFalse(compareTwoScreenShots(System.getProperty("user.dir") +
		 * "\\Screenshots\\sc2Actual.png", System.getProperty("user.dir") +
		 * "\\Screenshots\\sc2Expected.png"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * deleteTheImage("sc2Actual.png");
		 * 
		 * Thread.sleep(2000);
		 */

		// Examine the test data 3
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Test1@gmail");

		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(2000);
		
		/*
		 * System.out.println(driver.findElement(By.id("input-email")).getDomProperty(
		 * "validationMessage")); if (browserName.equals("chrome")) {
		 * Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty(
		 * "validationMessage"),
		 * "Please include an '@' in the email address. 'Test1' is missing an '@'."); }
		 * else if (browserName.equals("firefox")) {
		 * Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty(
		 * "validationMessage"), "Please enter an email address."); }
		 */
		
		  // Verify the error message 
		  String expectedEmailMessage = "E-Mail Address does not appear to be valid!"; String actualEmailMessage =
		  driver.findElement(By.xpath(
		  "//input[@id='input-email']/following-sibling::div")) .getText();
		  Assert.assertEquals(expectedEmailMessage, actualEmailMessage);
		  
		  Thread.sleep(2000);
		 

		// Examine the test data 4
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Test1@gmail.");

		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		
		System.out.println(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"));
		if (browserName.equals("chrome")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"'.' is used at a wrong position in 'gmail.'.");
		} else if (browserName.equals("firefox")) {
			Assert.assertEquals(driver.findElement(By.id("input-email")).getDomProperty("validationMessage"),
					"Please enter an email address.");
		}

		/*
		 * // Get the screen shot File screenShot3 =
		 * driver.findElement(By.xpath("//form[@class='form-horizontal']"))
		 * .getScreenshotAs(OutputType.FILE); FileHandler.copy(screenShot3, new
		 * File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * Assert.assertFalse(compareTwoScreenShots(System.getProperty("user.dir") +
		 * "\\Screenshots\\sc3Actual.png", System.getProperty("user.dir") +
		 * "\\Screenshots\\sc3Expected.png"));
		 * 
		 * Thread.sleep(2000);
		 * 
		 * deleteTheImage("sc3Actual.png");
		 * 
		 * Thread.sleep(2000);
		 */

	}

	public boolean compareTwoScreenShots(String actualImagePath, String expectedImagePath) throws IOException {

		BufferedImage actualBImage = ImageIO.read(new File(actualImagePath));
		BufferedImage ecpectedBImage = ImageIO.read(new File(expectedImagePath));

		ImageDiffer imgDiffr = new ImageDiffer();
		ImageDiff imgDifference = imgDiffr.makeDiff(actualBImage, ecpectedBImage);
		return imgDifference.hasDiff();

	}

	public void deleteTheImage(String imageName) {

		File imageFilePath = new File(System.getProperty("user.dir") + "\\Screenshots\\" + imageName);
		if (imageFilePath.exists()) {
			if (imageFilePath.delete()) {
				System.out.println("Image deleted successfully: " + imageName);
			} else {
				System.out.println("Failed to delete the image.");
			}
		} else {
			System.out.println("Image file not found.");
		}

	}

}
