package in.krishna.gmail;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import in.krishna.common.BaseClass;
import in.krishna.gmailPages.HomePage;
import in.krishna.gmailPages.LoginPage;
/**
 * @author Krishna
 *
 */
public class LoginToGmailAndSendMailThenLogout extends BaseClass {
	
	@Test(priority=1, description="Login with valid Credentails, send Email and Logout", enabled=true)
	public void LoginTest() {
		
		driver.get("http://www.gmail.com");
		System.out.println(driver.getTitle());
		
		LoginPage onLoginPage=PageFactory.initElements(driver, LoginPage.class);
		onLoginPage.LoginToGmail();
		
		HomePage onHomePage=PageFactory.initElements(driver, HomePage.class);
		onHomePage.verifyLogin();
		
		onHomePage.composeAndSendMail();
		
		onHomePage.Logout();
		
		onLoginPage.verifySignOut();
	}
}
