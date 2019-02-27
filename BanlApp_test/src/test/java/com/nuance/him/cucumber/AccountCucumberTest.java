package com.nuance.him.cucumber;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.util.UriComponentsBuilder;
import org.testng.AssertJUnit;
import com.nuance.him.config.DatabaseConfig;
import com.nuance.him.model.accountmodel.Account;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.URI;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Account test class.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {DatabaseConfig.class})
public class AccountCucumberTest  {

    @Autowired
    private TestRestTemplate template;
    private final String baseUrl = "/bank";
    private ResponseEntity response;
    private Account account;
    private UriComponentsBuilder builder;
    private HttpEntity httpEntity;
    private int accNumber = 1;
    private double amount = 500.50;
    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionStatus transaction;

    /**
     * before execution of each scenario set transaction for rollback.
     */
    @Before
    public void beforeScenario() {
        assertNotNull(transactionManager);
        transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    /**
     * After scenario rollback transaction.
     */
    @After
    public void afterScenario() {
        transaction.setRollbackOnly();
        transactionManager.rollback(transaction);
    }

    /**
     * setup data for opeNewAccount.
     *
     * @throws Throwable handle exception
     */
    @Given("^I use openAccount$")
    public void iUseOpenAccount() throws Throwable {
        account = new Account("saving", 5015, 1);
    }

    /**
     * call /openAccount Api.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /openAccount API$")
    public void openAccount() throws Throwable {
        AssertJUnit.assertNotNull("template should not null", template);
        System.out.println(new URI(baseUrl + "/addAccount"));
        response = template.postForEntity(new URI(baseUrl + "/addAccount"), account, String.class);
    }

    /**
     * check status code 201 with successful to open account.
     *
     * @param args argument
     * @throws Throwable exception
     */
    @Then("^I received response status code (\\d+)$")
    public void receivesStatusCodeOf(int args) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.CREATED, currentStatusCode);
    }

    /**
     * call Api /deposite for deposite amount.
     *
     * @throws Exception exception
     */
    @When("^I invoke /deposite API$")
    public void depositeAmount() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpEntity = new HttpEntity(httpHeaders);
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/deposite").queryParam("accNumber", accNumber).queryParam("amount", amount);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.POST, httpEntity, String.class);
    }

    /**
     * receive status 200 with amount deposited message.
     *
     * @param ars argument
     * @throws Throwable exception
     */
    @Then("^I received new updated balance with response status code (\\d+)$")
    public void iReceivedNewUpdatedBalanceWithResponseStatusCode(int ars) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.OK, currentStatusCode);
    }

    /**
     * call /getBalance Api for check current available balance.
     *
     * @throws Exception exception
     */
    @When("^I invoke /getBalance API$")
    public void getCurrentBalance() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpEntity = new HttpEntity(httpHeaders);
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/getBalance").queryParam("accNumber", accNumber);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, httpEntity, String.class);
    }

    /**
     * check status code 200 with available balance.
     *
     * @param arg0 argument
     * @throws Throwable exception
     */
    @Then("^I received current available Balance with response status code (\\d+)$")
    public void iReceivedCurrentAvailableBalanceWithResponseStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.OK, currentStatusCode);
    }

    /**
     * call /withDraw api for withdraw amount.
     *
     * @throws Exception exception
     */
    @When("^I invoke /withDraw API$")
    public void withDraw() throws Exception {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpEntity = new HttpEntity(httpHeaders);
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/withDraw").queryParam("accNumber", accNumber).queryParam("amount", amount);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, httpEntity, String.class);
    }

    /**
     * received status code 200 with remaining balance amount
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received remaining balance with response status code (\\d+)$")
    public void iReceivedRemainingBalanceWithResponseStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.OK, currentStatusCode);
    }

    /**
     * call Api getAccountDetail for check account detail.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /getAccountDetail API$")
    public void iInvokeGetAccountDetailAPI() throws Throwable {
        httpEntity = new HttpEntity(new HttpHeaders());
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/accountDetail").queryParam("accNumber", accNumber);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, httpEntity, String.class);
    }

    /**
     * received account detail with status code 200.
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received AccountDetails  with response status code (\\d+)$")
    public void iReceivedAccountDetailsWithResponseStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.OK, currentStatusCode);
    }

    /**
     * check invalid customerID for openAccount.
     *
     * @throws Throwable exception
     */
    @Given("^I use openAccount with invalid customerId$")
    public void iUseOpenAccountWithInvalidCustomerId() throws Throwable {
        account = new Account("saving", 5015, 0);
    }

    /**
     * call /openAccount Api with invalid customer id
     *
     * @throws Throwable exception
     */
    @When("^I invoke /openAccount API with invalid CustomerId$")
    public void openAccountInvalid() throws Throwable {
        AssertJUnit.assertNotNull("template should not null", template);
        System.out.println(new URI(baseUrl + "/addAccount"));
        response = template.postForEntity(new URI(baseUrl + "/addAccount"), account, String.class);
    }

    /**
     * received status code 404 customer not found
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message Customer id not found status code (\\d+)$")
    public void iReceivedMessageCustomerIdNotFoundStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.NOT_FOUND, currentStatusCode);
    }

    /**
     * call deposite Amount with invalid account number.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /deposite API with invalid data$")
    public void iInvokeDepositeAPIWithInvalidData() throws Throwable {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpEntity = new HttpEntity(httpHeaders);
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/deposite").queryParam("accNumber", 0).queryParam("amount", amount);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.POST, httpEntity, String.class);
    }

    /**
     * received  status code 417 failed to deposite
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message failed to deposite amount with response status code (\\d+)$")
    public void iReceivedMessageFailedToDepositeAmountWithResponseStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.EXPECTATION_FAILED, currentStatusCode);
    }

    /**
     * received 404 status account not found.
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received Account Number not found with response status code (\\d+)$")
    public void iReceivedAccountNumberNotFoundWithResponseStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.NOT_FOUND, currentStatusCode);
    }

    /**
     * received service unavailable failed to withdraw amount.
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message failed to withdraw amount  with response status code (\\d+)$")
    public void iReceivedMessageFailedToWithdrawAmountWithResponseStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.SERVICE_UNAVAILABLE, currentStatusCode);
    }

    /**
     * received 404 status with account not found
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message account not found with response status code (\\d+)$")
    public void iReceivedMessageAccountNotFoundWithResponseStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.NOT_FOUND, currentStatusCode);
    }

    /**
     * call /getbalance Api with invalid account number.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /getBalance API with invalid accountNumber$")
    public void iInvokeGetBalanceAPIWithInvalidAccountNumber() throws Throwable {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpEntity = new HttpEntity(httpHeaders);
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/getBalance").queryParam("accNumber", -1);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, httpEntity, String.class);
    }

    /**
     * call api /withDraw Amount
     *
     * @throws Throwable exception
     */
    @When("^I invoke /withDraw API with invalid data$")
    public void iInvokeWithDrawAPIWithInvalidData() throws Throwable {
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        httpEntity = new HttpEntity(httpHeaders);
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/withDraw").queryParam("accNumber", 02454).queryParam("amount", amount);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.PUT, httpEntity, String.class);
    }

    /**
     * call /getAccountDetail Api with invalid account number.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /getAccountDetail API with invalid accountNumber$")
    public void iInvokeGetAccountDetailAPIWithInvalidAccountNumber() throws Throwable {
        httpEntity = new HttpEntity(new HttpHeaders());
        builder = UriComponentsBuilder.fromUriString(baseUrl + "/accountDetail").queryParam("accNumber", -1);
        response = template.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, httpEntity, String.class);
    }

    /**
     * setup invalid data for openAccount .
     *
     * @throws Throwable exception
     */
    @Given("^I use openAccount with invalid data inputs$")
    public void iUseOpenAccountWithInvalidDataInputs() throws Throwable {
        account = new Account("credit", 2584, 1);
    }

    /**
     * call /openAccount Api with invalid data.
     *
     * @throws Throwable exception
     */
    @When("^I invoke /openAccount API with invalid data inputs$")
    public void iInvokeOpenAccountAPIWithInvalidDataInputs() throws Throwable {
        AssertJUnit.assertNotNull("template should not null", template);
        System.out.println(new URI(baseUrl + "/addAccount"));
        response = template.postForEntity(new URI(baseUrl + "/addAccount"), account, String.class);
    }

    /**
     * failed to open account with status 417
     *
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received message failed to open account status code (\\d+)$")
    public void iReceivedMessageFailedToOpenAccountStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        assertEquals(HttpStatus.EXPECTATION_FAILED, currentStatusCode);
    }
}
