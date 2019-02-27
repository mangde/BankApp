package com.nuance.him.cucumbertest;

import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.HttpURLConnection;
import static org.junit.Assert.assertEquals;

/**
 * Account test class.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class AccountCucumberTestSteps extends SpringAbstractRequestHandler {

    private HttpURLConnection connection;
    private JSONObject jsonObject;
    private final String baseUrl = "/bank";
    private double amount = 500.50;
    private int customerId = 1;
    private String accType = "saving";
    private String params;

   /* @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionStatus transaction;

    *//**
     * initial setup before test.
     *//*
    @Before
    public void beforeScenario(){
        assertNotNull(transactionManager);
        transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
        transaction.setRollbackOnly();

    }

    *//**
     * rollback after test.
     *//*
    @After
    public void afterScenario(){
        transactionManager.rollback(transaction);
    }*/

    /**
     * setup data for opeNewAccount.
     *
     * @throws Throwable handle exception
     */
    @Given("^I use openAccount$")
    public void iUseOpenAccount() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("type", accType);
        jsonObject.put("amount", amount);
        jsonObject.put("customerId", customerId);
    }

    /**
     * call /openAccount Api.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /openAccount API$")
    public void openAccount() throws Throwable {
        connection = getConnection("POST", baseUrl + "/addAccount", jsonObject);
    }

    /**
     * check status code 201 with successful to open account.
     *
     * @param args argument
     * @throws Throwable exception
     */
    @Then("^I received response status code (\\d+)$")
    public void receivesStatusCodeOf(int args) throws Throwable {
        assertEquals(201, connection.getResponseCode());
    }

    /**
     * call Api /deposite for deposite amount.
     *
     * @throws Exception exception
     */
    @When("^I invoke /deposite API$")
    public void depositeAmount() throws Exception {
        params = "?accNumber=1&amount=500";
        connection = getConnection("PUT", baseUrl + "/deposite" + params, jsonObject);
    }

    /**
     * receive status 200 with amount deposited message.
     *
     * @param ars argument
     * @throws Throwable exception
     */
    @Then("^I received new updated balance with response status code (\\d+)$")
    public void iReceivedNewUpdatedBalanceWithResponseStatusCode(int ars) throws Throwable {
        assertEquals(200, connection.getResponseCode());
    }

    /**
     * call /getBalance Api for check current available balance.
     *
     * @throws Exception exception
     */
    @When("^I invoke /getBalance API$")
    public void getCurrentBalance() throws Exception {
        params = "?accNumber=3";
        connection = getConnection("GET", baseUrl + "/getBalance" + params, jsonObject);
    }

    /**
     * check status code 200 with available balance.
     *
     * @param arg0 argument
     * @throws Throwable exception
     */
    @Then("^I received current available Balance with response status code (\\d+)$")
    public void iReceivedCurrentAvailableBalanceWithResponseStatusCode(int arg0) throws Throwable {
        assertEquals(200, connection.getResponseCode());
    }

    /**
     * call /withDraw api for withdraw amount.
     *
     * @throws Exception exception
     */
    @When("^I invoke /withDraw API$")
    public void withDraw() throws Exception {
        params = "?accNumber=3&amount=5";
        connection = getConnection("PUT", baseUrl + "/withDraw" + params, jsonObject);
    }

    /**
     * received status code 200 with remaining balance amount
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received remaining balance with response status code (\\d+)$")
    public void iReceivedRemainingBalanceWithResponseStatusCode(int arg0) throws Throwable {
        assertEquals(200, connection.getResponseCode());
    }

    /**
     * call Api getAccountDetail for check account detail.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /getAccountDetail API$")
    public void iInvokeGetAccountDetailAPI() throws Throwable {
        params = "?accNumber=3";
        connection = getConnection("GET", baseUrl + "/accountDetail" + params, jsonObject);
    }

    /**
     * received account detail with status code 200.
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received AccountDetails  with response status code (\\d+)$")
    public void iReceivedAccountDetailsWithResponseStatusCode(int arg0) throws Throwable {
        assertEquals(200, connection.getResponseCode());
    }

    /**
     * check invalid customerID for openAccount.
     *
     * @throws Throwable exception
     */
    @Given("^I use openAccount with invalid customerId$")
    public void iUseOpenAccountWithInvalidCustomerId() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("type", accType);
        jsonObject.put("balance", amount);
        jsonObject.put("customerId", 0);
    }

    /**
     * call /openAccount Api with invalid customer id
     *
     * @throws Throwable exception
     */
    @When("^I invoke /openAccount API with invalid CustomerId$")
    public void openAccountInvalid() throws Throwable {
        connection = getConnection("POST", baseUrl + "/addAccount", jsonObject);
    }

    /**
     * received status code 404 customer not found
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message Customer id not found status code (\\d+)$")
    public void iReceivedMessageCustomerIdNotFoundStatusCode(int arg0) throws Throwable {
        assertEquals(404, connection.getResponseCode());
    }

    /**
     * call deposite Amount with invalid account number.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /deposite API with invalid data$")
    public void iInvokeDepositeAPIWithInvalidData() throws Throwable {
        params = "?accNumber=0&amount=500";
        connection = getConnection("PUT", baseUrl + "/deposite" + params, jsonObject);
    }

    /**
     * received  status code 417 failed to deposite
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message failed to deposite amount with response status code (\\d+)$")
    public void iReceivedMessageFailedToDepositeAmountWithResponseStatusCode(int arg0) throws Throwable {
        assertEquals(417, connection.getResponseCode());
    }

    /**
     * call /getbalance Api with invalid account number.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /getBalance API with invalid accountNumber$")
    public void iInvokeGetBalanceAPIWithInvalidAccountNumber() throws Throwable {
        params = "?accNumber=0";
        connection = getConnection("GET", baseUrl + "/getBalance" + params, jsonObject);
    }

    /**
     * received 404 status account not found.
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received Account Number not found with response status code (\\d+)$")
    public void iReceivedAccountNumberNotFoundWithResponseStatusCode(int arg0) throws Throwable {
        assertEquals(404, connection.getResponseCode());
    }

    /**
     * call api /withDraw Amount
     *
     * @throws Throwable exception
     */
    @When("^I invoke /withDraw API with invalid data$")
    public void iInvokeWithDrawAPIWithInvalidData() throws Throwable {
        params = "?accNumber=0&amount=5";
        connection = getConnection("PUT", baseUrl + "/withDraw" + params, jsonObject);
    }

    /**
     * received service unavailable failed to withdraw amount.
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message failed to withdraw amount  with response status code (\\d+)$")
    public void iReceivedMessageFailedToWithdrawAmountWithResponseStatusCode(int arg0) throws Throwable {
        assertEquals(503, connection.getResponseCode());
    }

    /**
     * call /getAccountDetail Api with invalid account number.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /getAccountDetail API with invalid accountNumber$")
    public void iInvokeGetAccountDetailAPIWithInvalidAccountNumber() throws Throwable {
        params = "?accNumber=0";
        connection = getConnection("GET", baseUrl + "/accountDetail" + params, jsonObject);
    }

    /**
     * received 404 status with account not found
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message account not found with response status code (\\d+)$")
    public void iReceivedMessageAccountNotFoundWithResponseStatusCode(int arg0) throws Throwable {
        assertEquals(404, connection.getResponseCode());
    }

    /**
     * setup invalid data for openAccount .
     *
     * @throws Throwable exception
     */
    @Given("^I use openAccount with invalid data inputs$")
    public void iUseOpenAccountWithInvalidDataInputs() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("type", "credit");
        jsonObject.put("balance", amount);
        jsonObject.put("customerId", 1);
    }

    /**
     * call /openAccount Api with invalid data.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /openAccount API with invalid data inputs$")
    public void iInvokeOpenAccountAPIWithInvalidDataInputs() throws Throwable {
        connection = getConnection("POST", baseUrl + "/addAccount", jsonObject);
    }

    /**
     * failed to open account with status 417
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message failed to open account status code (\\d+)$")
    public void iReceivedMessageFailedToOpenAccountStatusCode(int arg0) throws Throwable {
        assertEquals(417, connection.getResponseCode());
    }
}
