Feature: Single Item Checkout

  Scenario: Login and place an order
    Given I navigate to the Swag Labs login page
    When I login with username "standard_user" and password "secret_sauce"
    And I add "Sauce Labs Backpack" to the cart
    And I proceed to checkout
    And I fill the checkout details with first name "adam", last name "gil", and postal code "456309"
    And I complete the order
    Then I verify the order completion message
