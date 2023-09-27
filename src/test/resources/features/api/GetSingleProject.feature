@api
Feature: Get Single Project

  Scenario: Authorized user get particular project
    Given GET project by projectId "60"
    Then status code is validated
    Then received ProjectId is validated