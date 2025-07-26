Feature: Login Functionality

  @Smoke
  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid username and password
    Then i_should_be_redirected_to_the_dashboard