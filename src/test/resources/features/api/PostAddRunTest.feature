@api
Feature: Creates a new automation run in a target project in preparation for adding threads and test results.

  Scenario: An authorized user creates a new run
    Given Preparing data for creating a launch
    Then Checking code status
    Then Checking id run
