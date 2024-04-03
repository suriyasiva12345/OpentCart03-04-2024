package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountRegistrationPage extends BasePage
{

	WebDriver driver;
	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	
	//Web Elements
	
     @FindBy(xpath="//input[@id='input-firstname']") WebElement txt_FirstName;
     
     @FindBy(xpath="//input[@id='input-lastname']") WebElement txt_LastName;
     
     @FindBy(xpath="//input[@id='input-email']") WebElement txt_Email;
     
     @FindBy(xpath="//input[@id='input-telephone']") WebElement txt_telephone;
     
     @FindBy(xpath="//input[@id='input-password']") WebElement txt_password;
     
     @FindBy(xpath="//input[@id='input-confirm']") WebElement txt_confirmPassword;
     
     @FindBy(xpath="//input[@name='agree']") WebElement chkBox_policy;
     
     @FindBy(xpath="//input[@value='Continue']") WebElement btn_Continue;
     
     @FindBy(xpath="//h1[text()='Your Account Has Been Created!']") WebElement confirm_message;
     
     
     
     
     //Set First name
     
     public void setFirstName(String firstname)
     {
    	 txt_FirstName.sendKeys(firstname);
     }
     
    //Set Last name
     
     public void setLastName(String lastname)
     {
    	 txt_LastName.sendKeys(lastname);
     }
     
     
  //Set email
     
     public void setEmail(String emali)
     {
    	 txt_Email.sendKeys(emali);
     }
     
   // Telephone 
     
     public void setTelephone(String phone)
     {
    	 txt_telephone.sendKeys(phone);
     }
     
     
 //Set password
     
     public void setpassword(String password)
     {
    	 txt_password.sendKeys(password);
     }
     
     
     //Confirm Password
     
     public void reTypepassword(String confirmpassword)
     {
    	 txt_confirmPassword.sendKeys(confirmpassword);
     }
     
     
     //Check Policy
     
     
     public void check_PrivacyPolicy()
     {
    	 WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	 
    	 wait.until(ExpectedConditions.elementToBeClickable(chkBox_policy)).click();
    	 
    	 
     }
     
       //Click Continue
     
     
     public void click_Continue()
     {
          WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
    	 
    	  wait.until(ExpectedConditions.elementToBeClickable(btn_Continue)).click();
     }
     
     

     
     //Confirm Account creation
     
     
     public String confirmationMsg()
     {
    	 return confirm_message.getText();
     }

}
