Feature: Login to the application

  Scenario: Successful login with valid credentials
    Given I navigate to the login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be logged in successfully
