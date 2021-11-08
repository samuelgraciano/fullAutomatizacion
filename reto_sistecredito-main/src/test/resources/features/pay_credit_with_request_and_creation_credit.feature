Feature: Pay credit with request and creation credit
  Like a user
  I want to request and pay a credit
  For buy on local stores

  @E2E
  Scenario: Request, create and pay a credit
    Given that Juan created a new client
    And he requested a valid quota
    When he creates a credit
    And he pays the credit
    Then he should see the confirmation of pay