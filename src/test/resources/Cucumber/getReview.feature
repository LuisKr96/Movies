Feature: I want to get the reviews from the database

  Scenario: I want to view the reviews
    Given The films have reviews
    When I go to the website
    Then The the reviews should appear