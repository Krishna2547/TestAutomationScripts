package selenium.testNG;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

@Listeners(selenium.testNG.TestNG_Listners.class)   
//This is classes level implementation. We can also implement this in suite level through testNG xml.
public class TestNG_ParallelTesting {
 
	WebDriver driver;
	
	@Test(priority=1, description="Just opening facebook login page")
  public void OpenFacebook() {
		
		driver.get("http://www.facebook.com");
		System.out.println("The page title is: "+driver.getTitle());
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("email")));
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
  }
	
	@Parameters({"browser"})
  @BeforeTest
  public void Start(String Browser) {
	  
		try {
			if(Browser.equalsIgnoreCase("Firefox")) {
				
				System.setProperty("webdriver.gecko.driver", "./Resources/GeckoDriver/geckodriver.exe");
				driver=new FirefoxDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			}else if(Browser.equalsIgnoreCase("chrome")) {
				
				System.setProperty("webdriver.chrome.driver", "./Resources/ChromeDriver/chromedriver.exe");
				driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
			}else if(Browser.equalsIgnoreCase("ie")) {
				
				System.setProperty("webdriver.ie.driver", "./Resources/IEDriver/IEDriverServer.exe");
				driver=new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
				
			}else {
				Assert.fail("Invalid Browser choosen");
			}
		} catch (Exception e) {
		
			e.printStackTrace();
		}
	  
  }

  @AfterTest
  public void End() {
	  
	  //driver.close();
	  driver.quit();
	  try {
		  Runtime.getRuntime().exec("taskkill /F /IM IEDriverServer.exe");
		  } catch (IOException e) {
		  e.printStackTrace();
		  }
	 
	  
  }

}
