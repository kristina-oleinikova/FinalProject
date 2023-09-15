Feature: Usage invalid data test

  Scenario: Login with invalid credentials
    Given open login page
    When user with invalid credentials logged in
    Then error message is shown