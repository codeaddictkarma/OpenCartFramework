package TestCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.AccountRegistrationPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC_AccountRegistrationTest extends BaseClass {
	
	
	
	
	
	@Test(groups= {"Regression","Master"})
	public void accountRegistrationTest() {
		
		try {
			
			log.info("**********Account Registration Test Started**********");
			
			HomePage hp = new HomePage(driver);
			hp.clickOnMyAccount();
			hp.clickOnRegister();
			log.info("**********Clicked on myaccount and Register **********");
			
			AccountRegistrationPage arp = new AccountRegistrationPage(driver);
			arp.enterFirstName(RandomString());
			arp.enterLastName(RandomString());
			arp.enterEmail(RandomString() + "@gmail.com");
			
			String passwordOrg = Password();
			
			arp.enterTelephone(telphone());
			arp.enterPassword(passwordOrg);
			arp.enterConfirmPassword(passwordOrg);
			arp.clickOnSubscribeYes();
			arp.clickOnPrivacyPolicy();
			arp.clickOnContinue();
			
			
			
			
			log.info("**********provided all data in registration form and clicked the continue button**********");
			String confirmationMsg = arp.getAccountCreatedMsg();
			
			if(confirmationMsg.equals("Your Account Has Been Created!")) {
				log.info("**********Account Registration Test Passed**********");
				Assert.assertTrue(true);
			}
			else {
				log.error("**********Account Registration Test Failed**********");
				log.debug("**********Debug logs****************");
				Assert.assertTrue(false);
			}
			
				
		} catch (Exception e) {
			// TODO: handle exception
			
			Assert.fail();
		}
		
		
		log.info("**********Account Registration Test Finished**********");
		
		
	}
	
	
	
	
	

}
