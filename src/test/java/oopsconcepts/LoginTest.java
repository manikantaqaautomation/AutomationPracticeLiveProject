package oopsconcepts;

import org.testng.annotations.Test;

//Uses All OOPs Concepts
//Inheritance	LoginTest extends BaseTest

public class LoginTest extends BaseTest{
	
	@Test
    public void testValidLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("admin", "admin123");
        // Add assertions here
    }

    @Test
    public void testAdminLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginAsAdmin();
        // Add assertions here
    }

}
