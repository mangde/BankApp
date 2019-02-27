Feature: Negetive scenarios for the BankAppConfiguration Account service

  Scenario: get 404 NotFound exception -> with invalid customerId
    Given I use openAccount with invalid customerId
    When I invoke /openAccount API with invalid CustomerId
    Then I received message Customer id not found status code 404

  Scenario: get 417 expectation fail exception -> with invalid accountType inputs
    Given I use openAccount with invalid data inputs
    When I invoke /openAccount API with invalid data inputs
    Then I received message failed to open account status code 417


  Scenario: failed to depositeAmount
    When I invoke /deposite API with invalid data
    Then I received message failed to deposite amount with response status code 417


  Scenario: makes call to checkAvailable Balance Configuration with invalid account number
    When I invoke /getBalance API with invalid accountNumber
    Then I received Account Number not found with response status code 404

  Scenario: getting Service unavailable exception in  withdrawAmount Configuration
    When I invoke /withDraw API with invalid data
    Then I received message failed to withdraw amount  with response status code 503

  Scenario: get 404 not found exception for invalid getAccountDetail
    When I invoke /getAccountDetail API with invalid accountNumber
    Then I received message account not found with response status code 404

