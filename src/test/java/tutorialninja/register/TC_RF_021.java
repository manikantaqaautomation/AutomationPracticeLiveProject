package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC_RF_021 {
	
	WebDriver driver;
	
	@Test
	public void verifyRegisteringAccountWithOutSelectingPrivacyPolicy() {
		
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://tutorialsninja.com/demo/");
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		driver.findElement(By.linkText("Register")).click();
		String enterFirstName ="Manikanta";
		driver.findElement(By.id("input-firstname")).sendKeys(enterFirstName);
		String enterLastName ="Chodapaneedi";
		driver.findElement(By.id("input-lastname")).sendKeys(enterLastName);
		String enterEmail = commonUtils.generateEmail();
		driver.findElement(By.id("input-email")).sendKeys(enterEmail);
		String enterTelephone = "123456789";
		driver.findElement(By.id("input-telephone")).sendKeys(enterTelephone);
		driver.findElement(By.id("input-password")).sendKeys("12345678");
		driver.findElement(By.id("input-confirm")).sendKeys("12345678");
		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		String expectedWarningMessage = "Warning: You must agree to the Privacy Policy!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText(), expectedWarningMessage);
		driver.quit();
	}

}
