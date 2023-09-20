Feature: Test for entering data exceeding the permissible limits

  Scenario: exceeding permissible test
    Given Login Page open
    When enter Email kristina.oleinikova95@gmail.com and Password AQAcourse123
    * User click loginButton
    * User click link project
    * User click button Milestones
    * User click button add milestone
    * User create milestone
    Then Message The start date does not match the format Y-m-d. is displayed