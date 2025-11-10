@ui @dropdown
Feature: Dropdown

  Scenario: Select "Option 2" and check it
    Given I am on dropdown page
    When I select "Option 2"
    Then I should see "Option 2" on dropdown