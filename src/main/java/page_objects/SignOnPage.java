package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignOnPage extends BasePage{

	public SignOnPage(WebDriver driver) {
		super(driver);
		 
	}
	
	public SignOnPage logUserInfo(String userName, String passWord){
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.name("login")).click();
		return new SignOnPage(driver);		
	}

}
