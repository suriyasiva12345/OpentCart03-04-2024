package testCase;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass
{
	
	
	
    
    @Test (groups = {"regression","master"})
    public void verifyAccountRegistration() throws InterruptedException
    {
    	
    	logger.info("********* Starting TC_001_AccountRegistrationTest ***************");
    	
    	try {
    	HomePage homepgae = new HomePage(driver);
    	
    	homepgae.click_MyAccount();
    	
    	logger.info("Clicked On My Account  Link");
    	Thread.sleep(3000);
    	homepgae.click_Register();
    	
    	logger.info("Clicked On Registeration Link");
    	Thread.sleep(3000);
    	logger.info("********** Entering Customer Information*****");
    	
    	AccountRegistrationPage regPage = new AccountRegistrationPage(driver);
    	
    	regPage.setFirstName(randomString().toUpperCase());
    	Thread.sleep(3000);
    	regPage.setLastName(randomString().toUpperCase());
    	Thread.sleep(3000);
    	regPage.setEmail(randomString()+"@gmail.com");
    	Thread.sleep(3000);
    	regPage.setTelephone(randomNumbersinString());
    	Thread.sleep(3000);
    	String password = randomAlphaNumeric();
    	
    	regPage.setpassword(password);
    	Thread.sleep(3000);
    	regPage.reTypepassword(password);
    	Thread.sleep(3000);
    	
    	regPage.check_PrivacyPolicy();
    	Thread.sleep(3000);
    	regPage.click_Continue();
    	Thread.sleep(3000);
    	logger.info("Clicked on Continue");
    	
    	String exp_message = "Your Account Has Been Created!!";
    	
    	String act_message = regPage.confirmationMsg();
    	
    	if(act_message.equals(exp_message))
    	{
    		logger.info("Test Passed *********** ");	
    		Assert.assertTrue(true);
    	}
    	else
    	{
    		logger.error("Test Failed *************");
    		Assert.fail();
    	}
    	
    	
    	}
    	
    	catch(Exception e)
    	{
    		
    	 logger.error("Test Failed ");	
    	 
    	 Assert.fail();
    	}
    	Thread.sleep(3000);
    	logger.info("Validating Expected Message ");
    	
    	logger.info("********* Finished TC_001_AccountRegistrationTest ***************");
    	
    }
    
    
   
	
	
	
}
