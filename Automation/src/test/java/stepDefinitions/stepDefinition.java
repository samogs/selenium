package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinition {

	@Given("^User is on landing page$")
    public void user_is_on_landing_page() throws Throwable {
        // Code to navigate to login url
		System.out.println("Successfully navigated to user url");
    }

    @When("^User login into application with username and password$")
    public void user_login_into_application_with_username_and_password() throws Throwable {
    	// Code to login
    	System.out.println("Successfully logged in");
    }

    @Then("^Home page is populated$")
    public void home_page_is_populated() throws Throwable {
        // User home page validation
    	System.out.println("User home page successfully validated");
    }

    @And("^User information is displayed$")
    public void user_information_is_displayed() throws Throwable {
        // Validating user information on user home page
    	System.out.println("Successfully validated user info");
    }
	
}
