package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.BaseClass;
import Utilities.ExcelTestData;

public class TC_DataDrivenLoginTest extends BaseClass {
	
	  @Test(dataProvider = "LoginData", dataProviderClass = ExcelTestData.class,groups= {"DataDriven"})
	  public void DataDrivenLoginTest(String email,String pass,String status) throws InterruptedException {
		  
		  HomePage hp = new HomePage(driver); 
		  hp.clickOnMyAccount(); 
		  hp.clickOnLogin(); 
		  
		  Thread.sleep(3000);
		  
		  LoginPage lp = new LoginPage(driver); 
		  
		  lp.enterLoginEmail(email);
		  lp.enterLoginPassword(pass);
		  lp.clickOnLoginlogin(); 
		  
		  log.info("*************provided email and password and clicked the login button***********");
		  
		  
		  String h2loginValidation = lp.getH2Myaccount(); 
		  
		  if(status.equalsIgnoreCase("Valid")) {
			  if(h2loginValidation.equals("My Account")) {
				  lp.clickOnLogout();
				  log.info("**********valid credientials,able to login*********");
				  log.info("**********test passed**********");
				  Assert.assertTrue(true);
			  }
			  else {
				  log.info("**********valid credientials,unable to login*********");
				  log.info("**********test failed**********");
				  Assert.assertTrue(false);
			  }
		  }
		  
		  
		  if(status.equalsIgnoreCase("Invalid")) {
			  if(h2loginValidation.equals("My Account")) {
				  lp.clickOnLogout();
				  log.info("**********invalid credientials,able to login*********");
				  log.info("**********test failed*************");
				  Assert.assertTrue(false);
			  }
			  else {
				  log.info("**********invalid credientials,unable to login*********");
				  log.info("***********test passed***********");
				  Assert.assertTrue(true);
			  }
		  }
		  
		  
		  
		  
		  }
	  

}
