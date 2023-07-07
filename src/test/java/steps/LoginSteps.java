package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import utlis.CommonMethods;
import utlis.ConfigReader;
import utlis.Log;

import java.util.List;
import java.util.Map;

public class LoginSteps extends CommonMethods {

    @Given("user is navigated to HRMS application")
    public void user_is_navigated_to_hrms_application() {
        openBrowserAndNavigateToURL();
    }

    @When("user enters valid admin username and password")
    public void user_enters_valid_admin_username_and_password() {
//        integrate the log4j.xml configuration file into our project
        DOMConfigurator.configure("log4j.xml");
        Log.startTestCase("the test case started");
        sendText(ConfigReader.getPropertyValue("username"), loginPage.usernameField);
        sendText(ConfigReader.getPropertyValue("password"), loginPage.passwordField);

    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        click(loginPage.loginButton);
    }

    @Then("user is successfully logged in the application")
    public void user_is_successfully_logged_in_the_application() {
        Log.info("the test case is in final step");
        String actualMsg = dash.WelcomeMsg.getText();
        String expectedMsg = "Welcome Admi";
        Assert.assertEquals(expectedMsg, actualMsg);
    }


    @When("user enters the username {string} and the password {string}")
    public void user_enters_the_username_and_the_password(String userName, String password) {
        sendText(userName, loginPage.usernameField);
        sendText(password, loginPage.passwordField);
    }

    @When("clicks on login Btn")
    public void clicks_on_login_btn() {
        click(loginPage.loginButton);

    }

    @Then("the user is logged in and verifies the message {string}")
    public void the_user_is_logged_in_and_verifies_the_message(String expectedMsg) {
        String actualMsg = dash.WelcomeMsg.getText();
        Assert.assertEquals(actualMsg, expectedMsg);
    }


    @Then("the user is not logged in and verifies the message {string}")
    public void the_user_is_not_logged_in_and_verifies_the_message(String expectedMsg) {
        String actualErrorMsg = loginPage.errorMsgField.getText();

        Assert.assertEquals(actualErrorMsg, expectedMsg);
    }


    @When("the user Enters the userName password and clicks on login button Then the errorMsg is verified")
    public void the_user_enters_the_user_name_password_and_clicks_on_login_button_then_the_error_msg_is_verified(DataTable dataTable) throws InterruptedException {

        List<Map<String, String>> datalist = dataTable.asMaps();

//        iterate over the list of maps
        for (Map<String, String> data : datalist) {
            String userName = data.get("username");
            String password = data.get("password");
            String expectedError = data.get("errorMsg");

            sendText(userName, loginPage.usernameField);
            sendText(password, loginPage.passwordField);
            Thread.sleep(5000);
            click(loginPage.loginButton);


            String actualError = loginPage.errorMsgField.getText();
            Assert.assertEquals(actualError, expectedError);
            Thread.sleep(5000);
        }

    }

//    @When("user adds multiple employees using excel from {string} and verify it")
//    public void user_adds_multiple_employees_using_excel_from_and_verify_it
//            (String sheetName) throws InterruptedException {
//        //here we are getting the data from excel file using parameters
//        List<Map<String, String>> newEmployees =
//                ExcelReader.read(sheetName, Constants.EXCEL_READER_PATH);
//
//        Iterator<Map<String, String>> itr = newEmployees.iterator();
//
//        //it will check whether we have new element/value or not
//        while (itr.hasNext()) {
//
//            //in this map, we have data from every single employee one by one it will give us that data
//            Map<String, String> mapNewEmp = itr.next();
//            //we are filling the employee data now using mapNewEmp variable
//            //BATCH 16, KEYS WHAT WE ARE PASSING HERE SHOULD MATCH WITH THE KEYS IN EXCEL
//            sendText(mapNewEmp.get("firstName"), addEmployeePage.firstNameField);
//            sendText(mapNewEmp.get("lastName"), addEmployeePage.lastNameField);
//            sendText(mapNewEmp.get("middleName"), addEmployeePage.middleNameField);
//            sendText(mapNewEmp.get("photograph"), addEmployeePage.photograph);
//
//        }
//    }
}


