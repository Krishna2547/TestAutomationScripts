package in.krishna.gmailPages;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import in.krishna.common.DataTable;
/**
 * @author Krishna
 *
 */
public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	DataTable dt=new DataTable();
	HashMap<String, String> prop=dt.readFile();

	@FindBy(xpath="//input[@type='email']")
	WebElement Email;
	
	@FindBy(name="password")
	WebElement Password;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement Next;
	
	
	private void enterEmail() {
		try {
			
		
		System.out.println("Entering Email Id....");
		Email.sendKeys(prop.get("email"));	
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}
	
	@FindBy(xpath="//h1[text()='Welcome']")
	WebElement Welcome;
	
	private void enterPassword() {
		
		WebDriverWait wait=new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(Welcome));
		
		System.out.println("Entering Password....");
		Password.sendKeys(prop.get("password"));		
		
	}
	
	private void clickOnNext() {
		System.out.println("Clicking on Next button");
		Next.click();
		
	}
	
	public void LoginToGmail() {
		
		enterEmail();
		clickOnNext();
		enterPassword();
		clickOnNext();
	}
	

	public void verifySignOut() {
		
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(Next));
		Assert.assertTrue(Next.isDisplayed(), "Unable to Sign out");
		System.out.println("Signed out successfully");
	}
	
	
	
	
}
