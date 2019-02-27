Feature: Positive/negetive scenarios for the BankAppConfiguration TransferAmount service

  Scenario: makes call to /transferAmount Configuration
    Given I use transferAmount
    When I invoke /transferAmount API
    Then I received response status code 201 with successful message

  Scenario: makes call to /transferAmount Configuration->invalid account number
    Given I use transferAmount invalid account number
    When I invoke /transferAmount API with invalid account number
    Then I received response transfer amount failed with status code 417

  Scenario: makes call to /transferAmount Configuration->insufficient balance
    Given I use transferAmount when insufficient balance
    When I invoke /transferAmount when insufficient  account balance
    Then I received response transfer amount failed with status code 417

  Scenario: makes call to /transferAmount Configuration->fail to deposite
    Given I use transferAmount invalid receiver account number
    When when fail to deposite to receiver account
    Then rollback transaction received response transfer amount failed with status code 417


  Scenario: makes call to /transactionHistory Configuration
    When I invoke /transactionHistory API
    Then I received response status code 200 with all transaction History
