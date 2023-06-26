#Author:dattatray
Feature: search functionality

  Scenario: serach "books" select on high prize
    Given user on search functionality
    When user search for books
    Then user list out all books
    And select book on high prize
