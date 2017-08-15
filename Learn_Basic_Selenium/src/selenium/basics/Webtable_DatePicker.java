package selenium.basics;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtable_DatePicker {

	public static void main(String[] args) {
		
			try {
				System.setProperty("webdriver.chrome.driver", "./Resources/ChromeDriver/chromedriver.exe");
				WebDriver driver=new ChromeDriver();
				
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
				
				driver.get("http://www.redbus.in");
				
				Thread.sleep(4000);
				
				driver.findElement(By.xpath("//div/span[contains(@class,'onward')]")).click();
				Thread.sleep(3000);
				
				List<WebElement> dates=driver.findElements(By.xpath("//div[@id='rb-calendar_onward_cal']/table//td"));
				
				int d=dates.size();
				
				for(int i=0; i<d; i++) {
					
					String day=dates.get(i).getText();	
					
					if(day.equalsIgnoreCase("17")) {
						System.out.println("Date of Journey: "+day);
						
						dates.get(i).click();
						break;
					}
				}
				
				Thread.sleep(5000);
				System.out.println("Closing the browser");
				driver.quit();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}
	}


