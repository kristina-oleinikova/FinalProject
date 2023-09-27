@api
Feature: Get All Projects

  Scenario: Authorized user get list of all projects
    Given GET projects list
    Then response status code is validated
    Then list of project is available