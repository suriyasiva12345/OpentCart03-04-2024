package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage
{
	
	WebDriver driver;

	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	
	
	// Elements 
	
	@FindBy(xpath = "//span[text()='My Account']") WebElement lnkMyAccount;

	@FindBy(xpath="//a[text()='Register']") WebElement lnkRegister;
	
	@FindBy(xpath="//ul//a[contains(text(),'Login')]") WebElement linkLogin;
	
	//Click My Account Method
	
	public void click_MyAccount()
	{
		lnkMyAccount.click();
	}
	
	
	//Click Register Method
	
	public void click_Register()
	{
		lnkRegister.click();
	}
	
	public void click_Login()
	{
		linkLogin.click();
	}
	
	
}
