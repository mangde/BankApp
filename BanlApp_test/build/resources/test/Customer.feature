Feature: Positive/negetive scenarios for the BankAppConfiguration Customer service

  Scenario: makes call to register a customer Configuration
    Given I use addCustomer with valid data
    When I invoke /addCustomer API
    Then I received response status code 201 with register customer detail

  Scenario: makes call to register a customer ->invalid dataInputs
    Given I use addCustomer with invalid data
    When I invoke /addCustomer API for invalid data
    Then I received  status code 417 with message fail to register customer


  Scenario: makes call to getAllCustomer Configuration
    When I invoke getAllCustomer API
    Then I received response status code 200 with all customer detail


  Scenario: makes call to getAllCustomer Configuration with ->invalid url
    When I invoke getAllCustomer API with invalid url
    Then I received message bad request with status code 400


  Scenario: makes call to getCustomerById Configuration
    When I invoke getCustomerById API
    Then I received response status code 200 with  customer detail

  Scenario: makes call to  getCustomerById Configuration with ->invalid customerId
    When I invoke getCustomerById API with invalid customerId
    Then I received response status code 404 with message  customer NOt found
