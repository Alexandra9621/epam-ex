Feature: LoginPage

  Scenario Outline: Successful login
    Given the user is on the login page "<url>"
    When the user enters the username
    And the user enters the password
    And the user clicks the login button
    Then the user should be redirected to the dashboard page


    Examples:
      | url                       |
      | https://www.saucedemo.com |
      | invalid_url               |