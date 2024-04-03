package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage
{

	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement msgHeading;
	
	@FindBy(xpath="//div[@class='list-group']//child::a[text()='Logout']") WebElement btn_logout;
	
	
	
	public boolean isMyAccountingPageExist()
	{
		try {
		return(msgHeading.isDisplayed());
		}
		catch(Exception e)
		{
			return(false);
		}
	}

	
	public void click_Logout()
	{
		btn_logout.click();
	}
}
