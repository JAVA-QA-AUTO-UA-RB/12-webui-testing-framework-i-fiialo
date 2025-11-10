@ui @add @remove
Feature: Add and remove elements

  Scenario: User adds and removes 3 buttons
    Given I open the AddRemove Elements page
    When I add 3 "Delete" buttons
    Then I should see 3 "Delete" buttons
    When I remove 3 "Delete" buttons
    Then I shouldn't see any "Delete" buttons