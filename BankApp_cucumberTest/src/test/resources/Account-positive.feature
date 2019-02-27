Feature: Positive scenarios for the BankAppConfiguration Account service

  Scenario: makes call to /openAccount Configuration
    Given I use openAccount
    When I invoke /openAccount API
    Then I received response status code 201

  Scenario: makes call to depositeAmount Configuration
    When I invoke /deposite API
    Then I received new updated balance with response status code 200


  Scenario: makes call to checkAvailable Balance Configuration
    When I invoke /getBalance API
    Then I received current available Balance with response status code 200

  Scenario: makes call to withdrawAmount  Configuration
    When I invoke /withDraw API
    Then I received remaining balance with response status code 200

  Scenario: makes call to getAccountDetail  Configuration
    When I invoke /getAccountDetail API
    Then I received AccountDetails  with response status code 200

