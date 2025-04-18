package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{

	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='input-firstname']") WebElement firstName; 
	@FindBy(xpath = "//input[@id='input-lastname']") WebElement lastName;
	@FindBy(xpath = "//input[@id='input-email']") WebElement email; 
	@FindBy(xpath = "//input[@id='input-telephone']") WebElement telephone; 
	@FindBy(xpath = "//input[@id='input-password']") WebElement password; 
	@FindBy(xpath = "//input[@id='input-confirm']") WebElement confirmPassword; 
	@FindBy(xpath = "//label[normalize-space()='Yes']") WebElement subscribeYes;
	@FindBy(xpath = "//input[@name='agree']") WebElement privacyPolicy;
	@FindBy(xpath = "//input[@value='Continue']") WebElement continueBtn;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement accountCreatedMsg;
	
	
	public void enterFirstName(String fName) {
		firstName.sendKeys(fName);
	}
	
	public void enterLastName(String lName) {
		lastName.sendKeys(lName);
	}
	
	public void enterEmail(String emailId) {
		email.sendKeys(emailId);
	}
	
	public void enterTelephone(String tphone) {
		telephone.sendKeys(tphone);
	}
	
	public void enterPassword(String pwd) {
		password.sendKeys(pwd);
	}
	
	public void enterConfirmPassword(String cpwd) {
		confirmPassword.sendKeys(cpwd);
	}
	
	public void clickOnSubscribeYes() {
		subscribeYes.click();
	}
	
	public void clickOnPrivacyPolicy() {
		privacyPolicy.click();
	}
	
	public void clickOnContinue() {
		continueBtn.click();
	}
	
	public String getAccountCreatedMsg() {
		try {
			return accountCreatedMsg.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}
	

}
