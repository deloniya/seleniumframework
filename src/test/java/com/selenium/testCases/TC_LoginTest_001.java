package com.selenium.testCases;
import org.testng.annotations.Test;
import com.selenium.pageObjects.LoginPage;

import java.io.IOException;

import org.testng.Assert;

public class TC_LoginTest_001 extends BaseClass 
{
      
	  @Test
	  public void loginTest() throws IOException 
      {		  
		  LoginPage lp = new LoginPage(driver);
		  lp.setUsername(username);
		  logger.info("Username Entered");
		  lp.setPassword(password);
		  logger.info("password Entered");
		  lp.clickLogin();
		  
		  if(driver.getTitle().equals("ACME demo app"))
		  {
			  
			  Assert.assertTrue(true);
			  logger.info("TestCase Passed ");
			  captureScreen(driver,"Homepage");
		  }
		  else
		  {
			  logger.info("TestCase Failed");
			  captureScreen(driver, "Homepage");
			  Assert.assertTrue(false);
			  
		  }
	  }
	
	
}
