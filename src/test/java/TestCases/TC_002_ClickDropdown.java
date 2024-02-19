package TestCases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import PageObjects.BeCognizantPage;
import PageObjects.UserValidation;
import TasteBase.BaseClass;

public class TC_002_ClickDropdown extends BaseClass{
		
	@Test(priority=2 ,groups = {"master","regression"})
	public void Verify_Click_Dropdown() throws InterruptedException, IOException {
		BeCognizantPage bp = new BeCognizantPage(driver);
		logger.info("------Getting Header Items ---");
		bp.getHeader();
		bp.convertData();

	}
	@Test(priority = 2,groups = {"master","regression"})
	public void getSubHeader() throws InterruptedException, IOException {
		BeCognizantPage bp = new BeCognizantPage(driver);
		logger.info("------Getting Sub Header & Hover menu Items ---");
		bp.getHeaderList();
		bp.subHeaderElement(driver);
	}	

 
	
	

		 



	 
			

	}

