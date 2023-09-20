Feature: ProfilePage: Open dialog window

  Scenario: EditSettings dialog window is opened by clicking on the corresponding button
    Given open login page
    When user with valid credentials logged in
    Then user navigates to profile page
    * user clicks on Settings button
    Then Edit Settings dialog window is opened