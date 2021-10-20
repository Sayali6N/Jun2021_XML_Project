package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class LoginTest {
	
//To call methods from different class following are different ways
//Inherit//Creating Object// Calling By the name of Class.
//here we are using calling By Name Of Class --> to call methods from different Class.
	
	WebDriver driver;
	
	//Login Data

	String userName = null; 
	String password = null;
	

	
	@Test
//	@Parameters({"username","password"})
//	public void validUserShouldBeAbleToLogin(String userName, String password) {//can do this way or below both are correct.
	@Parameters({"password","username"})
	public void validUserShouldBeAbleToLogin(String password , String userName) {
		
		driver = BrowserFactory.init();
		
	//we are creating object below
		
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
//		System.out.println(driver.getTitle());
		
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver,DashboardPage.class);
		dashboard.verifyDashboard();
		
		BrowserFactory.tearDown();
	}
}
