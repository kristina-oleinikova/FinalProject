@api
  Feature: Creating run via data file
    Scenario: An authorized user creates a new run data file
      Given preparing data for creating a launch
      Then checking code status
      Then checking id run