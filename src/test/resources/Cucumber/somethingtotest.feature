Feature: Is the language German?
  As a customer I want to know if the movie comes in German
  Scenario: Movie is in German
    Given That I am on the movie database
    When I select the language options
    Then I expect the movie to have an option in "German"