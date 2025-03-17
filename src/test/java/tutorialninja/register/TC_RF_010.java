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
		
		WebDriver driver  = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		//Open the URL
		driver.get("https://tutorialsninja.com/demo/");
		//Test Step-1
		//Click on 'My Account' drop down menu
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		//Select the option from 'My Account' drop down menu
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		//User able to see Register Account page
		//Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys("Test1");
		driver.findElement(By.id("input-lastname")).sendKeys("Test2");
		driver.findElement(By.id("input-email")).sendKeys("Test1");
		driver.findElement(By.id("input-telephone")).sendKeys("7979787979");
		driver.findElement(By.id("input-password")).sendKeys("Test@12345");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@12345");
		//Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		//Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		Thread.sleep(3000);
		//Get the screen shot 
		File screenShot1 = driver.findElement(By.xpath("//form[@class='form-horizontal']")).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(screenShot1,new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));
		BufferedImage actualBImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"));		
		BufferedImage expectedBImg = ImageIO.read(new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Expected.png"));
		
		ImageDiffer imgDiffr = new ImageDiffer();
		ImageDiff  imgDifference = imgDiffr.makeDiff(expectedBImg, actualBImg);
        Assert.assertFalse(imgDifference.hasDiff());
		
		  File imageFile = new
		  File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png"); 
		  if(imageFile.exists()) { 
			       if (imageFile.delete()) {
		           System.out.println("Image deleted successfully: " + new File(System.getProperty("user.dir")+"\\Screenshots\\sc1Actual.png")); } else
		           { 
		           System.out.println("Failed to delete the image."); 
		           } 
			       } else {
		           System.out.println("Image file not found."); 
		           }
		 
		
		driver.quit();
	}

}
