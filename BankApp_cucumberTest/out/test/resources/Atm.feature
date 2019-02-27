Feature: Positive/negetive scenarios for the BankAppConfiguration TransferAmount service

  Scenario: makes call to /issueAtm Configuration
    Given I use issueAtm
    When I invoke /issueAtm API
    Then I received response status code 201 with issue Atm successful message

  Scenario: makes call to /issueAtm Configuration->invalid account number
    Given I use issueAtm for invalid account
    When I invoke /issueAtm API for invalid account number
    Then I received response status code 404 with Account not found message

  Scenario: makes call to /issueAtm Configuration->already issued atm to account
    Given I use issueAtm for  account already taken
    When I invoke /issueAtm API for  duplicate account number
    Then I received response status code 208 with Account Already issue atm message

  Scenario: makes call to /displayAllAtm Configuration
    When I invoke /displayAllAtm API
    Then I received response status code 200 withAll Atm details
