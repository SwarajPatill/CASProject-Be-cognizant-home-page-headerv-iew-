package PageObjects;
 
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
 
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.utilities;
//we can make every webelement private and achive encapsulation beacause we can access this element only in this class
public class BeCognizantPage extends BasePage{
	public static List<WebElement> MainheaderElement;
	public static List<String> header=new ArrayList<String>();
	public static List<WebElement> subHeaderElement,headerElement,hoverElement, iconElement, iconElement2, endHoverElement;
	public static List<String> subHeader, hoverHeader, endHover;
	String filepath = (System.getProperty("user.dir")+"\\TestData\\Data.xlsx");
 
		Actions action;
		public BeCognizantPage(WebDriver driver) {
			super(driver);
		}  
		
		utilities eu = new utilities();
		
		@FindBy(xpath="//div[@role='menubar']//span/span/span") 
		List<WebElement> MainHeaderElement;
		
		public void getHeader() {		
			MainheaderElement = MainHeaderElement;			
		}
		
		public void convertData() throws IOException {
			header = ElementToString.convertData(MainheaderElement, header );
			System.out.println("\n -------------------- Header List--------------------- \n");
			for(String headerlist : header) {
				System.out.println("\t "+ headerlist);
			}

			eu.writeData("MainHeader", header, 0, 0, filepath);
		}
		
		public List<WebElement> retrunList(){
			return MainheaderElement;
		}
		
		int subCol, hoverCol, endHoverCol = 0;
		public void scrollMethod(WebDriver driver) {
		}
		public void getHeaderList() {
 
			headerElement  = retrunList();
		}
		@FindBy(xpath="//li[@role='presentation']//span") 
		List<WebElement> subHeaderElementList;
		@FindBy(xpath="//li[@role='presentation']//i") 
		List<WebElement> iconElementList;
		@FindBy(xpath="/html/body/div[3]//span") 
		List<WebElement> hoverHeaderElementList;
		@FindBy(xpath="/html/body/div[3]//li[@role='presentation']//i") 
		List<WebElement> iconElementList2;
		@FindBy(xpath="/html/body/div[4]//span") 
		List<WebElement> endHoverHeaderElementList;

		public void subHeaderElement(WebDriver driver) throws InterruptedException, IOException {

			Actions act = new Actions(driver);
			for(WebElement e : headerElement ) {
				if(e.getText().equals("be.cognizant")) {
					continue;
				}
				else {				
					e.click();
					System.out.println( " \n -------- " + e.getText() + "  Sub Header List  -------  \n");
					Thread.sleep(1000);
					subHeaderElement = subHeaderElementList;
					iconElement = iconElementList;			
					if(subHeaderElement.size()!=0) {
						subHeader = ElementToString.convertData(subHeaderElement, subHeader);

						eu.writeData("header",  subHeader, 0, subCol, filepath);
//						Thread.sleep(1000);
//						System.out.println("Col No : "+ subCol);
						subCol++;
						for(String r : subHeader) {	
							System.out.println(r);
						}
						if(iconElement.size()!=0) {
							for(WebElement d : iconElement)
							{							
								act.moveToElement(d).build().perform();
								Thread.sleep(1000);
								System.out.println("\n -----Hover Element------ \n");
								hoverElement = hoverHeaderElementList;
								iconElement2 = iconElementList2; 
								hoverHeader = ElementToString.convertData(hoverElement, hoverHeader);
								eu.writeData("subheader",hoverHeader,0,hoverCol, filepath);
								hoverCol++;
								for(WebElement s : hoverElement) {
									System.out.println(s.getText());
								}
								if(iconElement2.size()!=0) 
								{
									for(WebElement f : iconElement2) {
										act.moveToElement(f).build().perform();
										Thread.sleep(1000);
										System.out.println("\n ----- End Hover Element------ \n");
										endHoverElement = endHoverHeaderElementList;
										endHover = ElementToString.convertData(endHoverElement, endHover);
										eu.writeData("hoverheader",endHover,0,endHoverCol, filepath);
										endHoverCol++;
										for(WebElement end : endHoverElement) {
											System.out.println(end.getText());
										}
									}
								}

							}
						}
					}
					else {
						System.out.println("List is Empty");
					}
				}
			}

		}					
 
		
	}

