package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telePhoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacyPolicyField;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@id='input-firstname']/following-sibling::div")
	private WebElement firstNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-lastname']/following-sibling::div")
	private WebElement lastNameWarningMessage;

	@FindBy(xpath = "//input[@id='input-email']/following-sibling::div")
	private WebElement emailWarningMessage;

	@FindBy(xpath = "//input[@id='input-telephone']/following-sibling::div")
	private WebElement telePhoneNumberWarningMessage;

	@FindBy(xpath = "//input[@id='input-password']/following-sibling::div")
	private WebElement passwordWarningMessage;

	@FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath="//input[@name='newsletter'][@value=1]")
	private WebElement yesOptionNewsLetterSubscription;
	

	public void enterFirstNameField(String firstNameText) {
		firstNameField.sendKeys(firstNameText);
	}

	public void enterLastNameField(String lastNameText) {
		lastNameField.sendKeys(lastNameText);
	}

	public void enterEmailField(String emailText) {
		emailField.sendKeys(emailText);
	}

	public void enterTelePhoneField(String telePhoneText) {
		telePhoneField.sendKeys(telePhoneText);
	}

	public void enterPasswordField(String passwordText) {
		passwordField.sendKeys(passwordText);
	}

	public void enterConfirmPasswordField(String confirmPasswordText) {
		confirmPasswordField.sendKeys(confirmPasswordText);
	}

	public void selectPrivcayPolicy() {
		privacyPolicyField.click();
	}

	public AccountSuccessPage clickOnContinueButton() {
		continueButton.click();
		return new AccountSuccessPage(driver);
	}

	public String firstNameWarningMessage() {
		return firstNameWarningMessage.getText();
	}

	public String lastNameWarningMessage() {
		return lastNameWarningMessage.getText();
	}

	public String emailWarningMessage() {
		return emailWarningMessage.getText();
	}

	public String telePhoneNumberWarningMessage() {
		return telePhoneNumberWarningMessage.getText();
	}

	public String passwordWarningMessage() {
		return passwordWarningMessage.getText();
	}
	
	public String privacyPolicyWarningMessage() {
		return privacyPolicyWarningMessage.getText();
	}
	
	public void selectYesOptionNewLetterSubscription() {
		yesOptionNewsLetterSubscription.click();
	}
	
}
