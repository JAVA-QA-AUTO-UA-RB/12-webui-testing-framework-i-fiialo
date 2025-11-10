@ui @text
Feature: A/B Testing

  Scenario: User sees the text "A/B Test Control" on the page
    Given I open the AB Testing page
    Then I should see text that contains "A/B Test Control"