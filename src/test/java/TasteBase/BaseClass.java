package TasteBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BaseClass {
	static public WebDriver driver;
	public Logger logger;
	public Properties p;
	//make every method public 
	
	@BeforeClass(groups= {"sanity","regression","master"})
	@Parameters({"browser"})
	public void setup(String browser) throws IOException {
		
		
		//loading properties file
		FileReader file = new FileReader(".//src/test/resources/config.properties");
		p = new Properties();
		p.load(file);
		
		//Loadinglog4j file for that we have a LogManager class in which getLogger method we have to use
		
		logger = LogManager.getLogger(this.getClass());
		
		switch(browser.toLowerCase())
		{
		
		case "chrome" : 
			driver = new ChromeDriver();
			logger.info(browser +" "+ "browser opened successfully");
			break;
			
		case "edge" : 
			driver = new EdgeDriver(); 
			logger.info(browser + " "+ "browser opened successfully");

			break;
			
		default: 
			logger.error("No matching browser...." );
			return;
		}
		
		
		
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(p.getProperty("appURL"));
		logger.info("Base Page loaded sucessfully.......");
		driver.manage().window().maximize();
	}
	
	
	//Method to take screenshot
	
		
		public void takescreenshot(String fileName) {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);      // capture 
			File trg = new File(".\\screenshots\\" + fileName);  // store
			
			try {
				FileUtils.copyFile(src, trg);
			}
			catch(IOException e) {
				System.out.println("could not take screenshot");
			}
		}
	 //method to take screenshot of fail test cases
		public String captureScreen(String tname)throws IOException{
			String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			TakesScreenshot takeScreenshot = (TakesScreenshot)driver;
			File sourceFile = takeScreenshot.getScreenshotAs(OutputType.FILE);
			String targetFilePath=System.getProperty("user.dir")+"\\ER_screenshots\\" + tname +"-" + timeStamp + ".png";
			File targetFile = new File(targetFilePath);
			
			sourceFile.renameTo(targetFile);
			return targetFilePath;
		}
	
	
	
		
	@AfterClass(groups= {"sanity","regression","master"})
	public void tearDown() {
		driver.quit();
		logger.info("browser closed successfully....");
	}
}
