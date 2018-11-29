package step_definitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_objects.HomePage;
import page_objects.RegisterPage;

public class SignUpSteps {
	
	public WebDriver driver;
	//public HomePage home;
	public RegisterPage register; 
	
	HomePage home = new HomePage(driver);
	
	//Below test is for validating register function
	@Given("^user navigates to newtours\\.demoaut\\.com$")
	public void user_navigates_to_newtours_demoaut_com() throws Throwable {		
		home.navigateToWebApp();

	}

	@When("^user clicks on register button$")
	public void user_clicks_on_register_button() throws Throwable {
		//Once we navigate to register page by calling the method "home.navigateToRegisterPage()" in HomePage Class,
		//we need to capture the information somewhere so that we can perform all related actions in RegisterPage class, 
		//because we are returning a value in navigateToRegisterPage() function; 
		register = home.navigateToRegisterPage(); //This is the way to capture the returned value 

	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and_and(String FirstName, String LastName, String EmailAddress) throws Throwable {		
		register.setContactInfo(FirstName, LastName, EmailAddress);
	}

	@Then("^user click on dropdown list$")
	public void user_click_on_dropdown_list() throws Throwable {
		register.clickDropdown();
	}

	@Then("^user selects \"([^\"]*)\"$")
	public void user_selects(String Country) throws Throwable {
		register.selectOptions(Country);
	   
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\" and enters \"([^\"]*)\" again$")
	public void user_enters_and_and_enters_again(String username, String password, String password2) throws Throwable {
		register.setUserInfo(username, password, password2);
	}

	@Then("^user clicks on submit button$")
	public void user_clicks_on_submit_button() throws Throwable {
		register.clickSubmit();
	}

	@Then("^verify that success message is displayed$")
	public void verify_that_success_message_is_displayed() throws Throwable {
		//Verify the link URL
		Assert.assertEquals(register.getURL(), "http://newtours.demoaut.com/create_account_success.php");
		
	}
	
	
 /**************************************************/
	//Blow test is for validating login function
	@Given("^user navigates to home page$")
	public void user_navigates_to_home_page() throws Throwable {
		home.navigateToWebApp();

	}

	@When("^user logs in using \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_logs_in_using_and(String userName, String passWord) throws Throwable {
		home.enterUserInfo(userName, passWord);
	 
	}
	
	@Then("^user should see logged in \"([^\"]*)\"$")
	public void user_should_see_logged_in(String arg1) throws Throwable {
	
	}

}