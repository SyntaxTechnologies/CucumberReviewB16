package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import utlis.CommonMethods;
import utlis.ConfigReader;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndNavigateToURL();
    }
    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
        sendText( ConfigReader.getPropertyValue("username"),loginPage.usernameField);
        sendText( ConfigReader.getPropertyValue("password"),loginPage.passwordField);

    }
    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
      click(loginPage.loginButton);
    }
    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        String actualMsg = dash.WelcomeMsg.getText();
        String expectedMsg="Welcome Admin";
        Assert.assertEquals(expectedMsg,actualMsg);
    }

}
