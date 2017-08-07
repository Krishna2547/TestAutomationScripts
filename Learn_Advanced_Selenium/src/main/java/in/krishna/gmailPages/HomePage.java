package in.krishna.gmailPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import in.krishna.common.PageUtil;
/**
 * @author Krishna
 *
 */
public class HomePage extends PageUtil{

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
	
	private void clickOnCompose() {
		compose.click();
	}
	
	@FindBy(xpath="//div/textarea[@name='to']")
	WebElement to;
	
	private void enterRecepientID() {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(to));
		
		System.out.println("Entering mail id..");
		to.sendKeys(prop.get("toEmail"));
	}
	
	@FindBy(xpath="//input[@name='subjectbox']")
	WebElement subject;
	private void enterSubject() {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(subject));
		
		System.out.println("Entering Subject...");
		subject.sendKeys(prop.get("subject"));
	}
	
	@FindBy(xpath="//div[contains(@aria-label,'Message')]")
	WebElement body;
	private void enterBody() {
		System.out.println("Entering msg body...");
		body.sendKeys(prop.get("body"));
	}
	
	@FindBy(xpath="//div[contains(@aria-label,'Send')]")
	WebElement send;
	
private void clickOnSend() {
	System.out.println("Clicking on Send");
	send.click();
}

@FindBy(xpath="//div[contains(text(),'Your message has been sent.')]")
WebElement sentmsg;

private void verifyIfSent() {
	try{
		Thread.sleep(4000);
	Assert.assertTrue(sentmsg.isDisplayed(), "Mail not sent");
	System.out.println("Hurray! mail sent");
	}catch(Exception e) {
		e.printStackTrace();
	}
	
}

public void composeAndSendMail() {
	
	clickOnCompose();
	enterRecepientID();
	enterSubject();
	enterBody();
	clickOnSend();
	verifyIfSent();
}
	
	
	@FindBy(xpath="//a[contains(@title,'Google Account')]/span")
	WebElement Account;
	
	private void clickOnAccount() {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(Account));
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
