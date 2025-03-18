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
		Thread.sleep(2000);
		// Get the screen shot

		File screenShot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']"))
				.getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot1, new File(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png"));

		Thread.sleep(2000);

		Assert.assertFalse(compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc1Actual.png",
				System.getProperty("user.dir") + "\\Screenshots\\sc1Expected.png"));

		Thread.sleep(2000);

		deleteTheImage("sc1Actual.png");

		Thread.sleep(2000);

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

		Thread.sleep(2000);

		Assert.assertFalse(compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc2Actual.png",
				System.getProperty("user.dir") + "\\Screenshots\\sc2Expected.png"));

		Thread.sleep(2000);

		deleteTheImage("sc2Actual.png");

		Thread.sleep(2000);

		// Examine the test data 3
		driver.findElement(By.id("input-email")).clear();
		driver.findElement(By.id("input-email")).sendKeys("Test1@gmail");

		// Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(2000);
		// Verify the error message
		String expectedEmailMessage = "E-Mail Address does not appear to be valid!";
		String actualEmailMessage = driver.findElement(By.xpath("//input[@id='input-email']/following-sibling::div"))
				.getText();
		Assert.assertEquals(expectedEmailMessage, actualEmailMessage);

		Thread.sleep(2000);

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

		Thread.sleep(2000);

		Assert.assertFalse(compareTwoScreenShots(System.getProperty("user.dir") + "\\Screenshots\\sc3Actual.png",
				System.getProperty("user.dir") + "\\Screenshots\\sc3Expected.png"));

		Thread.sleep(2000);

		deleteTheImage("sc3Actual.png");

		Thread.sleep(2000);

		driver.quit();
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
