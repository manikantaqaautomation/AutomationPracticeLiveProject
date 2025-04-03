package tutorialninja.register;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import utils.commonUtils;



public class TC_RF_015 {
	
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

	/*
	 * @AfterMethod public void tearDown() { if (driver != null) { driver.quit(); }
	 * }
	 */

	private static final String url = "jdbc:mysql://localhost:3306/opencart_db"; // Change "mydatabase" to your DB name
	private static final String user = "root"; // Default MySQL username
	private static final String password = null; // Default is empty (change if you set a password)
	
	String firstNameStoredInDataBase = null;
	String lastNameStoredInDataBase = null;
	String emailStoredInDataBase = null;
	
	
	@Test
	public void verifyDataBaseTestingofRegisteringAccount() {

		String firstNameInputData = "Manikanta";

		driver.findElement(By.id("input-firstname")).sendKeys(firstNameInputData);

		String lastNameInputData = "Chodapaneedi";

		driver.findElement(By.id("input-lastname")).sendKeys(lastNameInputData);

		String emailInputData = commonUtils.generateEmail();

		driver.findElement(By.id("input-email")).sendKeys(emailInputData);
		
		driver.findElement(By.id("input-telephone")).sendKeys("7979787979");

		String passwordInputData = "123456";

		driver.findElement(By.id("input-password")).sendKeys(passwordInputData);
		
		driver.findElement(By.id("input-confirm")).sendKeys(passwordInputData);

		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();

		driver.findElement(By.name("agree")).click();

		driver.findElement(By.xpath("//input[@value='Continue']")).click();

		Connection connection = null;

		Statement statement = null;

		ResultSet resultSet = null;

		// Establish a connection
		try {
			// Load MySQL JDBC Driver
			//Class.forName("com.mysql.cj.jdbc.Driver");

			// Create a connection
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connected to MySQL database!");

			// Create a statement object
			Statement stmt = conn.createStatement();

			// Execute a sample query
			String query = "SELECT * FROM oc_customer"; // Change "users" to your table name
			ResultSet rs = stmt.executeQuery(query);
			

			// Process the result set
			while (rs.next()) {
				firstNameStoredInDataBase = rs.getNString("firstname");
				lastNameStoredInDataBase = rs.getNString("lastname");
				emailStoredInDataBase = rs.getNString("email");
				//System.out.println("ID: " + rs.getInt("id") + ", Name: " + rs.getString("name"));
			}

			// Close resources
			rs.close();
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("MySQL JDBC Driver not found!");
			e.printStackTrace();
		}
		
		Assert.assertEquals(firstNameStoredInDataBase, firstNameInputData);
		Assert.assertEquals(lastNameStoredInDataBase, lastNameInputData);
		Assert.assertEquals(emailStoredInDataBase, emailInputData.toLowerCase());
		
		

	}

}
