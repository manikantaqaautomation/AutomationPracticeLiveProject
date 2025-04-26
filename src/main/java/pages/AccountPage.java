package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	public AccountPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Edit your account information")
	private WebElement editYourAccountInformationOption;
	
	@FindBy(linkText="Subscribe / unsubscribe to newsletter")
	private WebElement subscribeUnsubscribeNewsLetterOption;
	
	public boolean didWeNavigateToAccountPage() {
		return editYourAccountInformationOption.isDisplayed();
	}
	
	public NewsLetterPage selectSubscribeUnSubscribeNewLetterOption() {
		subscribeUnsubscribeNewsLetterOption.click();
		return new NewsLetterPage(driver);
	}
	

}
