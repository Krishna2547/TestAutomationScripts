package selenium.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Launch_Browser {

	WebDriver driver;
	
	public void OpenBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "./Resources/GeckoDriver/geckodriver.exe");
		driver=new FirefoxDriver();
		driver.get("http://www.google.com");
		//driver.manage().window().maximize();
		System.out.println("Congratulations! Browser Launched");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.quit();
	}
	
	public static void main(String []args) {
		
		Launch_Browser obj=new Launch_Browser();
		obj.OpenBrowser();
	}
	
}