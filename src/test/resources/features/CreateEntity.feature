Feature: Create Project entity

  Scenario: Positive flow: Create Project entity
    Given open login page
    When user with valid credentials logged in
    * user navigates to Projects page
    * user clicks on Project button
    * user fills the form with valid data and submit
    Then created project is displayed in grid