package in.krishna.gmailPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/**
 * @author Krishna
 *
 */
public class HomePage {

	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//div[text()='COMPOSE']")
	WebElement compose;
	
	public void verifyLogin() {
		System.out.println("Hold on! Gmail is loading.");
		
			WebDriverWait wait=new WebDriverWait(driver, 60);
			wait.until(ExpectedConditions.visibilityOf(compose));
			
		Assert.assertTrue(compose.isDisplayed(),"Login Failed");
		System.out.println("Successfully Logged in");
	}
	
	@FindBy(xpath="//a[contains(@title,'Google Account')]/span")
	WebElement Account;
	
	private void clickOnAccount() {
		
		Account.click();
	}
	
	@FindBy(xpath="//a[text()='Sign out']")
	WebElement signOut;
	
	private void clickOnSignOut() {
		
		System.out.println("Clicking on Sign Out");
		signOut.click();
	}
	

	public void Logout() {
		clickOnAccount();
		clickOnSignOut();
	}
	
	
}
