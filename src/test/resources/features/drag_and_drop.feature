@ui @dragAndDrop
Feature: Drag and Drop

  Scenario: Drag and Drop elements
    Given I am on the drag and drop page
    When I drag element A to element B
    Then elements should swap places
