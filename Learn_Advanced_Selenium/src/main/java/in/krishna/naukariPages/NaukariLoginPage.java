package in.krishna.naukariPages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import in.krishna.common.PageUtil;

public class NaukariLoginPage extends PageUtil {

	WebDriver driver;
	public NaukariLoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	JavascriptExecutor jse;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement login;
	
	private void clickOnLogin() {
		
		System.out.println("Clicking on login link");
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(login));

		login.click();
	}
	
	@FindBy(name="email")
	WebElement eid;
	@FindBy(name="PASSWORD")
	WebElement psw;
	
	private void enterEmail() {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(eid));
		System.out.println("Entering email...");
		eid.sendKeys(prop.get("email"));
	}
	
	private void enterPassword() {
		psw.sendKeys(prop.get("password"));
	}
	
	@FindBy(xpath="//button[text()='Login']")
	WebElement submit;
	
	private void clickOnSubmit() {
		System.out.println("Clicking on login button");
		submit.click();
		
	}
	
	@FindBy(xpath="//span[contains(text(),'Kadali')]")
	WebElement name;
	
	private void validateLogin() {
		
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(name));
		
		jse=(JavascriptExecutor) driver;
		jse.executeScript("scroll(0,1000)");
		
		Assert.assertTrue(name.isDisplayed(),"not logged in");
		System.out.println("Successfully logged in");
	}
	
	@FindBy(xpath="//div[contains(text(),'Last updated')]")
	WebElement TimeStamp;
	private void lastUpdate() {
		
		System.out.println(TimeStamp.getText());
		
	}
	
	public void Signin() {
		
		clickOnLogin();
		enterEmail();
		enterPassword();
		clickOnSubmit();
		validateLogin();
		lastUpdate();
	}
}
