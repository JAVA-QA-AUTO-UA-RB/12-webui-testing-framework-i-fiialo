@ui @checkboxes
Feature: Checkbox

  Scenario: Fill all checkboxes and check they are chosen
    Given I am on the checkbox page
    When I select all checkboxes
    Then all checkboxes should be checked