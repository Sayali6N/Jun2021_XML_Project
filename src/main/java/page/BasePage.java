package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	//below we created a method for Random Number.
		public  int generateRandomNo(int boundaryNumber) {
			Random rnd = new Random();
			int generatedNo = rnd.nextInt(boundaryNumber);
			return generatedNo;
			
		}
		
		public void selectFromDropdown(WebElement selectElement, String visibleText) {
			Select sel = new Select(selectElement);
			sel.selectByVisibleText(visibleText);
			
		}
		
		public static void waitForElement(WebDriver driver, int timeInSeconds, WebElement element) {
			WebDriverWait wait = new WebDriverWait(driver,timeInSeconds);
			wait.until(ExpectedConditions.visibilityOf(element));
			
		}
}
