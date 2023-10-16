@gui
Feature: Login flow

  Scenario: Login with valid credentials
    Given open login page
    When user with valid credentials logged in
    Then Projects dashboard page is opened

  Scenario: Login with invalid credentials
    Given open login page
    When user with invalid credentials logged in
    Then error message is shown