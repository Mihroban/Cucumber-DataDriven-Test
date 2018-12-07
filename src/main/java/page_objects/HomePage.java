package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
	//homepage instance will be inherited from base page
	public HomePage(WebDriver driver) {
		super(driver);
		 
	}
  
	public RegisterPage navigateToRegisterPage(){
		driver.findElement(By.partialLinkText("REGISTER")).click();
		return new RegisterPage(driver);
	}
	
	public SignOnPage enterUserInfo(String userName, String passWord) throws InterruptedException{
		driver.findElement(By.name("userName")).sendKeys(userName);
		driver.findElement(By.name("password")).sendKeys(passWord);
		driver.findElement(By.name("login")).click();
		Thread.sleep(3000);
		return new SignOnPage(driver);
	}
	

}
