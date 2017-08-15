package selenium.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoCompleteSelect {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./Resources/ChromeDriver/chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("http://www.redbus.in");
		
		Thread.sleep(4000);
	
		driver.findElement(By.id("src")).clear();
		driver.findElement(By.id("src")).sendKeys("Bang");
		Thread.sleep(4000);
		List<WebElement> options=driver.findElements(By.id("src"));
		
		for(WebElement ops: options) {
			if(ops.getText().equals("Bangalore")) {
				System.out.println("I am travelling from: "+ops.getText());
				ops.click();
				break;
			}
		}
		
		driver.findElement(By.id("dest")).clear();
		driver.findElement(By.id("dest")).sendKeys("Kaki");
		Thread.sleep(4000);
		List<WebElement> options1=driver.findElements(By.id("dest"));
		
		for(WebElement ops1: options1) {
			if(ops1.getText().equals("Kakinada")) {
				System.out.println("I am travelling to: "+ops1.getText());
				ops1.click();
				break;
			}
		}
		Thread.sleep(5000);
		System.out.println("Closing browser");
		driver.quit();

	}

}
