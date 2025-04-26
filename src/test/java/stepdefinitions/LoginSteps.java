package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginCucumberPage;

public class LoginSteps {
	
	WebDriver driver;
	loginCucumberPage LoginCucumberPage;

    @Given("I launch the application")
    public void i_launch_the_application() {
        driver = new ChromeDriver();
        driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");
        LoginCucumberPage = new loginCucumberPage(driver);
    }

    @When("I enter username {string} and password {string}")
    public void i_enter_credentials(String username, String password) {
    	LoginCucumberPage.enterUsername(username);
    	LoginCucumberPage.enterPassword(password);
    }

    @When("I click the login button")
    public void i_click_login() {
    	LoginCucumberPage.clickLogin();
    }

    @Then("I should see the success message")
    public void i_should_see_success() {
    	LoginCucumberPage.verifyLoginSuccess();
        driver.quit();
    }

}
