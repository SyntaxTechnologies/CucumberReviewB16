Feature: Login related scenarios


  @sprint1 @regression @smoke @newTestcase @newFeature @sprint2 @login @test
  Scenario: Valid admin login
    When user enters valid admin username and password
    And user clicks on login button
    Then user is successfully logged in the application


Scenario: Enter as a valid Admin
  When user enters the username "Admin" and the password "Hum@nhrm123"
  And clicks on login Btn
  Then the user is logged in and verifies the message "Welcome Admin"


@test2
Scenario Outline: validate the error message for wrong credentials
  When user enters the username "<username>" and the password "<password>"
  And clicks on login Btn
  Then the user is not logged in and verifies the message "<errorMsg>"
  Examples:
  |username|password|errorMsg|
  |Admin   |Hum     |Invalid credentials|
  |        |Hum@nhrm123|Username cannot be empty|


#it is just for an example to see how datatables can be utilized
#  not recommended for this scnario to use dataTables but to use Scnario Outline
@dataTable
Scenario:validate that error message is correct
  When the user Enters the userName password and clicks on login button Then the errorMsg is verified
  |username|password|errorMsg|
  |Admin   |Hum     |Invalid credentials|
  | troy |Hum@norm123|Invalid credentials|
