Scenario Outline: Login with valid credentials
  Given I launch the application
  When I enter username "<username>" and password "<password>"
  And I click the login button
  Then I should see the success message

  Examples:
    | username | password     |
    | student  | Password123  |
    | admin    | Admin123     |
    | test     | Test123      |
