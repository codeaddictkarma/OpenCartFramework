package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//input[@id='input-email']") WebElement Loginemail;
	@FindBy(xpath = "//input[@id='input-password']") WebElement LoginPass; 
	@FindBy(xpath = "//input[@value='Login']") WebElement LoginloginBtn; 
	@FindBy(xpath = "//*[@id=\"column-right\"]/div/a[13]") WebElement LogoutBtn;
	@FindBy(xpath = "//h2[normalize-space()='My Account']")WebElement h2MyAcount; 
	
	
	public void enterLoginEmail(String emailId) {
		Loginemail.sendKeys(emailId);
	}
	
	public void enterLoginPassword(String pwd) {
		LoginPass.sendKeys(pwd);
	}
	
	public void clickOnLoginlogin() {
		LoginloginBtn.click();
	}
	
	public void clickOnLogout() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", LogoutBtn);
		LogoutBtn.click();
	}
	
	
	public String getH2Myaccount() {
		
		try {
			return h2MyAcount.getText(); 
		} catch (Exception e) {
			// TODO: handle exception
			return e.getMessage(); 
		}
	
		
	}
	
	

	
	
	

}
