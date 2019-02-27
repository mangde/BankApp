$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Account-negetive.feature");
formatter.feature({
  "line": 1,
  "name": "Negetive scenarios for the BankAppConfiguration Account service",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "get 404 NotFound exception -\u003e with invalid customerId",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service;get-404-notfound-exception--\u003e-with-invalid-customerid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I use openAccount with invalid customerId",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I invoke /openAccount API with invalid CustomerId",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I received message Customer id not found status code 404",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iUseOpenAccountWithInvalidCustomerId()"
});
formatter.result({
  "duration": 101825127,
  "status": "passed"
});
formatter.match({
  "location": "AccountCucumberTestSteps.openAccountInvalid()"
});
formatter.result({
  "duration": 69592577,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 53
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedMessageCustomerIdNotFoundStatusCode(int)"
});
formatter.result({
  "duration": 40125925,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "get 417 expectation fail exception -\u003e with invalid accountType inputs",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service;get-417-expectation-fail-exception--\u003e-with-invalid-accounttype-inputs",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I use openAccount with invalid data inputs",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I invoke /openAccount API with invalid data inputs",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I received message failed to open account status code 417",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iUseOpenAccountWithInvalidDataInputs()"
});
formatter.result({
  "duration": 1050625,
  "status": "passed"
});
formatter.match({
  "location": "AccountCucumberTestSteps.iInvokeOpenAccountAPIWithInvalidDataInputs()"
});
formatter.result({
  "duration": 820782,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 54
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedMessageFailedToOpenAccountStatusCode(int)"
});
formatter.result({
  "duration": 37287247,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "failed to depositeAmount",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service;failed-to-depositeamount",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I invoke /deposite API with invalid data",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I received message failed to deposite amount with response status code 417",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iInvokeDepositeAPIWithInvalidData()"
});
formatter.result({
  "duration": 478659,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 71
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedMessageFailedToDepositeAmountWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 26632326,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "makes call to checkAvailable Balance Configuration with invalid account number",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service;makes-call-to-checkavailable-balance-configuration-with-invalid-account-number",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I invoke /getBalance API with invalid accountNumber",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I received Account Number not found with response status code 404",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iInvokeGetBalanceAPIWithInvalidAccountNumber()"
});
formatter.result({
  "duration": 1150773,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 62
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedAccountNumberNotFoundWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 23932673,
  "status": "passed"
});
formatter.scenario({
  "line": 23,
  "name": "getting Service unavailable exception in  withdrawAmount Configuration",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service;getting-service-unavailable-exception-in--withdrawamount-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 24,
  "name": "I invoke /withDraw API with invalid data",
  "keyword": "When "
});
formatter.step({
  "line": 25,
  "name": "I received message failed to withdraw amount  with response status code 503",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iInvokeWithDrawAPIWithInvalidData()"
});
formatter.result({
  "duration": 364827,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "503",
      "offset": 72
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedMessageFailedToWithdrawAmountWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 27538949,
  "status": "passed"
});
formatter.scenario({
  "line": 27,
  "name": "get 404 not found exception for invalid getAccountDetail",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service;get-404-not-found-exception-for-invalid-getaccountdetail",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 28,
  "name": "I invoke /getAccountDetail API with invalid accountNumber",
  "keyword": "When "
});
formatter.step({
  "line": 29,
  "name": "I received message account not found with response status code 404",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iInvokeGetAccountDetailAPIWithInvalidAccountNumber()"
});
formatter.result({
  "duration": 344610,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 63
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedMessageAccountNotFoundWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 20095931,
  "status": "passed"
});
formatter.uri("src/test/resources/Account-positive.feature");
formatter.feature({
  "line": 1,
  "name": "Positive scenarios for the BankAppConfiguration Account service",
  "description": "",
  "id": "positive-scenarios-for-the-bankappconfiguration-account-service",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "makes call to /openAccount Configuration",
  "description": "",
  "id": "positive-scenarios-for-the-bankappconfiguration-account-service;makes-call-to-/openaccount-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I use openAccount",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I invoke /openAccount API",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I received response status code 201",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iUseOpenAccount()"
});
formatter.result({
  "duration": 317862,
  "status": "passed"
});
formatter.match({
  "location": "AccountCucumberTestSteps.openAccount()"
});
formatter.result({
  "duration": 692019,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 32
    }
  ],
  "location": "AccountCucumberTestSteps.receivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 39729998,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "makes call to depositeAmount Configuration",
  "description": "",
  "id": "positive-scenarios-for-the-bankappconfiguration-account-service;makes-call-to-depositeamount-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I invoke /deposite API",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I received new updated balance with response status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.depositeAmount()"
});
formatter.result({
  "duration": 517538,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 57
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedNewUpdatedBalanceWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 55481602,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "makes call to checkAvailable Balance Configuration",
  "description": "",
  "id": "positive-scenarios-for-the-bankappconfiguration-account-service;makes-call-to-checkavailable-balance-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I invoke /getBalance API",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I received current available Balance with response status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.getCurrentBalance()"
});
formatter.result({
  "duration": 338078,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 63
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedCurrentAvailableBalanceWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 47839221,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "makes call to withdrawAmount  Configuration",
  "description": "",
  "id": "positive-scenarios-for-the-bankappconfiguration-account-service;makes-call-to-withdrawamount--configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 18,
  "name": "I invoke /withDraw API",
  "keyword": "When "
});
formatter.step({
  "line": 19,
  "name": "I received remaining balance with response status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.withDraw()"
});
formatter.result({
  "duration": 373224,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 55
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedRemainingBalanceWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 55455476,
  "status": "passed"
});
formatter.scenario({
  "line": 21,
  "name": "makes call to getAccountDetail  Configuration",
  "description": "",
  "id": "positive-scenarios-for-the-bankappconfiguration-account-service;makes-call-to-getaccountdetail--configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 22,
  "name": "I invoke /getAccountDetail API",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I received AccountDetails  with response status code 200",
  "keyword": "Then "
});
formatter.match({
  "location": "AccountCucumberTestSteps.iInvokeGetAccountDetailAPI()"
});
formatter.result({
  "duration": 292048,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 53
    }
  ],
  "location": "AccountCucumberTestSteps.iReceivedAccountDetailsWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 19974323,
  "status": "passed"
});
formatter.uri("src/test/resources/Atm.feature");
formatter.feature({
  "line": 1,
  "name": "Positive/negetive scenarios for the BankAppConfiguration TransferAmount service",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "makes call to /issueAtm Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/issueatm-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I use issueAtm",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I invoke /issueAtm API",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I received response status code 201 with issue Atm successful message",
  "keyword": "Then "
});
formatter.match({
  "location": "AtmCucumberTest.iUseIssueAtm()"
});
formatter.result({
  "duration": 4228628,
  "status": "passed"
});
formatter.match({
  "location": "AtmCucumberTest.iInvokeIssueAtmAPI()"
});
formatter.result({
  "duration": 799010,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 32
    }
  ],
  "location": "AtmCucumberTest.iReceivedResponseStatusCodeWithIssueAtmSuccessfulMessage(int)"
});
formatter.result({
  "duration": 34515437,
  "error_message": "java.lang.AssertionError: expected [201] but found [417]\r\n\tat org.testng.Assert.fail(Assert.java:96)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:776)\r\n\tat org.testng.Assert.assertEqualsImpl(Assert.java:137)\r\n\tat org.testng.Assert.assertEquals(Assert.java:118)\r\n\tat org.testng.Assert.assertEquals(Assert.java:652)\r\n\tat org.testng.Assert.assertEquals(Assert.java:662)\r\n\tat com.nuance.him.cucumbertest.AtmCucumberTest.iReceivedResponseStatusCodeWithIssueAtmSuccessfulMessage(AtmCucumberTest.java:58)\r\n\tat ✽.Then I received response status code 201 with issue Atm successful message(src/test/resources/Atm.feature:6)\r\n",
  "status": "failed"
});
formatter.scenario({
  "line": 8,
  "name": "makes call to /issueAtm Configuration-\u003einvalid account number",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/issueatm-configuration-\u003einvalid-account-number",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I use issueAtm for invalid account",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I invoke /issueAtm API for invalid account number",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I received response status code 404 with Account not found message",
  "keyword": "Then "
});
formatter.match({
  "location": "AtmCucumberTest.iUseIssueAtmForInvalidAccount()"
});
formatter.result({
  "duration": 352697,
  "status": "passed"
});
formatter.match({
  "location": "AtmCucumberTest.iInvokeIssueAtmAPIForInvalidAccountNumber()"
});
formatter.result({
  "duration": 667138,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 32
    }
  ],
  "location": "AtmCucumberTest.iReceivedResponseStatusCodeWithAccountNotFoundMessage(int)"
});
formatter.result({
  "duration": 22392502,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "makes call to /issueAtm Configuration-\u003ealready issued atm to account",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/issueatm-configuration-\u003ealready-issued-atm-to-account",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I use issueAtm for  account already taken",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I invoke /issueAtm API for  duplicate account number",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I received response status code 208 with Account Already issue atm message",
  "keyword": "Then "
});
formatter.match({
  "location": "AtmCucumberTest.iUseIssueAtmForAccountAlreadyTaken()"
});
formatter.result({
  "duration": 352075,
  "status": "passed"
});
formatter.match({
  "location": "AtmCucumberTest.iInvokeIssueAtmAPIForDuplicateAccountNumber()"
});
formatter.result({
  "duration": 755467,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "208",
      "offset": 32
    }
  ],
  "location": "AtmCucumberTest.iReceivedResponseStatusCodeWithAccountAlreadyIssueAtmMessage(int)"
});
formatter.result({
  "duration": 30280279,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "makes call to /displayAllAtm Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/displayallatm-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I invoke /displayAllAtm API",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I received response status code 200 withAll Atm details",
  "keyword": "Then "
});
formatter.match({
  "location": "AtmCucumberTest.iInvokeDisplayAllAtmAPI()"
});
formatter.result({
  "duration": 292981,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 32
    }
  ],
  "location": "AtmCucumberTest.iReceivedResponseStatusCodeWithAllAtmDetails(int)"
});
formatter.result({
  "duration": 31427631,
  "status": "passed"
});
formatter.uri("src/test/resources/Customer.feature");
formatter.feature({
  "line": 1,
  "name": "Positive/negetive scenarios for the BankAppConfiguration Customer service",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "makes call to register a customer Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-register-a-customer-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I use addCustomer with valid data",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I invoke /addCustomer API",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I received response status code 201 with register customer detail",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iUseAddCustomerWithValidData()"
});
formatter.result({
  "duration": 4295185,
  "status": "passed"
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeAddCustomerAPI()"
});
formatter.result({
  "duration": 737117,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 32
    }
  ],
  "location": "CustomerCucumberTest.iReceivedResponseStatusCodeWithRegisterCustomerDetail(int)"
});
formatter.result({
  "duration": 148120445,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "makes call to getAllCustomer Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-getallcustomer-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I invoke getAllCustomer API",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "I received response status code 200 with all customer detail",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.callDisplayCustomers()"
});
formatter.result({
  "duration": 413656,
  "status": "passed"
});
formatter.match({
  "location": "CustomerCucumberTest.getAllCustomersDetails()"
});
formatter.result({
  "duration": 27870185,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "makes call to getAllCustomer Configuration with -\u003einvalid url",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-getallcustomer-configuration-with--\u003einvalid-url",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I invoke getAllCustomer API with invalid url",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "I received message bad request with status code 400",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeGetAllCustomerAPIWithInvalidUrl()"
});
formatter.result({
  "duration": 255347,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "400",
      "offset": 48
    }
  ],
  "location": "CustomerCucumberTest.iReceivedMessageBadRequestWithStatusCode(int)"
});
formatter.result({
  "duration": 24555335,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "makes call to getCustomerById Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-getcustomerbyid-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I invoke getCustomerById API",
  "keyword": "When "
});
formatter.step({
  "line": 20,
  "name": "I received response status code 200 with  customer detail",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeGetCustomerByIdAPI()"
});
formatter.result({
  "duration": 342744,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 32
    }
  ],
  "location": "CustomerCucumberTest.iReceivedResponseStatusCodeWithCustomerDetail(int)"
});
formatter.result({
  "duration": 20130143,
  "status": "passed"
});
formatter.scenario({
  "line": 22,
  "name": "makes call to  getCustomerById Configuration with -\u003einvalid customerId",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to--getcustomerbyid-configuration-with--\u003einvalid-customerid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 23,
  "name": "I invoke getCustomerById API with invalid customerId",
  "keyword": "When "
});
formatter.step({
  "line": 24,
  "name": "I received response status code 404 with message  customer NOt found",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeGetCustomerByIdAPIWithInvalidCustomerId()"
});
formatter.result({
  "duration": 307910,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 32
    }
  ],
  "location": "CustomerCucumberTest.iReceivedResponseStatusCodeWithMessageCustomerNOtFound(int)"
});
formatter.result({
  "duration": 7610347,
  "status": "passed"
});
formatter.uri("src/test/resources/TransferAmount.feature");
formatter.feature({
  "line": 1,
  "name": "Positive/negetive scenarios for the BankAppConfiguration TransferAmount service",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "makes call to /transferAmount Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/transferamount-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "I use transferAmount",
  "keyword": "Given "
});
formatter.step({
  "line": 5,
  "name": "I invoke /transferAmount API",
  "keyword": "When "
});
formatter.step({
  "line": 6,
  "name": "I received response status code 201 with successful message",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferAmountCucumberTest.iUseTransferAmount()"
});
formatter.result({
  "duration": 2897772,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.iInvokeTransferAmountAPI()"
});
formatter.result({
  "duration": 884229,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 32
    }
  ],
  "location": "TransferAmountCucumberTest.iReceivedResponseStatusCodeWithSuccessfulMessage(int)"
});
formatter.result({
  "duration": 95612504,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "makes call to /transferAmount Configuration-\u003einvalid account number",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/transferamount-configuration-\u003einvalid-account-number",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I use transferAmount invalid account number",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I invoke /transferAmount API with invalid account number",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I received response transfer amount failed with status code 417",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferAmountCucumberTest.iUseTransferAmountInvalidAccountNumber()"
});
formatter.result({
  "duration": 360472,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.iInvokeTransferAmountAPIWithInvalidAccountNumber()"
});
formatter.result({
  "duration": 1802049,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 60
    }
  ],
  "location": "TransferAmountCucumberTest.iReceivedResponseTransferAmountFailedWithStatusCode(int)"
});
formatter.result({
  "duration": 22045093,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "makes call to /transferAmount Configuration-\u003einsufficient balance",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/transferamount-configuration-\u003einsufficient-balance",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 14,
  "name": "I use transferAmount when insufficient balance",
  "keyword": "Given "
});
formatter.step({
  "line": 15,
  "name": "I invoke /transferAmount when insufficient  account balance",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I received response transfer amount failed with status code 417",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferAmountCucumberTest.iUseTransferAmountWhenInsufficientBalance()"
});
formatter.result({
  "duration": 233887,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.iInvokeTransferAmountWhenInsufficientAccountBalance()"
});
formatter.result({
  "duration": 735251,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 60
    }
  ],
  "location": "TransferAmountCucumberTest.iReceivedResponseTransferAmountFailedWithStatusCode(int)"
});
formatter.result({
  "duration": 22143997,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "makes call to /transferAmount Configuration-\u003efail to deposite",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/transferamount-configuration-\u003efail-to-deposite",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 19,
  "name": "I use transferAmount invalid receiver account number",
  "keyword": "Given "
});
formatter.step({
  "line": 20,
  "name": "when fail to deposite to receiver account",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "rollback transaction received response transfer amount failed with status code 417",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferAmountCucumberTest.iUseTransferAmountInvalidReceiverAccountNumber()"
});
formatter.result({
  "duration": 369492,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.whenFailToDepositeToReceiverAccount()"
});
formatter.result({
  "duration": 735873,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 79
    }
  ],
  "location": "TransferAmountCucumberTest.rollbackTransactionReceivedResponseTransferAmountFailedWithStatusCode(int)"
});
formatter.result({
  "duration": 22797761,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "makes call to /transactionHistory Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-transferamount-service;makes-call-to-/transactionhistory-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "I invoke /transactionHistory API",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I received response status code 200 with all transaction History",
  "keyword": "Then "
});
formatter.match({
  "location": "TransferAmountCucumberTest.iInvokeTransactionHistoryAPI()"
});
formatter.result({
  "duration": 359850,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 32
    }
  ],
  "location": "TransferAmountCucumberTest.iReceivedResponseStatusCodeWithAllTransactionHistory(int)"
});
formatter.result({
  "duration": 30977275,
  "status": "passed"
});
});