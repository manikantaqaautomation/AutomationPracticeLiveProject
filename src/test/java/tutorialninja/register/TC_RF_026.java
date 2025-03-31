package tutorialninja.register;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC_RF_026 {

	@Test
	public void verifyUIofRegisteringAccount() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://tutorialsninja.com/demo/");
		
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		
		TakesScreenshot ts = (TakesScreenshot)driver;
		File srcScreenshot = ts.getScreenshotAs(OutputType.FILE);
		
		try {
			FileHandler.copy(srcScreenshot,new File(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUI.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Assert.assertTrue(commonUtils.compareTwoScreenshots(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUI.png", System.getProperty("user.dir")+"\\Screenshots\\expectedRegisteredPageUI.png"));
		
		//Assert.assertEquals(System.getProperty("user.dir")+"\\Screenshots\\actualRegisterPageUI.png",System.getProperty("user.dir")+"\\Screenshots\\expectedRegisteredPageUI.png");
		
		driver.quit();
	    
	    commonUtils.deleteTheImage("actualRegisteredPageUI.png");

	}

}
