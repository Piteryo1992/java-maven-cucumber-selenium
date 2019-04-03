Feature: LoginFeature
  This feature depageals with login functionality of teh application

  Scenario: Login with correct username and password
    Given I navigate to the login page of the application
    And I enter the following details for login
      | username | password      |
      | admin    | adminpassword |
    And I click login button
    Then I should see the userform