package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;

public class TC_RF_014 extends Base{
	
	WebDriver driver;

	@BeforeMethod

	public void setup() {
		driver = openBrowserAndApplication();
		// Test Step-1
		// Click on 'My Account' drop down menu
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		// Select the option from 'My Account' drop down menu
		driver.findElement(By.xpath("//a[text()='Register']")).click();
		// User able to see Register Account page
	}

	@AfterMethod
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
	@Test
	public void verifyMandatoryFieldSymbolColorRegisterAccountPage() {
		
		
		String expectedContent = "\"* \"";
		String expectedColor = "rgb(255, 0, 0)";
		
		WebElement firstNameLabel = driver.findElement(By.cssSelector("label[for='input-firstname']"));
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String fnContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", firstNameLabel);
		String fnColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", firstNameLabel);
		Assert.assertEquals(fnContent, expectedContent);
		Assert.assertEquals(fnColor, expectedColor);
		
		WebElement lastNameLabel = driver.findElement(By.cssSelector("label[for='input-lastname']"));
		String lnContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", lastNameLabel);
		String lnColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", lastNameLabel);
		Assert.assertEquals(lnContent, expectedContent);
		Assert.assertEquals(lnColor, expectedColor);
		
		WebElement emailLabel = driver.findElement(By.cssSelector("label[for='input-email']"));
		String emailContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", emailLabel);
		String emailColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", emailLabel);
		Assert.assertEquals(emailContent, expectedContent);
		Assert.assertEquals(emailColor, expectedColor);
		
		WebElement telephoneLabel = driver.findElement(By.cssSelector("label[for='input-telephone']"));
		String telephoneContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", telephoneLabel);
		String telephoneColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", telephoneLabel);
		Assert.assertEquals(telephoneContent, expectedContent);
		Assert.assertEquals(telephoneColor, expectedColor);
		
		WebElement passwordLabel = driver.findElement(By.cssSelector("label[for='input-password']"));
		String passwordContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passwordLabel);
		String passwordColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passwordLabel);
		Assert.assertEquals(passwordContent, expectedContent);
		Assert.assertEquals(passwordColor, expectedColor);
		
		WebElement passwordConfirmLabel = driver.findElement(By.cssSelector("label[for='input-confirm']"));
		String passwordConfirmContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", passwordConfirmLabel);
		String passwordConfirmColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", passwordConfirmLabel);
		Assert.assertEquals(passwordContent, passwordConfirmContent);
		Assert.assertEquals(passwordColor, passwordConfirmColor);
		
		WebElement privacyPolicyLabel = driver.findElement(By.cssSelector("[class='pull-right']"));
		String privacyPolicyContent = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('content');", privacyPolicyLabel);
		String privacyPolicyColor = (String)jse.executeScript("return window.getComputedStyle(arguments[0], '::before').getPropertyValue('color');", privacyPolicyLabel);
		Assert.assertEquals(privacyPolicyContent, passwordConfirmContent);
		Assert.assertEquals(privacyPolicyColor, passwordConfirmColor);
		
		
	}

}
