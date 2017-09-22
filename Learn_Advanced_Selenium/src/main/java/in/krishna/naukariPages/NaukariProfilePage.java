package in.krishna.naukariPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import in.krishna.common.PageUtil;

public class NaukariProfilePage extends PageUtil {

	WebDriver driver;
	public NaukariProfilePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath="//b[contains(text(),'Update Profile')]")
	WebElement updateButton;
	
	private void clickOnUpdateButton() {
		updateButton.click();
	}
	
	@FindBy(xpath="//strong[contains(text(),'Snapshot')]/following-sibling::a")
	WebElement profileSnapshotEdit;
	
	private void clickOnProfileSnapshotEdit() {
		profileSnapshotEdit.click();
		
	}
	
	@FindBy(name="pincode")
	WebElement pinCode;
	
	private void enterPinCode() {
		pinCode.clear();
		System.out.println("Entering pincode");
		pinCode.sendKeys("533002");
	}
	
	@FindBy(xpath="//b[contains(text(),'Save')]")
	WebElement saveButton;
	
	private void clickOnSaveButton() {
		saveButton.click();
	}
	
	@FindBy(xpath="//span[contains(text(),'successfully')]")
	WebElement ConfirmMsg;
	
	private void verifyIfSuccess() {
		
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(ConfirmMsg));
		
		Assert.assertTrue(ConfirmMsg.isDisplayed(),"not updated");
		System.out.println("Successfully updated");
	}
	
	@FindBy(linkText="My Naukri Home")
	WebElement NaukariHomeLink;
	private void navigateBackToHomePage() {
		NaukariHomeLink.click();
	}
	
	@FindBy(xpath="//div[contains(text(),'Last updated')]")
	WebElement TimeStamp;
	
	private void lastUpdate() {
		
		System.out.println(TimeStamp.getText());
		
	}
	
	public void UpdateAndSave() {
		
		clickOnUpdateButton();
		clickOnProfileSnapshotEdit();
		enterPinCode();
		clickOnSaveButton();
		verifyIfSuccess();
		navigateBackToHomePage();
		lastUpdate();
	}
	
	@FindBy(xpath="//div[@class='topIcon user']")
	WebElement profileIcon;
	
	private void hoverOverProfileIcon() {
		Actions a1 = new Actions(driver);
		a1.moveToElement(profileIcon).build().perform();
		
	}
	
	@FindBy(linkText="Log Out")
	WebElement logoutLink;
	
	private void clickOnLogout() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(logoutLink));
		logoutLink.click();
	}
	
	public void Logout() {
		
		hoverOverProfileIcon();
		clickOnLogout();
	}
	
	
	
	
}
