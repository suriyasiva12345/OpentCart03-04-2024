package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass
{

	@Test(groups = {"sanity","master"})
	public void verifyLogin() throws InterruptedException
	{
		logger.info("**** Starting TC_002_LoginTest **************");
		
		logger.debug("######### Capturing Application Debug Logs#########");
		
		try 
		{
			
	    //Home Page
		HomePage HomePageobj = new HomePage(driver);
		
		logger.info("Clicked on My Account Link..........");
		HomePageobj.click_MyAccount();
		Thread.sleep(3000);
		logger.info("Clicked on Login Link My Account...........");
		HomePageobj.click_Login();// from Homepage 
		Thread.sleep(3000);
		
		//Login Page
		LoginPage loginPageObj = new LoginPage(driver);
		logger.info("Entering Email Address ..........");		
		loginPageObj.setEmail(propFile.getProperty("email"));
		Thread.sleep(3000);
		logger.info("Entering Password ..........");		
		loginPageObj.setPassword(propFile.getProperty("password"));	
		Thread.sleep(3000);
		logger.info("Click Login Button ..........");		
		loginPageObj.clickLogin();//login Button
		Thread.sleep(3000);
		
		
		//My Account Page 
		MyAccountPage accountPageObj = new MyAccountPage(driver);		
	    boolean msgStatus =  	accountPageObj.isMyAccountingPageExist();	    
	    if(msgStatus == true)
	    {
	    	logger.info("Test Passed ..........");
	    	Assert.assertTrue(true);
	    }
	    else
	    {
	    	logger.error("Test Failes...........");
	    	Assert.fail();
	    }
	    
	    logger.info("**** Finished TC_002_LoginTest **************");
	    
		}
		
		catch(Exception e)
		{
			logger.error("Test Failes...........");
			Assert.fail();
		}
		Thread.sleep(3000);
	}
	
	
}
