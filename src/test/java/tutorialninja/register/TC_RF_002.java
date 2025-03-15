package tutorialninja.register;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC_RF_002 {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
		driver.findElement(By.xpath("//span[text()='Hello, sign in']")).click();
		//driver.findElement(By.xpath("//div[@id='nav-signin-tooltip']//span[text()='Sign in']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Need help?')]")).click();
		driver.findElement(By.id("auth-fpp-link-bottom")).click();
		driver.findElement(By.id("ap_email")).sendKeys("prasad.chodapaneedi@gmail.com");
		driver.findElement(By.id("continue")).click();
		
		

	}

}
