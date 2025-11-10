@ui @authenticator
Feature: Authentication

  Scenario: User logs in and logs out
    Given I open the login page
    When I fill username "tomsmith" and password "SuperSecretPassword!" and click on the Login button
    Then I should see message "You logged into a secure area!"
    When I click on the Logout button
    Then I should see login field