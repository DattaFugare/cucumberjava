Feature: login

  Scenario: login to web app
    Given user on login page
    When user enter valid username and password
    And click on sign button
    Then user should be login sccessfully
