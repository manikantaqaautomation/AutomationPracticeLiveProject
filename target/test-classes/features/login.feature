Feature: Login Functionality

  Scenario: Valid login credentials
    Given I launch the application
    When I enter username "student" and password "Password123"
    And I click the login button
    Then I should see the success message
