package TestBase;


import java.io.FileReader;
import java.io.IOException;
import java.lang.System.Logger;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.beust.jcommander.Parameter;

import org.apache.logging.log4j.LogManager;


import net.bytebuddy.asm.Advice.This;



public class BaseClass {
	
public WebDriver driver;

public org.apache.logging.log4j.Logger log; 

public Properties prop; 

		@BeforeClass(groups= {"Sanity","Regression","Master"}) 
		@Parameters({"browser","os"})
		public void setUp(String br, String os) throws IOException {
			
			ChromeOptions options = new ChromeOptions();
			FirefoxOptions options2 = new FirefoxOptions();
			
			
		    // Required for Jenkins/headless environments
		    options.addArguments("--headless=new");
		    options.addArguments("--no-sandbox");
		    options.addArguments("--disable-dev-shm-usage");
		    options.addArguments("--disable-gpu");
		    options.addArguments("--window-size=1920,1080");
		    
		    

			
			FileReader fr = new FileReader("C:\\Users\\psanj\\eclipse-workspace\\OpenCartFrameWorkProject\\src\\test\\resources\\config.properties");
			prop = new Properties();
			prop.load(fr);
			
			
			log = LogManager.getLogger(BaseClass.class);
			
			
			if(prop.getProperty("execution_env").equalsIgnoreCase("remote")) {
				DesiredCapabilities cap = new DesiredCapabilities(); 
				
				if(os.equalsIgnoreCase("windows")) {
					cap.setPlatform(Platform.WIN11);
				}
				
				else if(os.equalsIgnoreCase("mac")) {
					cap.setPlatform(Platform.MAC);
				}
				
				else if(os.equalsIgnoreCase("linux")) {
					cap.setPlatform(Platform.LINUX);
				}
				
				
				else {
					System.out.println("no matching os");
					return;
				}
				
				
				switch(br.toLowerCase()) {
				case "chrome": cap.setBrowserName("chrome");
				break;
				
				case "edge": cap.setBrowserName("MicrosoftEdge");
				break; 
				
				case "firefox": cap.setBrowserName("firefox");
				break; 
				
				default:System.out.println("not matching browser");
				return; 
				
				}
				
				driver = new RemoteWebDriver(new URL(prop.getProperty("huburl")), cap);
						
			}
			
			if(prop.getProperty("execution_env").equalsIgnoreCase("local")) {
				
				switch(br.toLowerCase()) {
				case "chrome":
					driver = new ChromeDriver(options);
					break;
					
				case "firefox":
					driver = new FirefoxDriver();
					break; 
					
				case "edge":
					driver = new EdgeDriver();
					break;
					
				default:
					System.out.println("Please provide a valid browser name");
					return ;
					
				}
				
				
			}
			
			
//			driver = new ChromeDriver(); 
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.get(prop.getProperty("baseurl")); 
			
		}
			
			
		
		
		@AfterClass(groups= {"Sanity","Regression","Master"})
		public void tearDown() {
			driver.quit();
		}
		
		
		
		
	
	
	    public String RandomString() {
			
			String randomString = RandomStringUtils.randomAlphabetic(5);
			return randomString; 
		}
		
		public String Password() {
			String randompss = RandomStringUtils.randomAlphanumeric(5); 
			String randompas1 = RandomStringUtils.randomNumeric(2);
			return randompss + randompas1;
		}
		
		public String telphone() {
			String telphone = RandomStringUtils.randomNumeric(10);
			return telphone;
		}
		
		
//		public String captureScreen(String tname) {
//			String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//			TakesScreenshot ts = (TakesScreenshot) driver;
//			File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//			String targetpath = System.getProperty("user.dir") + "\\Screenshots\\" + tname + timeStamp + ".png";
//			File targetFile = new File(targetpath);
//			
//			sourceFile.renameTo(targetFile);
//			return targetpath; 
//			
//			
//		}

		
		
		

}
