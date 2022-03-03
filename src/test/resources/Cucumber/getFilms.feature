Feature: I want to get the films from the database

  Scenario: I want to view the films
    Given The website has a list of films
    When I go to the website
    Then The films should appear