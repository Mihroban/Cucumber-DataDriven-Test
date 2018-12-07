@tag
Feature: Log in feature of http://newtours.demoaut.com/
  			 Verify that login function works

  #We have shown how Cucumber Examples works in Signup feature/ signUp steps
  #Below we will show how to use Data Table in Cucumber
  @DataTableExample
  Scenario: Validate Register feature of newtours.demoaut.com/
    Given user navigates to newtours home page
    When user clicked on Register link
    And user enter the Contact Information details
      | FirstName | Mikki                |
      | LastName  | Aisha                |
      | Email     | mikkiusa11@gmail.com |
    And user enter the Mailing Information Details
      | Address    | Manhattan |
      | City       | New York  |
      | State      | NY        |
      | PostalCode |     10001 |
    And user select dropdown list
    And user choose "<Country>" from the list
      | Country | UNITED KINGDOM |
    And user enter the User Information Details
      | UserName   | Mikki   |
      | Password   | test123 |
      | ConfirmPWD | test123 |
    Then user click on Submit button
    Then I verify the register success message

  @LoginTest
  Scenario Outline: Login Function
    Given user navigates to home page
    When user logs in using "<username>" and "<password>"
    Then user enters "<username>" and "<password>"
    Then user should see logged in "<status>"

    Examples: 
      | username | password | status         |
      | Mikki    | test123  | successfully   |
      | Mikki    | test111  | unsuccessfully |
