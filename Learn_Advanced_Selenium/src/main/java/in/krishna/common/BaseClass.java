package in.krishna.common;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

/**
 * @author Krishna
 *
 */
public class BaseClass {
	
public WebDriver driver;

@Parameters({"browser"})
@BeforeClass
public void Start(String Browser) {
	  
		try {
			if(Browser.equalsIgnoreCase("Firefox")) {
			
				System.setProperty("webdriver.gecko.driver", "./src/main/resources/Drivers/Firefox/geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
				//driver.manage().window().maximize();
				
				
			}else if(Browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "./src/main/resources/Drivers/Chrome/chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(90, TimeUnit.SECONDS);
				driver.manage().window().maximize();
				
			}else if(Browser.equalsIgnoreCase("ie")) {
				
				System.setProperty("webdriver.ie.driver", "./src/main/resources/Drivers/IE/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				driver.manage().window().maximize();
			
				
			}else {
				Assert.fail("Invalid Browser choosen");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		
		
	  
}

@AfterClass
public void End() {
	  System.out.println("Closing the driver");
	  //driver.close();
	  driver.quit();
	  try {
		  Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
	 }

}
