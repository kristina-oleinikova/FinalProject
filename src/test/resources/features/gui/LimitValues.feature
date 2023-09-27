@gui
Feature: Valid input test
  Scenario: Input Test
    Given open loginPage
    When Enter email kristina.oleinikova95@gmail.com and password AQAcourse123
    * User click login button
    * Project page is displayed
    * Click project button
    * Entering a value in the Summary field