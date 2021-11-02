@TestGitHub
Feature: Git Hub sign in



  Scenario: error message is displayed upon registration with invalid email pattern
    Given Github home page is opened
    When user enters "invalid123" into email field
    Then error message below email field should be displayed





  Scenario: message under password field indicates a completeness of password requirements

    Given Github home page is opened
    When user enters "qwe23@gmail.com" into email field
    And click Continue button
    When user enters "AAA" into password field
    Then "Password is too short" message should appears
    When user enters "AAAaaaAA" into password field
    Then "Password needs a number and lowercase letter" message should appears
    When user enters "AAAaaaAA123123" into password field
    Then "Password is strong" message should appears



  Scenario: error message is displayed upon registration with already existent username

    Given Github home page is opened
#    And at least one username is already registered in application
    When user enters already existent username into username field
    Then error message below email field should be displayed
