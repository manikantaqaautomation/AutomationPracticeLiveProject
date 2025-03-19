package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC_RF_008 {
	
	@Test
	public void verifyRegisteringAccountByProvidingMismatchingPasswords() {
		
		WebDriver  driver = new ChromeDriver();
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
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("7979787979");
		driver.findElement(By.id("input-password")).sendKeys("12345");
		driver.findElement(By.id("input-confirm")).sendKeys("adcde");
		
		//Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		//Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//Expected Result
		
		String expectedPasswordConfirmWarning = "Password confirmation does not match password!";
		
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-confirm']/following-sibling::div")).getText(), expectedPasswordConfirmWarning);
		
		driver.quit();
	}
	
}
