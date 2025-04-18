package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.BaseClass;

public class TC_LoginTest extends BaseClass{
	
	@Test(groups= {"Sanity","Master"})
	public void LoginTest() {
		
		try {
			
		    log.info("**********Login Test Started**********");

		    HomePage hp = new HomePage(driver);
		    hp.clickOnMyAccount();
		    hp.clickOnLogin();

		    log.info("**********Clicked on myaccount and Login **********");

		    LoginPage lp = new LoginPage(driver);
		    lp.enterLoginEmail(prop.getProperty("email"));
		    lp.enterLoginPassword(prop.getProperty("pass"));
		    lp.clickOnLoginlogin();

		    log.info("**********Provided all data in Login form and clicked the Login button**********");

		    
		    String h2myaccheading = lp.getH2Myaccount(); 
		    if(h2myaccheading.equals("My Account")){
		    	lp.clickOnLogout(); 
		    	log.info("**********Login Test passed***********");
		    	Assert.assertTrue(true); 
		    }
		    else {
		    	log.info("*********Login Test failed");
		    	Assert.assertTrue(false);
		    }
		    

		} catch (Exception e) {
		    log.error("**********Login Test Failed due to Exception: " + e.getMessage() + " **********");
		    Assert.fail("Login Test Failed due to exception: " + e.getMessage());
		}

		
		 
		 
		 
	}
	

}
