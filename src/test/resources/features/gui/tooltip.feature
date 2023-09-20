Feature: Display a pop-up message

  Scenario: Display a tooltip
    Given login page open
    When enter email kristina.oleinikova95@gmail.com and password AQAcourse123
    * user click login button
    Then project page is displayed
    * click project button
    Then tooltip is displayed
