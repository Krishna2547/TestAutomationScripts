package in.krishna.naukari;

import java.util.Set;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import in.krishna.common.BaseClass;
import in.krishna.naukariPages.NaukariLoginPage;

public class NaukariLogin extends BaseClass{

	@Test
	public void Login() throws Exception {
		
		driver.get("https://www.naukri.com/");
		Thread.sleep(4000);
		String Parent=driver.getWindowHandle();
		
		Set <String> allWindows=driver.getWindowHandles();
		
		for(String window: allWindows) {
			
			if(!Parent.equalsIgnoreCase(window)) {
				driver.switchTo().window(window);
				Thread.sleep(3000);
				System.out.println("Closing Add window" +driver.getTitle());
				driver.close();
			}
		}
			driver.switchTo().window(Parent);
			System.out.println(driver.getTitle());
		/*	
			driver.findElement(By.xpath("//div[text()='Login']")).click();
			driver.findElement(By.name("email")).sendKeys("k.t.krishna2547@gmail.com");
			driver.findElement(By.name("PASSWORD")).sendKeys("krishna.nd");
			driver.findElement(By.xpath("//button[text()='Login']")).click();
		*/
			NaukariLoginPage onNaukariLoginPage=PageFactory.initElements(driver, NaukariLoginPage.class);
			onNaukariLoginPage.Signin();
	}
}
