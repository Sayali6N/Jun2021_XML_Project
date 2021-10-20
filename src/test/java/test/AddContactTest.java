package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import page.AddContactPage;
import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;


public class AddContactTest {
	WebDriver driver;
	
	//Login Data
	String userName = null;
	String password = null;
	String fullName = null;
	String company = null;
	String email =null;
	String phone = null;
	String address =null;
	String city = null;
	String state = null;
	String zip = null;
	String country = null;

	
	//TestData
//	String fullName = "TestNG";
//	String company = "Techfios";
//	String EMAIL ="abc234@techfios.com";
//	String PHONE_NUMBER = "73463943";
//	String COUNTRY = "Angola";
	
	@Test
	@Parameters({"username","password","fullName","company","email","phone","address","city","state","zip","country"})
	public void validUserShouldBeAbleToAddCustomer(String userName,String password,String fullName,String company,String email, String phone,String address,String city,String state,String zip,String country      ) {
		driver = BrowserFactory.init();
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.insertUserName(userName);
		login.insertPassword(password);
		login.clickSigninButton();
		
		DashboardPage dashboard = PageFactory.initElements(driver,DashboardPage.class);
		dashboard.verifyDashboard();
		dashboard.clickCustomerButton();
		dashboard.clickListCustomerButton();
		
		//creating object below
		AddContactPage addContactPage = PageFactory.initElements(driver, AddContactPage.class);
		addContactPage.clickAddCustomerOnListCustomer();
		addContactPage.insertFullName(fullName);
		addContactPage.selectCompany(company);
		addContactPage.insertEmail(email);
		addContactPage.insertPhone(phone);
		addContactPage.insertAddress(address);
		addContactPage.insertCity(city);
		addContactPage.insertState(state);
		addContactPage.insertZip(zip);
		addContactPage.selectCountry(country);
		addContactPage.clickOnSubmitButton();
		addContactPage.verifyProfilePage();
		
		dashboard.clickListCustomerButton();
		
		addContactPage.verifyEnteredNameAndDelete();
		addContactPage.verifyEnteredNameAndProfile();		
		
	}
	

}
