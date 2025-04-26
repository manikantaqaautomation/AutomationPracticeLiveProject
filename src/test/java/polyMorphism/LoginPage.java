package polyMorphism;

import org.openqa.selenium.WebDriver;


//Compile-Time Polymorphism (Method Overloading)
//Same method name but different parameters in the same class.

public class LoginPage {
	
	WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Login with username & password
    public void login(String username, String password) {
        System.out.println("Logging in with username and password");
    }

    // Login with token (overloaded method)
    public void login(String token) {
        System.out.println("Logging in with token");
    }
    
    //Usage
    
    LoginPage loginPage = new LoginPage(driver);
    //loginPage.login("admin", "admin123");  // Calls 2-arg method
    //loginPage.login("token123");           // Calls 1-arg method


}
