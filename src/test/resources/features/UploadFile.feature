Feature: Upload avatar image

  Scenario: User uploads profile image
    Given open login page
    When user with valid credentials logged in
    Then user navigates to profile page
    * user clicks on Settings button
