package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_RF_013 {

	@Test
	public void verifyPlaceHolderTextInputFieldsInRegisteringAccountPage() {

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
		String expectedPlaceHolderFirstName = "First Name";
		Assert.assertEquals(driver.findElement(By.id("input-firstname")).getAttribute("placeholder"),
				expectedPlaceHolderFirstName);

		String expectedPlaceHolderLastName = "Last Name";
		Assert.assertEquals(driver.findElement(By.id("input-lastname")).getAttribute("placeholder"),
				expectedPlaceHolderLastName);
		
		String expectedPlaceHolderEmail = "E-Mail";
		Assert.assertEquals(driver.findElement(By.id("input-email")).getAttribute("placeholder"),
				expectedPlaceHolderEmail);
		
		String expectedPlaceHolderTelephone = "Telephone";
		Assert.assertEquals(driver.findElement(By.id("input-telephone")).getAttribute("placeholder"),
				expectedPlaceHolderTelephone);
		
		String expectedPlaceHolderPassword = "Password";
		Assert.assertEquals(driver.findElement(By.id("input-password")).getAttribute("placeholder"),
				expectedPlaceHolderPassword);
		
		String expectedPlaceHolderConfirmPassword = "Password Confirm";
		Assert.assertEquals(driver.findElement(By.id("input-confirm")).getAttribute("placeholder"),
				expectedPlaceHolderConfirmPassword);
		
		driver.quit();
		
	}
}
