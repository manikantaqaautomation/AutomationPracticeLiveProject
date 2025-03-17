package tutorialninja.register;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

public class TC_RF_010 {

	@Test
	public void verifyRegisteringAccountByProvidingInvalidEmail() throws IOException, InterruptedException {

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
		// Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys("Test1");
		driver.findElement(By.id("input-lastname")).sendKeys("Test2");
		// Examine the test data 1
		driver.findElement(By.id("input-email")).sendKeys("Test1");
		driver.findElement(By.id("input-telephone")).sendKeys("7979787979");
		driver.findElement(By.id("input-password")).sendKeys("Test@12345");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@12345");
		// Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		// Get the screen shot
		/*
		 * File screenShot1 =
		 * driver.findElement(By.xpath("//form[@class='form-horizontal']")).
		 * getScreenshotAs(OutputType.FILE); FileHandler.copy(screenShot1,new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		 * BufferedImage actualBImg = ImageIO.read(new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		 * BufferedImage expectedBImg = ImageIO.read(new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));
		 * 
		 * ImageDiffer imgDiffr = new ImageDiffer(); ImageDiff imgDifference =
		 * imgDiffr.makeDiff(expectedBImg, actualBImg);
		 * Assert.assertFalse(imgDifference.hasDiff());
		 * 
		 * File imageFile = new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png");
		 * if(imageFile.exists()) { if (imageFile.delete()) {
		 * System.out.println("Image deleted successfully: " + new
		 * File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png")); } else
		 * { System.out.println("Failed to delete the image."); } } else {
		 * System.out.println("Image file not found."); }
		 */
		 
		// Examine the test data 2
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Test1@");
		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		// Get the screen shot
		File screenShot2 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot2, new File(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png"));

		BufferedImage actualBImgTwo = ImageIO
				.read(new File(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png"));
		BufferedImage expectedBImgTwo = ImageIO
				.read(new File(System.getProperty("user.dir") + "\\Screenshots\\sc2Expected.png"));

		ImageDiffer imgDiffrTwo = new ImageDiffer();
		ImageDiff imgDifferenceTwo = imgDiffrTwo.makeDiff(expectedBImgTwo, actualBImgTwo);
		Assert.assertFalse(imgDifferenceTwo.hasDiff());

		File imageFileTwo = new File(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png");
		if (imageFileTwo.exists()) {
			if (imageFileTwo.delete()) {
				System.out.println("Second Image deleted successfully: " + "sc2Actual.png");
			} else {
				System.out.println("Failed to delete the Second image.");
			}
		} else {
			System.out.println("Second Image file not found.");
		}

		// Examine the test data 3
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Test1@gmail");

		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		// Verify the error message
		String expectedEmailMessage = "E-Mail Address does not appear to be valid!";
		String actualEmailMessage = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div"))
				.getText();
		Assert.assertEquals(expectedEmailMessage, actualEmailMessage);

		// Examine the test data 4
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Test1@gmail.");

		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);

		// Get the screen shot
		File screenShot3 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot3, new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png"));

		BufferedImage actualBImgThree = ImageIO
				.read(new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png"));
		BufferedImage expectedBImgThree = ImageIO
				.read(new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Expected.png"));
		ImageDiffer imgDiffrThree = new ImageDiffer();
		ImageDiff imgDifferenceThree = imgDiffrThree.makeDiff(expectedBImgThree, actualBImgThree);
		Assert.assertFalse(imgDifferenceThree.hasDiff());
		File imageFileThree = new File(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png");
		if (imageFileThree.exists()) {
			if (imageFileThree.delete()) {
				System.out.println("Thrid Image deleted successfully: " + "sc3Actual.png");
			} else {
				System.out.println("Failed to delete the Thrid image.");
			}
		} else {
			System.out.println("Thrid Image file not found.");
		}
		driver.quit();
	}

}
