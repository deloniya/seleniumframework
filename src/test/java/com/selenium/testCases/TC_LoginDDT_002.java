package com.selenium.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.selenium.pageObjects.LoginPage;
import com.selenium.utilities.XLUtils;

public class TC_LoginDDT_002  extends BaseClass{

	
	@Test(dataProvider="LoginData")
	public void loginDDT (String user,String pwd) throws InterruptedException, IOException
	{


	    LoginPage lp =new LoginPage(driver);
		lp.setUsername(user);
		logger.info("user name provided");

		lp.setPassword(pwd);
		logger.info("Password provided");

		lp.clickLogin();
	
		if(driver.getTitle().equals("ACME demo app"))
		  {
			  
			  Assert.assertTrue(true);
			  logger.info("TestCase Passed for" + user);
			  captureScreen(driver,"Homepage");
		  }
		  else
		  {
			  logger.info("TestCase Failed for" + user);
              captureScreen(driver, "Homepage");
			  Assert.assertTrue(false);

		  }
		
	}
	
	
	@DataProvider(name="LoginData")
	String[][] getData() throws IOException
	{
		String path= System.getProperty("user.dir")  +"/src/test/java/com/selenium/testData/LoginData.xlsx";
		int rownum = XLUtils.getRowCount(path, "Sheet1");
		int colcount = XLUtils.getCellCount(path, "Sheet1", 1);
		
		String logindata[][] = new String [rownum][colcount];
		
		for(int i=1 ; i<=rownum ;i++)
		{
			for(int j=0;j<colcount;j++) {
				
				logindata[i-1][j] =XLUtils.getCellData(path, "Sheet1", i, j); // 0,0 | 1,0
			}
		}
		
		return logindata;
	}
	
}
