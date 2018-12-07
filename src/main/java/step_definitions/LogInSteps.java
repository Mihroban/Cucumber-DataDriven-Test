package step_definitions;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import page_objects.HomePage;
import page_objects.RegisterPage;
import page_objects.SignOnPage;

public class LogInSteps{
	
	public WebDriver driver;
	public RegisterPage register; 	 
	HomePage home = new HomePage(driver);
	public SignOnPage signOn;
	
	@Given("^user navigates to newtours home page$")
	public void user_navigates_to_newtours_home_page() throws Throwable {
		home.navigateToWebApp();
	}

	@When("^user clicked on Register link$")
	public void user_clicked_on_Register_link() throws Throwable {
		register = home.navigateToRegisterPage();
	   
	}

	@Then("^user enter the Contact Information details$")
	public void user_enter_the_Contact_Information_details(DataTable contactInfo) throws Throwable {	
		List<List<String>> data = contactInfo.raw();
		register.setContactInfo(data.get(0).get(1), data.get(1).get(1), data.get(2).get(1));
	    
	}

	@Then("^user enter the Mailing Information Details$")
	public void user_enter_the_Mailing_Information_Details(DataTable mailInfo) throws Throwable {
		List<List<String>> mailData = mailInfo.raw();
		register.setMailingInfo(mailData.get(0).get(1), mailData.get(1).get(1), mailData.get(2).get(1), mailData.get(3).get(1));
	   
	}
	
	@Then("^user select dropdown list$")
	public void user_select_dropdown_list() throws Throwable {
	    register.clickDropdown();
	}

	@Then("^user choose \"([^\"]*)\" from the list$")
	public void user_choose_from_the_list(String dropdown, DataTable country) throws Throwable {
		List<List<String>> countryData = country.raw();
		register.selectOptions(countryData.get(0).get(1));
	}

	@Then("^user enter the User Information Details$")
	public void user_enter_the_User_Information_Details(DataTable userInfo) throws Throwable {
	    List<List<String>> userData = userInfo.raw();
	    register.setUserInfo(userData.get(0).get(1), userData.get(1).get(1), userData.get(2).get(1));
	    
	}

	@Then("^user click on Submit button$")
	public void user_click_on_Submit_button() throws Throwable {
	   register.clickSubmit();

	}

	@Then("^I verify the register success message$")
	public void i_verify_the_register_success_message() throws Throwable {
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
		signOn = home.enterUserInfo(userName, passWord);
	 
	}

	@Then("^user enters \"([^\"]*)\" and \"([^\"]*)\"$")
	public void user_enters_and(String UName, String Pwd) throws Throwable {
	     signOn.logUserInfo(UName, Pwd);
	}
	
	@Then("^user should see logged in \"([^\"]*)\"$")
	public void user_should_see_logged_in(String status) throws Throwable {
	    //not able to verify due to unfixed bugs of the web site 
	}

}
