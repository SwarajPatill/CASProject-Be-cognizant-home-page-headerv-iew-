package PageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserValidation extends BasePage{
	
	public UserValidation(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
		
	}
	
	@FindBy(xpath="//*[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
	private WebElement button;
	
	@FindBy(id="mectrl_currentAccount_primary")
	private WebElement userName;
	
	@FindBy(id="mectrl_currentAccount_secondary")
	private WebElement Email;
	
	@FindBy(xpath="//*[@class='_8ZYZKvxC8bvw1xgQGSkvvA==']")
	private WebElement profileXpathClose;
	
	@FindBy(id="mectrl_headerPicture")
	private WebElement profileIdClose;
	
	public static String Name,email;

	
	
	public void clickProfile()
	{
		button.click();
	}
	
	public void getProfile()
	{
	    Name = userName.getText();
	    
	    email = Email.getText();
		System.out.println("--------------- Personal Info ---------------");
		System.out.println("Name     : "+Name+"\nMail Id  : "+ email);
		System.out.println("---------------------------------------------");
	}
	public void closeProfile()
	{
		try
		{
			profileXpathClose.click();
		}
		catch(Exception e)
		{
			profileIdClose.click();
		}

	
	}
}

//@FindBy(id = "meInitialsButton")
////@FindBy(xpath="//div[@class = '_8ZYZKvxC8bvw1xgQGSkvvA==']")
//private WebElement button;
//
//
//@FindBy(id = "mectrl_currentAccount_primary")
// private WebElement userName;
//
//@FindBy(id = "mectrl_currentAccount_secondary")
//private WebElement Email;

////Method to click on the User Details
//public void clickUserDetails() throws InterruptedException {
//	
//	JavascriptExecutor js=(JavascriptExecutor)driver;
//	js.executeScript("arguments[0].click()",button);
//	Thread.sleep(1000);
//	button.click();
//
//}
////Method to get get user name
//public String getUserName() {
//	String s1=userName.getText();
//	System.out.println("Account Name:- "+ "" +s1);
//	return s1;
//}
////Method to get user email
//public void getUserEmail() {
//	String s2= Email.getText();
//	System.out.println("Account Email:- " + ""+ s2);
//	//return s2;
//}