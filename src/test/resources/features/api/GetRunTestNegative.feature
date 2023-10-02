@api
  Feature: Returns one run
    Scenario: Request to view a specific run
      Given sending a request to obtain a run id that does not exist
      Then checking code status response