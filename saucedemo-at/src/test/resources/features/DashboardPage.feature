Feature: DashboardPage

  Background:
    Given the user is on the login page "https://www.saucedemo.com/"
    When the user enters the username
    And the user enters the password
    And the user clicks the login button
    Then the user should be redirected to the dashboard page

  Scenario: Add and Remove Items to Cart

    When the user adds items to cart
    And the user navigates to cart
    And get all added items
    And the user removes items from cart
    And get all current items
    Then validate final list of added items
    And user navigates back to items
    And user adds a specific item to cart
    And user navigates back to cart
    And user navigates to checkout

