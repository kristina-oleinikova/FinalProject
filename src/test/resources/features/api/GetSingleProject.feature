Feature: Get Single Project

  Scenario: Authorized user get particular project
    Given GET project by id
    Then response JSON is validated