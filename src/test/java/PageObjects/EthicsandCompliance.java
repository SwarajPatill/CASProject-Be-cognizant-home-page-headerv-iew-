package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class EthicsandCompliance extends BasePage{
		
	
	public EthicsandCompliance(WebDriver driver) {
		super(driver);
	}
	
	
	@FindBy(xpath ="(//*[starts-with(@class,'ms-Button-flexContainer flexContainer')])[6]")
	private WebElement CorporateFunction;
	
	@FindBy(xpath="//span[text()=\"Legal & Corporate Affairs\"]")
	private WebElement LegalandCorporateAffairs;
	
	@FindBy(xpath="//span[text()=\"Ethics and Compliance\"]")
	private WebElement EticsandCompliance;
	
	@FindBy(xpath="//h2[text()=\"Ethics & Compliance Risks\"]")
	private WebElement Information;
	
//	@FindBy(xpath="//div[@class=\"ControlZone--control\"]")
//	private WebElement details1;
//	
//	@FindBy(xpath="(//div[@data-automation-id=\"CanvasSection\"])[6]")
//	private WebElement detail2;
//	
//	@FindBy(xpath="(//div[@data-automation-id=\"CanvasSection\"])[8]")
//	private WebElement detail3;
//	
//	@FindBy(xpath="//div[@data-automation-id=\"textBox\"]")
//	private WebElement details;
	
	@FindAll(@FindBy(xpath="(//div[@data-automation-id=\"CanvasControl\"])[8]//div[@id=\"QuicklinksItemTitle\"]"))
	List<WebElement> ethicsLinks;


	
	
	
	@FindBy(id="title_text" )
	private WebElement title;
	
	public String Detail,Detail1,Detail2,Detail3;
	
	
	
	public void click_CorporateFunction() {
		CorporateFunction.click();
		
	}
	
	public void hovering() {
		Actions act = new Actions(driver);
		act.moveToElement(LegalandCorporateAffairs).build().perform();
		String HoverText = LegalandCorporateAffairs.getText();
		System.out.println( "The heading on which we are going to click :-" + " "+ HoverText);
		
	}
	
	public void click_EthicsandCompliance() {
		EticsandCompliance.click();
	}
	
	public boolean isPageExists() {
		try {
			return(title.isDisplayed());
		}catch(Exception e) {
			return (false);
		}
	}
	
//	public void Click_TogetInformation() {
//		Information.click();
//	}
//	
//	public void getInformation() {
//				
//		System.out.println(details.getText());
//		System.out.println("-------------------------------------------------------------");
//		System.out.println(details1.getText());
//		System.out.println("-------------------------------------------------------------");
//		System.out.println(detail2.getText());
//		System.out.println("-------------------------------------------------------------");
//		System.out.println(detail3.getText());
//	}
	
	public List<WebElement> getEthicsLinks(){
		return ethicsLinks;
	}
	

}




