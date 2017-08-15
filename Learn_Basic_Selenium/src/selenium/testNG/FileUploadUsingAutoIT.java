package selenium.testNG;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class FileUploadUsingAutoIT {

	
	@Test
	public void Fileuploader() throws Exception {
		
		System.setProperty("webdriver.gecko.driver", "./Resources/GeckoDriver/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///C:/Users/Lenovo/Desktop/fileupload.html");
		driver.findElement(By.xpath("//input[@name='resumeupload']")).click();
		Thread.sleep(4000);
		System.out.println("Hang on! Uploading the file");
		Runtime.getRuntime().exec("D:\\Java\\AutoITscritps\\UploadScript.exe");
		System.out.println("File uploaded Sucessfully");
		Thread.sleep(5000);
		driver.quit();
		
	}
}
