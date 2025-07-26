Feature: Login Functionality

  @Smoke
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    Then I should be redirected to the Admin page