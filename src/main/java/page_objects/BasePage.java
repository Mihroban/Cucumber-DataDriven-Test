package page_objects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
	protected WebDriver driver;
	public static final String url = "http://newtours.demoaut.com";
	public static final String chromeDriverPath = "/Users/miheliwanaishamuding/Downloads/chromedriver";

	
	public BasePage(WebDriver driver){
		this.driver= driver;
		
	}

	//Below method means that it will return a HomePage object which returns the instance of HomePage Class;  
	//The way to invoke the object is to call the method below:
	//To get the instance of HomePage class, we simply return that object and pass it in its driver;
	public HomePage navigateToWebApp(){
		System.setProperty("webdriver.chrome.driver",chromeDriverPath);
		driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.navigate().to(url);
		return new HomePage(driver);
		
	}

	public void closeDriver(){
		driver.quit();
	}
}
