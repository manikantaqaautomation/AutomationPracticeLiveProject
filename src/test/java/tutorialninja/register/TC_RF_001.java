package tutorialninja.register;

import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

//TC_RF_001
//TS_001 - Register Functionality 
//Verify Registering an Account by Providing only the Mandatory fields

public class TC_RF_001 {

	@Test
	public void verifyRegisterWithMandatoryFields() {
	
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
		driver.findElement(By.id("input-email")).sendKeys(generateEmail());
		driver.findElement(By.id("input-telephone")).sendKeys("7979787979");
		driver.findElement(By.id("input-password")).sendKeys("Test@12345");
		driver.findElement(By.id("input-confirm")).sendKeys("Test@12345");
		//Click Agree check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		//Click on Continue button
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		//Expected Result
		//Account will be created
		//Check the verification Account is Logged in
		Assert.assertTrue(driver.findElement(By.linkText("Logout")).isDisplayed());
		//Account creation message
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@id='common-success']//h1")).getText(), expectedHeading);
		//Check the proper details message
		String actualproperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String actualproperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String actualproperDetailsThree="If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String actualproperDetailsFour="contact us";
		
		String expectedProperDetails = driver.findElement(By.id("content")).getText();
		
		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsOne));
		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsTwo));
		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsThree));
		Assert.assertTrue(expectedProperDetails.contains(actualproperDetailsFour));
		
		//Navigate back to Account page click on Continue button
		
		driver.findElement(By.xpath("//a[text()='Continue']")).click();
		
		//Verify the Account page
		
		driver.findElement(By.linkText("Edit your account information")).isDisplayed();
		
		driver.quit();

	}
	
	public String generateEmail() {
		
		return new Date().toString().replaceAll("\\s","").replaceAll("\\:","")+"@gmail.com";
		
	}

}
