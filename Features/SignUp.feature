@tag
Feature: Registeration function
  This feature is used to verify that user is able to register to the site

#This feature file shows how Cucumber Examples works  
  @SignUpTest
  Scenario Outline: sign up Function
    Given user navigates to newtours.demoaut.com
    When user clicks on register button
    Then user enters "<FirstName>" and "<LastName>" and "<EmailAddress>"
    Then user click on dropdown list
    Then user selects "<Country>"
    Then user enters "<UserName>" and "<PassWord>" and enters "<PassWord>" again
    Then user clicks on submit button
    Then verify that success message is displayed

    Examples: 
      | FirstName | LastName | EmailAddress         | Country        | UserName | PassWord |
      | Mikki     | Aisha    | mikkiusa11@gmail.com | UNITED KINGDOM | test     | test123  |

      