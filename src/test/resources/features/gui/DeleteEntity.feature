@gui
Feature: Delete Created Project entity

  Scenario: Delete created project from the table
    Given open login page
    When user with valid credentials logged in
    * user navigates to Projects page
    * user clicks on trashButton for created project in list
    * user submit deleting action
    Then project is in delete process