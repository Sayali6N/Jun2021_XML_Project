package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
//All Classes are Associated with methods and variables/ attribute/ Field.	
//Java is Associated with classes and Objects
	WebDriver driver;
	//below we are creating  with arguments
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	//Login Data
	String userName = "demo@techfios.com";
	String password = "abc123";
	
	
	
	//storing elements with By class another way is as below.
	@FindBy(how = How.XPATH, using = "//input[@id='username']") WebElement USERNAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]") WebElement PASSWORD_ELEMENT;
	@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button") WebElement SIGNIN_BUTTON_ELEMENT;
	
	//Individual Methods
	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	public void clickSigninButton() {
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	//All together in one single Method----> we can do either using individual methods or by using together in one single method way.
	public void performLoginTest(String userName, String password) {
		USERNAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	
	
}
