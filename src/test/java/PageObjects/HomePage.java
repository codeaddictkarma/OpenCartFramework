package PageObjects;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath = "//span[normalize-space()='My Account']") WebElement myAccount; 
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Register']") WebElement registerBtn; 
	@FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement loginBtn;
	
	public void clickOnMyAccount() {
		
		
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", myAccount);
		myAccount.click();
	}
	
	public void clickOnRegister() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", registerBtn);
		registerBtn.click(); 
	}
	
	public void clickOnLogin() {
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", loginBtn);
		loginBtn.click();
	}

}
