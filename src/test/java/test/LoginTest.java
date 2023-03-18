package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.LoginPage;
import util.BrowserFactory;
import util.ExcelReader;

public class LoginTest {

	WebDriver driver;

	
	ExcelReader exlRead = new ExcelReader("src\\main\\java\\testData\\DCB_TestData.xlsx");
	String userName = exlRead.getCellData("LoginInfo", "UserName", 2);
	String password = exlRead.getCellData("LoginInfo", "Password", 2);
	String dashboardValidationText = exlRead.getCellData("LoginInfo", "PageValidationText", 2);
	
	@Test
	public void validuserShouldbeAbleTologin() {
		
		 driver = BrowserFactory.init();
		
		 	LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
			loginPage.enterUserName(userName);
			loginPage.enterPassword(password);
			loginPage.clickSigninButton();
			
			
			
			BrowserFactory.tearDown();
		
		
	}
}
