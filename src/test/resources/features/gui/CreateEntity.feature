Feature: Create Project entity

  Scenario: Positive flow: Create Project entity
    Given open login page
    When user with valid credentials logged in
    * user navigates to Projects page
    * user clicks on Project button
    Then user creates new project