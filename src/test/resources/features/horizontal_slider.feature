@ui @horizontalSlider
Feature: HorizontalSlider

  Scenario: User moves slider to specific value
    Given I open the Horizontal Slider page
    When I move the slider to 3.5
    Then I should see that the slider value is updated