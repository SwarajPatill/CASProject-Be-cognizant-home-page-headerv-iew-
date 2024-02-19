package TestCases;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.BeCognizantPage;
import PageObjects.EthicsandCompliance;
import TasteBase.BaseClass;
import utilities.utilities;

public class TC_003_EthicsandCompliance extends BaseClass{

	
	
	@Test(priority = 3,groups= {"master","sanity"})
	public void Verify_Ethicsandcompliance() {
		
		logger.info("*********** TC_003_EthicsandCompliance started *************");
		//logger.debug("capturing application debug logs....");
		try
		{
		EthicsandCompliance ec = new EthicsandCompliance(driver);

		ec.click_CorporateFunction();
		logger.info("Click on Corporate function.....");
		
		
		ec.hovering();
		logger.info("Hover to the desiered option...");
		takescreenshot("d_hovering.png");

		
		ec.click_EthicsandCompliance();
		logger.info("Click on the ethics and compliance....");
		takescreenshot("ec_ethicsandcompliance.png");

		
		boolean targetPage = ec.isPageExists();
		if(targetPage == true) {
			
			
			Assert.assertTrue(true);
			logger.info("Page exist...");
		}
		else {
			Assert.fail();
			logger.error("Page not exist...");

		}
		
		List<WebElement> elems = ec.getEthicsLinks();
		String[] data = new String[elems.size()];
		for(int i =0; i<elems.size(); i++) {
			data[i] = elems.get(i).getText();
		}
		
		System.out.println("data got : " + Arrays.toString(data));
		utilities.writeInfoInColumn(data,0);
		
		
//		ec.Click_TogetInformation();
//		logger.info("click to get info...");
//		takescreenshot("click_eac.png");
//
//		
//		ec.getInformation();
//		logger.info("printed the info...");
//		takescreenshot("ec.info.png");
		
		

		}
		catch(Exception e){
			Assert.fail();
		}
		
		logger.info("*********** TC_003_EthicsandCompliance finished *************");

	}
}
