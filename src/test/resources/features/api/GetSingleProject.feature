@api
Feature: Get Single Project

  Scenario: Authorized user get particular project
    Given GET project by projectId 65
    Then status code is validated
    Then received ProjectId is validated