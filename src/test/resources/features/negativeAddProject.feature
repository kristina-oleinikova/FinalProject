Feature: Creating a negative test project

  Scenario: Creating a project without a name
    Given browser open
    When user enter email kristina.oleinikova95@gmail.com and password AQAcourse123
    * user clicks login button
    Then projects page is displayed
    * user click project button
    * user click button Add Project
    Then message The name field is required. is displayed