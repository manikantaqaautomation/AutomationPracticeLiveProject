package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

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

import utils.commonUtils;

public class TC_RF_005 {
	
	WebDriver driver;
	
	@BeforeMethod

	public void setup() {
		String browserName = "chrome";
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		} else if (browserName.equals("opera")) {
			driver = new SafariDriver();
		} else if (browserName.equals("ie")) {
			driver = new InternetExplorerDriver();
		}
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
	}
	
	@AfterTest
	public void tearDown() {
	    if (driver != null) {
	        driver.quit();
	    }
	}
	
    @Test
	public void verifyRegistringAccountBySubscribeNewsLetter() {
    	
		//Enter the mandatory fields
		driver.findElement(By.id("input-firstname")).sendKeys("Test1");
		driver.findElement(By.id("input-lastname")).sendKeys("Test2");
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("7979787979");
		driver.findElement(By.id("input-password")).sendKeys("Test@12345");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@12345");
		//Click on News Letter subscription
		driver.findElement(By.xpath("//input[@name='newsletter'][@value=1]")).click();
		//Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		//Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//Click on Continue button on Accounts page
		driver.findElement(By.linkText("Continue")).click();
		//Click on Subscribe/UnSubscribe News Letter link
		driver.findElement(By.linkText("Subscribe / unsubscribe to newsletter")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Newsletter']")).isDisplayed());
		
		Assert.assertTrue(driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).isSelected());
		

	}
    

}
