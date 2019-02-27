$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/Account-negetive.feature");
formatter.feature({
  "line": 1,
  "name": "Negetive scenarios for the BankAppConfiguration Account service",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service",
  "keyword": "Feature"
});
formatter.before({
  "duration": 27741734,
  "status": "passed"
});
formatter.before({
  "duration": 5418590,
  "status": "passed"
});
formatter.before({
  "duration": 2812864,
  "status": "passed"
});
formatter.before({
  "duration": 2828104,
  "status": "passed"
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
  "location": "AccountCucumberTest.iUseOpenAccountWithInvalidCustomerId()"
});
formatter.result({
  "duration": 104453246,
  "status": "passed"
});
formatter.match({
  "location": "AccountCucumberTest.openAccountInvalid()"
});
formatter.result({
  "duration": 493399224,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 53
    }
  ],
  "location": "AccountCucumberTest.iReceivedMessageCustomerIdNotFoundStatusCode(int)"
});
formatter.result({
  "duration": 2546320,
  "status": "passed"
});
formatter.after({
  "duration": 1164459,
  "status": "passed"
});
formatter.after({
  "duration": 150844,
  "status": "passed"
});
formatter.after({
  "duration": 86153,
  "status": "passed"
});
formatter.after({
  "duration": 22393,
  "status": "passed"
});
formatter.before({
  "duration": 17364865,
  "status": "passed"
});
formatter.before({
  "duration": 526868,
  "status": "passed"
});
formatter.before({
  "duration": 167640,
  "status": "passed"
});
formatter.before({
  "duration": 165152,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "get 404 NotFound exception -\u003e with invalid data inputs",
  "description": "",
  "id": "negetive-scenarios-for-the-bankappconfiguration-account-service;get-404-notfound-exception--\u003e-with-invalid-data-inputs",
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
  "location": "AccountCucumberTest.iUseOpenAccountWithInvalidDataInputs()"
});
formatter.result({
  "duration": 40122,
  "status": "passed"
});
formatter.match({
  "location": "AccountCucumberTest.iInvokeOpenAccountAPIWithInvalidDataInputs()"
});
formatter.result({
  "duration": 39037045,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 54
    }
  ],
  "location": "AccountCucumberTest.iReceivedMessageFailedToOpenAccountStatusCode(int)"
});
formatter.result({
  "duration": 92062,
  "status": "passed"
});
formatter.after({
  "duration": 529356,
  "status": "passed"
});
formatter.after({
  "duration": 24260,
  "status": "passed"
});
formatter.after({
  "duration": 15551,
  "status": "passed"
});
formatter.after({
  "duration": 14618,
  "status": "passed"
});
formatter.before({
  "duration": 12782919,
  "status": "passed"
});
formatter.before({
  "duration": 266544,
  "status": "passed"
});
formatter.before({
  "duration": 132494,
  "status": "passed"
});
formatter.before({
  "duration": 140892,
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
  "location": "AccountCucumberTest.iInvokeDepositeAPIWithInvalidData()"
});
formatter.result({
  "duration": 48143397,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 71
    }
  ],
  "location": "AccountCucumberTest.iReceivedMessageFailedToDepositeAmountWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 100771,
  "status": "passed"
});
formatter.after({
  "duration": 1371909,
  "status": "passed"
});
formatter.after({
  "duration": 39811,
  "status": "passed"
});
formatter.after({
  "duration": 16484,
  "status": "passed"
});
formatter.after({
  "duration": 13685,
  "status": "passed"
});
formatter.before({
  "duration": 13925296,
  "status": "passed"
});
formatter.before({
  "duration": 291426,
  "status": "passed"
});
formatter.before({
  "duration": 133738,
  "status": "passed"
});
formatter.before({
  "duration": 131562,
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
  "location": "AccountCucumberTest.iInvokeGetBalanceAPIWithInvalidAccountNumber()"
});
formatter.result({
  "duration": 20683758,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 62
    }
  ],
  "location": "AccountCucumberTest.iReceivedAccountNumberNotFoundWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 104503,
  "status": "passed"
});
formatter.after({
  "duration": 1925524,
  "status": "passed"
});
formatter.after({
  "duration": 41054,
  "status": "passed"
});
formatter.after({
  "duration": 189722,
  "status": "passed"
});
formatter.after({
  "duration": 20528,
  "status": "passed"
});
formatter.before({
  "duration": 26221158,
  "status": "passed"
});
formatter.before({
  "duration": 283650,
  "status": "passed"
});
formatter.before({
  "duration": 148667,
  "status": "passed"
});
formatter.before({
  "duration": 119121,
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
  "location": "AccountCucumberTest.iInvokeWithDrawAPIWithInvalidData()"
});
formatter.result({
  "duration": 20396065,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "503",
      "offset": 72
    }
  ],
  "location": "AccountCucumberTest.iReceivedMessageFailedToWithdrawAmountWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 97350,
  "status": "passed"
});
formatter.after({
  "duration": 850951,
  "status": "passed"
});
formatter.after({
  "duration": 44787,
  "status": "passed"
});
formatter.after({
  "duration": 17106,
  "status": "passed"
});
formatter.after({
  "duration": 14618,
  "status": "passed"
});
formatter.before({
  "duration": 17114494,
  "status": "passed"
});
formatter.before({
  "duration": 268721,
  "status": "passed"
});
formatter.before({
  "duration": 127208,
  "status": "passed"
});
formatter.before({
  "duration": 114766,
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
  "location": "AccountCucumberTest.iInvokeGetAccountDetailAPIWithInvalidAccountNumber()"
});
formatter.result({
  "duration": 20716105,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "404",
      "offset": 63
    }
  ],
  "location": "AccountCucumberTest.iReceivedMessageAccountNotFoundWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 83976,
  "status": "passed"
});
formatter.after({
  "duration": 2021629,
  "status": "passed"
});
formatter.after({
  "duration": 41676,
  "status": "passed"
});
formatter.after({
  "duration": 16484,
  "status": "passed"
});
formatter.after({
  "duration": 13063,
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
formatter.before({
  "duration": 21470328,
  "status": "passed"
});
formatter.before({
  "duration": 272142,
  "status": "passed"
});
formatter.before({
  "duration": 119431,
  "status": "passed"
});
formatter.before({
  "duration": 128763,
  "status": "passed"
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
  "location": "AccountCucumberTest.iUseOpenAccount()"
});
formatter.result({
  "duration": 23949,
  "status": "passed"
});
formatter.match({
  "location": "AccountCucumberTest.openAccount()"
});
formatter.result({
  "duration": 56441410,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "201",
      "offset": 32
    }
  ],
  "location": "AccountCucumberTest.receivesStatusCodeOf(int)"
});
formatter.result({
  "duration": 97349,
  "status": "passed"
});
formatter.after({
  "duration": 4711641,
  "status": "passed"
});
formatter.after({
  "duration": 44475,
  "status": "passed"
});
formatter.after({
  "duration": 14929,
  "status": "passed"
});
formatter.after({
  "duration": 77133,
  "status": "passed"
});
formatter.before({
  "duration": 26235775,
  "status": "passed"
});
formatter.before({
  "duration": 342744,
  "status": "passed"
});
formatter.before({
  "duration": 139026,
  "status": "passed"
});
formatter.before({
  "duration": 127207,
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
  "location": "AccountCucumberTest.depositeAmount()"
});
formatter.result({
  "duration": 50824701,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 57
    }
  ],
  "location": "AccountCucumberTest.iReceivedNewUpdatedBalanceWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 101392,
  "status": "passed"
});
formatter.after({
  "duration": 983445,
  "status": "passed"
});
formatter.after({
  "duration": 43232,
  "status": "passed"
});
formatter.after({
  "duration": 14618,
  "status": "passed"
});
formatter.after({
  "duration": 21150,
  "status": "passed"
});
formatter.before({
  "duration": 16374888,
  "status": "passed"
});
formatter.before({
  "duration": 297335,
  "status": "passed"
});
formatter.before({
  "duration": 179458,
  "status": "passed"
});
formatter.before({
  "duration": 128452,
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
  "location": "AccountCucumberTest.getCurrentBalance()"
});
formatter.result({
  "duration": 67268324,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 63
    }
  ],
  "location": "AccountCucumberTest.iReceivedCurrentAvailableBalanceWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 102014,
  "status": "passed"
});
formatter.after({
  "duration": 1352315,
  "status": "passed"
});
formatter.after({
  "duration": 50696,
  "status": "passed"
});
formatter.after({
  "duration": 23016,
  "status": "passed"
});
formatter.after({
  "duration": 16795,
  "status": "passed"
});
formatter.before({
  "duration": 16707369,
  "status": "passed"
});
formatter.before({
  "duration": 340878,
  "status": "passed"
});
formatter.before({
  "duration": 172927,
  "status": "passed"
});
formatter.before({
  "duration": 136227,
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
  "location": "AccountCucumberTest.withDraw()"
});
formatter.result({
  "duration": 43297085,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 55
    }
  ],
  "location": "AccountCucumberTest.iReceivedRemainingBalanceWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 106369,
  "status": "passed"
});
formatter.after({
  "duration": 1431936,
  "status": "passed"
});
formatter.after({
  "duration": 73712,
  "status": "passed"
});
formatter.after({
  "duration": 100149,
  "status": "passed"
});
formatter.after({
  "duration": 50697,
  "status": "passed"
});
formatter.before({
  "duration": 13583174,
  "status": "passed"
});
formatter.before({
  "duration": 274009,
  "status": "passed"
});
formatter.before({
  "duration": 111034,
  "status": "passed"
});
formatter.before({
  "duration": 222069,
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
  "location": "AccountCucumberTest.iInvokeGetAccountDetailAPI()"
});
formatter.result({
  "duration": 17470301,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 53
    }
  ],
  "location": "AccountCucumberTest.iReceivedAccountDetailsWithResponseStatusCode(int)"
});
formatter.result({
  "duration": 87396,
  "status": "passed"
});
formatter.after({
  "duration": 937725,
  "status": "passed"
});
formatter.after({
  "duration": 41366,
  "status": "passed"
});
formatter.after({
  "duration": 29547,
  "status": "passed"
});
formatter.after({
  "duration": 23638,
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
formatter.before({
  "duration": 15453647,
  "status": "passed"
});
formatter.before({
  "duration": 303555,
  "status": "passed"
});
formatter.before({
  "duration": 143691,
  "status": "passed"
});
formatter.before({
  "duration": 117566,
  "status": "passed"
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
  "duration": 149601,
  "status": "passed"
});
formatter.match({
  "location": "AtmCucumberTest.iInvokeIssueAtmAPI()"
});
formatter.result({
  "duration": 55801642,
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
  "duration": 519403,
  "error_message": "java.lang.AssertionError: expected:\u003c200 OK\u003e but was:\u003c201 CREATED\u003e\r\n\tat org.testng.AssertJUnit.fail(AssertJUnit.java:59)\r\n\tat org.testng.AssertJUnit.failNotEquals(AssertJUnit.java:364)\r\n\tat org.testng.AssertJUnit.assertEquals(AssertJUnit.java:80)\r\n\tat org.testng.AssertJUnit.assertEquals(AssertJUnit.java:88)\r\n\tat com.nuance.him.cucumber.AtmCucumberTest.iReceivedResponseStatusCodeWithIssueAtmSuccessfulMessage(AtmCucumberTest.java:89)\r\n\tat ✽.Then I received response status code 201 with issue Atm successful message(src/test/resources/Atm.feature:6)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 990598,
  "status": "passed"
});
formatter.after({
  "duration": 44787,
  "status": "passed"
});
formatter.after({
  "duration": 41054,
  "status": "passed"
});
formatter.after({
  "duration": 23637,
  "status": "passed"
});
formatter.before({
  "duration": 12907017,
  "status": "passed"
});
formatter.before({
  "duration": 266233,
  "status": "passed"
});
formatter.before({
  "duration": 165151,
  "status": "passed"
});
formatter.before({
  "duration": 202163,
  "status": "passed"
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
  "duration": 26437,
  "status": "passed"
});
formatter.match({
  "location": "AtmCucumberTest.iInvokeIssueAtmAPIForInvalidAccountNumber()"
});
formatter.result({
  "duration": 21377955,
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
  "duration": 86463,
  "status": "passed"
});
formatter.after({
  "duration": 504475,
  "status": "passed"
});
formatter.after({
  "duration": 33590,
  "status": "passed"
});
formatter.after({
  "duration": 21771,
  "status": "passed"
});
formatter.after({
  "duration": 15862,
  "status": "passed"
});
formatter.before({
  "duration": 12256985,
  "status": "passed"
});
formatter.before({
  "duration": 257214,
  "status": "passed"
});
formatter.before({
  "duration": 118809,
  "status": "passed"
});
formatter.before({
  "duration": 132806,
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
  "name": "I received response status code 417 with Account not issue atm message",
  "keyword": "Then "
});
formatter.match({
  "location": "AtmCucumberTest.iUseIssueAtmForAccountAlreadyTaken()"
});
formatter.result({
  "duration": 32657,
  "status": "passed"
});
formatter.match({
  "location": "AtmCucumberTest.iInvokeIssueAtmAPIForDuplicateAccountNumber()"
});
formatter.result({
  "duration": 35165780,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 32
    }
  ],
  "location": "AtmCucumberTest.iReceivedResponseStatusCodeWithAccountNotIssueAtmMessage(int)"
});
formatter.result({
  "duration": 230466,
  "error_message": "java.lang.AssertionError: expected:\u003c417 EXPECTATION_FAILED\u003e but was:\u003c201 CREATED\u003e\r\n\tat org.testng.AssertJUnit.fail(AssertJUnit.java:59)\r\n\tat org.testng.AssertJUnit.failNotEquals(AssertJUnit.java:364)\r\n\tat org.testng.AssertJUnit.assertEquals(AssertJUnit.java:80)\r\n\tat org.testng.AssertJUnit.assertEquals(AssertJUnit.java:88)\r\n\tat com.nuance.him.cucumber.AtmCucumberTest.iReceivedResponseStatusCodeWithAccountNotIssueAtmMessage(AtmCucumberTest.java:152)\r\n\tat ✽.Then I received response status code 417 with Account not issue atm message(src/test/resources/Atm.feature:16)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 725921,
  "status": "passed"
});
formatter.after({
  "duration": 32035,
  "status": "passed"
});
formatter.after({
  "duration": 13373,
  "status": "passed"
});
formatter.after({
  "duration": 13374,
  "status": "passed"
});
formatter.before({
  "duration": 13158943,
  "status": "passed"
});
formatter.before({
  "duration": 259702,
  "status": "passed"
});
formatter.before({
  "duration": 110412,
  "status": "passed"
});
formatter.before({
  "duration": 99216,
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
  "duration": 35202170,
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
  "duration": 82731,
  "status": "passed"
});
formatter.after({
  "duration": 485191,
  "status": "passed"
});
formatter.after({
  "duration": 25503,
  "status": "passed"
});
formatter.after({
  "duration": 14617,
  "status": "passed"
});
formatter.after({
  "duration": 12130,
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
formatter.before({
  "duration": 14738301,
  "status": "passed"
});
formatter.before({
  "duration": 701972,
  "status": "passed"
});
formatter.before({
  "duration": 412412,
  "status": "passed"
});
formatter.before({
  "duration": 386909,
  "status": "passed"
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
  "duration": 59405,
  "status": "passed"
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeAddCustomerAPI()"
});
formatter.result({
  "duration": 47332880,
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
  "duration": 96727,
  "status": "passed"
});
formatter.after({
  "duration": 727165,
  "status": "passed"
});
formatter.after({
  "duration": 278985,
  "status": "passed"
});
formatter.after({
  "duration": 151778,
  "status": "passed"
});
formatter.after({
  "duration": 323461,
  "status": "passed"
});
formatter.before({
  "duration": 15117746,
  "status": "passed"
});
formatter.before({
  "duration": 860281,
  "status": "passed"
});
formatter.before({
  "duration": 221758,
  "status": "passed"
});
formatter.before({
  "duration": 119742,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "makes call to register a customer -\u003einvalid dataInputs",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-register-a-customer--\u003einvalid-datainputs",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 9,
  "name": "I use addCustomer with invalid data",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "I invoke /addCustomer API for invalid data",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I received  status code 417 with message fail to register customer",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iUseAddCustomerWithInvalidData()"
});
formatter.result({
  "duration": 43543,
  "status": "passed"
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeAddCustomerAPIForInvalidData()"
});
formatter.result({
  "duration": 35934621,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "417",
      "offset": 24
    }
  ],
  "location": "CustomerCucumberTest.iReceivedStatusCodeWithMessageFailToRegisterCustomer(int)"
});
formatter.result({
  "duration": 225490,
  "error_message": "java.lang.AssertionError: expected:\u003c417 EXPECTATION_FAILED\u003e but was:\u003c201 CREATED\u003e\r\n\tat org.testng.AssertJUnit.fail(AssertJUnit.java:59)\r\n\tat org.testng.AssertJUnit.failNotEquals(AssertJUnit.java:364)\r\n\tat org.testng.AssertJUnit.assertEquals(AssertJUnit.java:80)\r\n\tat org.testng.AssertJUnit.assertEquals(AssertJUnit.java:88)\r\n\tat com.nuance.him.cucumber.CustomerCucumberTest.iReceivedStatusCodeWithMessageFailToRegisterCustomer(CustomerCucumberTest.java:151)\r\n\tat ✽.Then I received  status code 417 with message fail to register customer(src/test/resources/Customer.feature:11)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 514427,
  "status": "passed"
});
formatter.after({
  "duration": 31725,
  "status": "passed"
});
formatter.after({
  "duration": 19283,
  "status": "passed"
});
formatter.after({
  "duration": 18972,
  "status": "passed"
});
formatter.before({
  "duration": 18762278,
  "status": "passed"
});
formatter.before({
  "duration": 253170,
  "status": "passed"
});
formatter.before({
  "duration": 109479,
  "status": "passed"
});
formatter.before({
  "duration": 92373,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "makes call to getAllCustomer Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-getallcustomer-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 15,
  "name": "I invoke getAllCustomer API",
  "keyword": "When "
});
formatter.step({
  "line": 16,
  "name": "I received response status code 200 with all customer detail",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.callDisplayCustomers()"
});
formatter.result({
  "duration": 22083660,
  "status": "passed"
});
formatter.match({
  "location": "CustomerCucumberTest.getAllCustomersDetails()"
});
formatter.result({
  "duration": 45720,
  "status": "passed"
});
formatter.after({
  "duration": 533710,
  "status": "passed"
});
formatter.after({
  "duration": 69979,
  "status": "passed"
});
formatter.after({
  "duration": 13063,
  "status": "passed"
});
formatter.after({
  "duration": 16795,
  "status": "passed"
});
formatter.before({
  "duration": 34955219,
  "status": "passed"
});
formatter.before({
  "duration": 253170,
  "status": "passed"
});
formatter.before({
  "duration": 147735,
  "status": "passed"
});
formatter.before({
  "duration": 129073,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "makes call to getAllCustomer Configuration with -\u003einvalid url",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-getallcustomer-configuration-with--\u003einvalid-url",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 20,
  "name": "I invoke getAllCustomer API with invalid url",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "I received message bad request with status code 400",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeGetAllCustomerAPIWithInvalidUrl()"
});
formatter.result({
  "duration": 20897740,
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
  "duration": 87085,
  "status": "passed"
});
formatter.after({
  "duration": 998996,
  "status": "passed"
});
formatter.after({
  "duration": 37322,
  "status": "passed"
});
formatter.after({
  "duration": 28924,
  "status": "passed"
});
formatter.after({
  "duration": 31724,
  "status": "passed"
});
formatter.before({
  "duration": 13099226,
  "status": "passed"
});
formatter.before({
  "duration": 266544,
  "status": "passed"
});
formatter.before({
  "duration": 107302,
  "status": "passed"
});
formatter.before({
  "duration": 168572,
  "status": "passed"
});
formatter.scenario({
  "line": 24,
  "name": "makes call to getCustomerById Configuration",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to-getcustomerbyid-configuration",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 25,
  "name": "I invoke getCustomerById API",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "I received response status code 200 with  customer detail",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeGetCustomerByIdAPI()"
});
formatter.result({
  "duration": 25023109,
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
  "duration": 103570,
  "status": "passed"
});
formatter.after({
  "duration": 1827864,
  "status": "passed"
});
formatter.after({
  "duration": 37012,
  "status": "passed"
});
formatter.after({
  "duration": 11197,
  "status": "passed"
});
formatter.after({
  "duration": 17417,
  "status": "passed"
});
formatter.before({
  "duration": 18492623,
  "status": "passed"
});
formatter.before({
  "duration": 228600,
  "status": "passed"
});
formatter.before({
  "duration": 104192,
  "status": "passed"
});
formatter.before({
  "duration": 96416,
  "status": "passed"
});
formatter.scenario({
  "line": 28,
  "name": "makes call to  getCustomerById Configuration with -\u003einvalid customerId",
  "description": "",
  "id": "positive/negetive-scenarios-for-the-bankappconfiguration-customer-service;makes-call-to--getcustomerbyid-configuration-with--\u003einvalid-customerid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 29,
  "name": "I invoke getCustomerById API with invalid customerId",
  "keyword": "When "
});
formatter.step({
  "line": 30,
  "name": "I received response status code 404 with message  customer NOt found",
  "keyword": "Then "
});
formatter.match({
  "location": "CustomerCucumberTest.iInvokeGetCustomerByIdAPIWithInvalidCustomerId()"
});
formatter.result({
  "duration": 15812875,
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
  "duration": 88640,
  "status": "passed"
});
formatter.after({
  "duration": 748314,
  "status": "passed"
});
formatter.after({
  "duration": 19906,
  "status": "passed"
});
formatter.after({
  "duration": 11197,
  "status": "passed"
});
formatter.after({
  "duration": 19905,
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
formatter.before({
  "duration": 16106790,
  "status": "passed"
});
formatter.before({
  "duration": 238241,
  "status": "passed"
});
formatter.before({
  "duration": 145868,
  "status": "passed"
});
formatter.before({
  "duration": 93306,
  "status": "passed"
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
  "duration": 53185,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.iInvokeTransferAmountAPI()"
});
formatter.result({
  "duration": 80492270,
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
  "duration": 107302,
  "status": "passed"
});
formatter.after({
  "duration": 690464,
  "status": "passed"
});
formatter.after({
  "duration": 28925,
  "status": "passed"
});
formatter.after({
  "duration": 11508,
  "status": "passed"
});
formatter.after({
  "duration": 10886,
  "status": "passed"
});
formatter.before({
  "duration": 16914197,
  "status": "passed"
});
formatter.before({
  "duration": 338390,
  "status": "passed"
});
formatter.before({
  "duration": 178526,
  "status": "passed"
});
formatter.before({
  "duration": 157687,
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
  "duration": 37011,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.iInvokeTransferAmountAPIWithInvalidAccountNumber()"
});
formatter.result({
  "duration": 25560241,
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
  "duration": 680201,
  "status": "passed"
});
formatter.after({
  "duration": 3786667,
  "status": "passed"
});
formatter.after({
  "duration": 49141,
  "status": "passed"
});
formatter.after({
  "duration": 141825,
  "status": "passed"
});
formatter.after({
  "duration": 55361,
  "status": "passed"
});
formatter.before({
  "duration": 15383357,
  "status": "passed"
});
formatter.before({
  "duration": 332792,
  "status": "passed"
});
formatter.before({
  "duration": 177281,
  "status": "passed"
});
formatter.before({
  "duration": 156443,
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
  "duration": 37944,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.iInvokeTransferAmountWhenInsufficientAccountBalance()"
});
formatter.result({
  "duration": 44172295,
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
  "duration": 98904,
  "status": "passed"
});
formatter.after({
  "duration": 11685019,
  "status": "passed"
});
formatter.after({
  "duration": 56606,
  "status": "passed"
});
formatter.after({
  "duration": 26126,
  "status": "passed"
});
formatter.after({
  "duration": 18661,
  "status": "passed"
});
formatter.before({
  "duration": 36922731,
  "status": "passed"
});
formatter.before({
  "duration": 252859,
  "status": "passed"
});
formatter.before({
  "duration": 111657,
  "status": "passed"
});
formatter.before({
  "duration": 229843,
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
  "duration": 54117,
  "status": "passed"
});
formatter.match({
  "location": "TransferAmountCucumberTest.whenFailToDepositeToReceiverAccount()"
});
formatter.result({
  "duration": 37254901,
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
  "duration": 100459,
  "status": "passed"
});
formatter.after({
  "duration": 1277048,
  "status": "passed"
});
formatter.after({
  "duration": 33902,
  "status": "passed"
});
formatter.after({
  "duration": 12130,
  "status": "passed"
});
formatter.after({
  "duration": 52562,
  "status": "passed"
});
formatter.before({
  "duration": 11215690,
  "status": "passed"
});
formatter.before({
  "duration": 243218,
  "status": "passed"
});
formatter.before({
  "duration": 92373,
  "status": "passed"
});
formatter.before({
  "duration": 88019,
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
  "duration": 29225922,
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
  "duration": 83665,
  "status": "passed"
});
formatter.after({
  "duration": 468396,
  "status": "passed"
});
formatter.after({
  "duration": 18350,
  "status": "passed"
});
formatter.after({
  "duration": 11819,
  "status": "passed"
});
formatter.after({
  "duration": 9642,
  "status": "passed"
});
});