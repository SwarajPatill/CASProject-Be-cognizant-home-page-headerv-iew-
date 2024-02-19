package TestCases;

import java.io.IOException;


import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.UserValidation;
import TasteBase.BaseClass;
import utilities.utilities;

public class TC_001_UserVerification extends BaseClass {

	@Test(priority=1,groups= {"master","regression"})
	public void Verify_UserVerification() throws InterruptedException, IOException {

		UserValidation uv = new UserValidation(driver);
		uv.clickProfile();
		logger.info("*****************Start the TC_001_UserVerification****************");
		logger.info("click on userdetail button..........");
		takescreenshot("userdetails.png");
		logger.info("screenshot is taken...");
		
				
		uv.getProfile();
		
		String Actual = UserValidation.Name;
		
		
		try {
		String Expected = p.getProperty("Name");
		Assert.assertEquals(Actual, Expected);
		logger.info("get the user name ..........");
		}catch(Exception e){
			Assert.fail();
			logger.error("Credentials not matched...");
		}

		uv.closeProfile();
		logger.info("get the username and email...");
		
		utilities.WriteUserDetails( uv.Name,uv.email);
		logger.info("write the data in excel");

		logger.info("*****************End the TC_001_UserVerification****************");

	}
}
