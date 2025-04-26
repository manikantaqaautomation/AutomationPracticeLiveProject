package Register;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;

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
import utils.commonUtils;

public class TC_RF_005 extends Base{
	
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
	public void verifyRegistringAccountBySubscribeNewsLetter() {
    	
		//Enter the mandatory fields
    	driver.findElement(By.id("input-firstname")).sendKeys(prop.getProperty("firstName"));
		driver.findElement(By.id("input-lastname")).sendKeys(prop.getProperty("lastName"));
		driver.findElement(By.id("input-email")).sendKeys(commonUtils.generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys(prop.getProperty("telephoneNumber"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
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
