package tutorialninja.tests;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Base;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.LandingPage;
import pages.NewsLetterPage;
import pages.RegisterPage;
import utils.commonUtils;

//TC_RF_001
//TS_001 - Register Functionality 
//Verify Registering an Account by Providing only the Mandatory fields

public class Register extends Base {

	WebDriver driver;
	Properties prop;
	LandingPage landingPage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	AccountPage accountPage;
	NewsLetterPage newsLetterPage;

	@AfterMethod
	public void teardown() {
		if (driver != null) {
			driver.quit();
		}
	}

	@BeforeMethod

	public void setup() {

		driver = openBrowserAndApplication();
		prop = commonUtils.loadProperties();
		landingPage = new LandingPage(driver);
		// Click on 'My Account' drop down menu
		landingPage.clickOnMyAccount();
		// Select the option from 'My Account' drop down menu
		registerPage = landingPage.selectRegisterOption();
		// User able to see Register Account page
	}

	@Test(priority = 1)
	public void verifyRegisterWithMandatoryFields() {
		// Enter the mandatory fields
		registerPage.enterFirstNameField(prop.getProperty("firstName"));
		registerPage.enterLastNameField(prop.getProperty("lastName"));
		registerPage.enterEmailField(commonUtils.generateEmail());
		registerPage.enterTelePhoneField(prop.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("validPassword"));
		registerPage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		// Click Agree check box
		registerPage.selectPrivcayPolicy();
		// Click on Continue button
		accountSuccessPage = registerPage.clickOnContinueButton();
		// Expected Result
		// Account will be created
		// Check the verification Account is Logged in
		Assert.assertTrue(accountSuccessPage.isLogoutOptionDisplayed());
		// Account creation message
		String expectedHeading = "Your Account Has Been Created!";
		Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);
		// Check the proper details message
		String expectedproperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String expectedproperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedproperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedproperDetailsFour = "contact us";

		String actualProperDetails = accountSuccessPage.getPageContent();

		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsFour));

		// Navigate back to Account page click on Continue button

		accountPage = accountSuccessPage.clickOnContinueButton();

		// Verify the Account page

		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());

	}

	@Test(priority = 2)
	public void verifyRegisterWithAllFields() {
		// Enter the mandatory fields
		registerPage.enterFirstNameField(prop.getProperty("firstName"));
		registerPage.enterLastNameField(prop.getProperty("lastName"));
		registerPage.enterEmailField(commonUtils.generateEmail());
		registerPage.enterTelePhoneField(prop.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("validPassword"));
		registerPage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		// Click Agree check box
		registerPage.selectPrivcayPolicy();
		// Click on Continue button
		accountSuccessPage = registerPage.clickOnContinueButton();

		// Expected Result
		// Account will be created
		// Check the verification Account is Logged in
		Assert.assertTrue(accountSuccessPage.isLogoutOptionDisplayed());
		// Account creation message
		// String expectedHeading = "Your Account Has Been Created!";
		// Assert.assertEquals(accountSuccessPage.getPageHeading(), expectedHeading);
		Assert.assertTrue(accountSuccessPage.didWeNavigateAccountSuccessPage());

		// Check the proper details message
		String expectedproperDetailsOne = "Congratulations! Your new account has been successfully created!";
		String expectedproperDetailsTwo = "You can now take advantage of member privileges to enhance your online shopping experience with us.";
		String expectedproperDetailsThree = "If you have ANY questions about the operation of this online shop, please e-mail the store owner.";
		String expectedproperDetailsFour = "contact us";

		String actualProperDetails = accountSuccessPage.getPageContent();

		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsOne));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsTwo));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsThree));
		Assert.assertTrue(actualProperDetails.contains(expectedproperDetailsFour));

		// Navigate back to Account page click on Continue button

		accountPage = accountSuccessPage.clickOnContinueButton();

		// Verify the Account page

		Assert.assertTrue(accountPage.didWeNavigateToAccountPage());

	}

	@Test(priority = 3)
	public void verifyRegisteringAccountWithoutFillingFields() {
		// Click on Continue button
		accountSuccessPage = registerPage.clickOnContinueButton();

		// Expected warning message with out filling the fields and click on Continue
		// button

		String expectedFirstNameWarning = "First Name must be between 1 and 32 characters!";
		String expectedLastNameWarning = "Last Name must be between 1 and 32 characters!";
		String expectedEmailWarning = "E-Mail Address does not appear to be valid!";
		String expectedTelephoneWarning = "Telephone must be between 3 and 32 characters!";
		String expectedPasswordWarning = "Password must be between 4 and 20 characters!";
		String expectedPrivacyPolicyWarning = "Warning: You must agree to the Privacy Policy!";

		Assert.assertEquals(registerPage.firstNameWarningMessage(), expectedFirstNameWarning);
		Assert.assertEquals(registerPage.lastNameWarningMessage(), expectedLastNameWarning);
		Assert.assertEquals(registerPage.emailWarningMessage(), expectedEmailWarning);
		Assert.assertEquals(registerPage.telePhoneNumberWarningMessage(), expectedTelephoneWarning);
		// Assert.assertEquals(registerPage.passwordWarningMessage(),expectedPasswordWarning);
		Assert.assertEquals(registerPage.privacyPolicyWarningMessage(), expectedPrivacyPolicyWarning);

	}

	@Test(priority = 4)
	public void verifyRegistringAccountBySubscribeNewsLetter() {

		// Enter the mandatory fields
		registerPage.enterFirstNameField(prop.getProperty("firstName"));
		registerPage.enterLastNameField(prop.getProperty("lastName"));
		registerPage.enterEmailField(commonUtils.generateEmail());
		registerPage.enterTelePhoneField(prop.getProperty("telephoneNumber"));
		registerPage.enterPasswordField(prop.getProperty("validPassword"));
		registerPage.enterConfirmPasswordField(prop.getProperty("validPassword"));
		// Click on News Letter subscription
		registerPage.selectYesOptionNewLetterSubscription();
		// Click Agree check box
		registerPage.selectPrivcayPolicy();
		// Click on Continue button
		accountSuccessPage = registerPage.clickOnContinueButton();
		// Click on Continue button on Accounts page
		accountPage = accountSuccessPage.clickOnContinueButton();
		// Click on Subscribe/UnSubscribe News Letter link
		newsLetterPage = accountPage.selectSubscribeUnSubscribeNewLetterOption();

		Assert.assertTrue(newsLetterPage.didWeNavigateToNewsLetterPage());

		Assert.assertTrue(newsLetterPage.isYesNewsLetterOptionSelected());
	}
}
