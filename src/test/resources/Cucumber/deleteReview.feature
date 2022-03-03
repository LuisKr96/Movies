Feature: I want to delete a review from the database

  Scenario: A review has been deleted from the database
    Given I enter a review ID
    When I delete the review
    Then I get a return deleted