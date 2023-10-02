@api
  Feature: Returns all milestones for a project
    Scenario: An authorized user requests all milestones of the project
      Given User submits a request to get milestones
      Then checking status code