package page_objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class RegisterPage extends BasePage{
	public WebElement dropdown;

	public RegisterPage(WebDriver driver) {
		super(driver);
	}
	
	public RegisterPage setContactInfo(String FirstName, String LastName, String EmailAddress){
		
		driver.findElement(By.name("firstName")).sendKeys(FirstName);
		driver.findElement(By.name("lastName")).sendKeys(LastName);
		driver.findElement(By.id("userName")).sendKeys(EmailAddress);
		return new RegisterPage(driver);
		
	}
	
	public RegisterPage clickDropdown(){
		driver.findElement(By.name("country")).click();
		return new RegisterPage(driver);
	}
	
	public RegisterPage selectOptions(String country){
		Select dropdown = new Select(driver.findElement(By.name("country")));
		dropdown.selectByVisibleText(country);
		return new RegisterPage(driver);
	}
	
	public RegisterPage setUserInfo(String username, String password, String password2){
		driver.findElement(By.id("email")).sendKeys(username);
	     driver.findElement(By.name("password")).sendKeys(password);
	     driver.findElement(By.name("confirmPassword")).sendKeys(password2);
		return new RegisterPage(driver);
		
	}
	
	public RegisterPage clickSubmit(){
		driver.findElement(By.name("register")).click();	 
		return new RegisterPage(driver);
	}
	
	public String getURL(){
		String URL = driver.getCurrentUrl();
		return URL;
	}
	
}
