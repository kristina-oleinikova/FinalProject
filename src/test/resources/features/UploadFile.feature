Feature: Upload avatar image

  Scenario: User uploads profile image
    Given open login page
    When user with valid credentials logged in
    Then user navigates to profile page
    * user clicks on Settings button
    Then Edit Settings dialog window is opened
    * user clicks on Change button
    * user uploads an image
    * user clicks on SaveSettings button
    Then the uploaded image is shown as Profile Avatar
