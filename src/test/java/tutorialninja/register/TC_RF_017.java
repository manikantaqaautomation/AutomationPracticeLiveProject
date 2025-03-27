package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import utils.commonUtils;

public class TC_RF_017 {
	
	WebDriver driver;
	
	@AfterMethod
	public void teardown() {
		
		driver.quit();
	}
	
	@Test(dataProvider="passwordSupplier")
	public void verifyRegisteringAccountByCheckingPasswordComplexityStandards(String passwordText) {
		

		driver = new ChromeDriver();
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
		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		driver.findElement(By.id("input-confirm")).sendKeys(passwordText);
		//Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		//Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//Expected Result
		
		String warningMessage = "Password entered is not matched with the complexity standards";
		Assert.assertEquals(driver.findElement(By.xpath("//input[@id='input-password']/following-sibling::div")).getText(), warningMessage);
		Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='breadcrumb']//a[text()='Success']")).isDisplayed());
		
	
		
	}
	
	@DataProvider(name="passwordSupplier")
	public Object[][] supplyPasswords() {
		Object[][] data  = {{"12345"},{"abcdefghi"},{"abcd1234"},{"abcd123$"},{"ABCDE12@"}};
		return data;
		
		
	}

}
