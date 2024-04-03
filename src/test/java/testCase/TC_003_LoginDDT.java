package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilites.DataProvidersClass;

public class TC_003_LoginDDT extends BaseClass
{
    @Test( dataProvider= "loginData", dataProviderClass = DataProvidersClass.class)
	public void verifyLoginDDT(String email,String password,String expResult) throws InterruptedException
	{
        logger.info("**** Starting TC_003_LoginDDT **************");
		
		logger.debug("######### Capturing Application Debug Logs#########");
		
		
		try {	
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
		loginPageObj.setEmail(email);
		Thread.sleep(3000);
		logger.info("Entering Password ..........");		
		loginPageObj.setPassword(password);	
		Thread.sleep(3000);
		logger.info("Click Login Button ..........");		
		loginPageObj.clickLogin();//login Button
		Thread.sleep(3000);
		
		
		//My Account Page 
		MyAccountPage accountPageObj = new MyAccountPage(driver);		
	    boolean msgStatus =  	accountPageObj.isMyAccountingPageExist();	
	    
	    if(expResult.equalsIgnoreCase("valid"))
	    {
	    	
	    	System.out.println(email);
	    	if(msgStatus==true)
	    	{
	    		accountPageObj.click_Logout();
	    		Assert.assertTrue(true);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(false);
	    	}
	    }
	    
	    if(expResult.equalsIgnoreCase("invalid"))
	    {
	    	System.out.println(email);

	    	if(msgStatus==true)
	    	{
	    		accountPageObj.click_Logout();
	    		Assert.assertTrue(false);
	    	}
	    	else
	    	{
	    		Assert.assertTrue(true);
	    	}
	    }
	    
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		 logger.info("**** Finished TC_003_LoginDDT **************");
	}

}
