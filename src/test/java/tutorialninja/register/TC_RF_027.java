package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC_RF_027 {
	
	WebDriver driver = null;
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	
	@Test(dataProvider="differentBroswersPassing")
	public void verifyRegisteringAccountInDifferentTestEnvironments(String env) {
		
		String browser =env;
		
		if(browser.equals("chrome")) {
			
			driver = new ChromeDriver();
			
		} else if(browser.equals("firefox")) {
			
		    driver = new FirefoxDriver();
		    
		} else if(browser.equals("edge")) {
			
			driver = new EdgeDriver();
		}
		
		//driver = new ChromeDriver();
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
		driver.findElement(By.id("input-password")).sendKeys("Test@12345");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@12345");
		//Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		//Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='list-group']//a[text()='Logout']]")).isDisplayed());
		
		driver.findElement(By.xpath("//div[@id='content']//a[text()='Continue']")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='content']//h2[text()='My Account']")).isDisplayed());
		
		
	}
	
	@DataProvider(name="differentBroswersPassing")
	public Object[][] passingBrowsers() {
		
		Object[][] browser = {{"chrome"},{"firefox"},{"edge"}};
		
		return browser;
		
	}

}
