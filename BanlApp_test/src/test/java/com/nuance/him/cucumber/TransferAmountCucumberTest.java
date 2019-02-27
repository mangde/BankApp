package com.nuance.him.cucumber;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.util.UriComponentsBuilder;
import com.nuance.him.app.BankMainApp;
import com.nuance.him.config.DatabaseConfig;
import com.nuance.him.model.transaction.TransferAmount;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.URI;
import static org.junit.Assert.assertNotNull;

/**
 * cucumber stepdefination class for customer testing.
 */
@SpringBootTest(classes = BankMainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BankMainApp.class, DatabaseConfig.class})
@Transactional
public class TransferAmountCucumberTest {

    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseUrl = "/bank";
    private ResponseEntity response;
    private RequestEntity request;
    private TransferAmount transferAmount;
    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionStatus transaction;

    /**
     * initial setup before test.
     */
    @Before
    public void beforeScenario(){
        assertNotNull(transactionManager);
        transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    /**
     * rollback after test.
     */
    @After
    public void afterScenario(){
        transactionManager.rollback(transaction);
    }


    /**
     * setting a object value for transfer amount.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount$")
    public void iUseTransferAmount() throws Throwable {
        transferAmount = new TransferAmount(88, 1, 50, "loan");
    }

    /**
     * call a /transferAmount url.
     * @throws Throwable exception
     */
    @When("^I invoke /transferAmount API$")
    public void iInvokeTransferAmountAPI() throws Throwable {
        assertNotNull("template should not null", testRestTemplate);
        response = testRestTemplate.postForEntity(new URI(baseUrl + "/transferAmount"), transferAmount, String.class);
    }

    /**
     * check the result of /transferAmount call with status 201.
     * @param arg0 arguments
     * @throws Throwable exception
     */
    @Then("^I received response status code (\\d+) with successful message$")
    public void iReceivedResponseStatusCodeWithSuccessfulMessage(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        Assert.assertEquals(HttpStatus.CREATED, currentStatusCode);
    }

    /**
     * setup wrong value for object.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount invalid account number$")
    public void iUseTransferAmountInvalidAccountNumber() throws Throwable {
        transferAmount = new TransferAmount(1, 2, 50, "loan");
    }

    /**
     * call Api.
     * @throws Throwable
     */
    @When("^I invoke /transferAmount API with invalid account number$")
    public void iInvokeTransferAmountAPIWithInvalidAccountNumber() throws Throwable {
        response = testRestTemplate.postForEntity(new URI(baseUrl + "/transferAmount"), transferAmount, String.class);
    }

    /**
     * check result if it show 417 status code
     * @param arg0
     * @throws Throwable exception
     */

    @Then("^I received response transfer amount failed with status code (\\d+)$")
    public void iReceivedResponseTransferAmountFailedWithStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        Assert.assertEquals(HttpStatus.EXPECTATION_FAILED, currentStatusCode);
    }

    /**
     * setup transfer amount to check insufficient balance.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount when insufficient balance$")
    public void iUseTransferAmountWhenInsufficientBalance() throws Throwable {
        transferAmount = new TransferAmount(1, 3, 50000, "loan");
    }

    /**
     * call Api /transferAmount.
     * @throws Throwable exception
     */

    @When("^I invoke /transferAmount when insufficient  account balance$")
    public void iInvokeTransferAmountWhenInsufficientAccountBalance() throws Throwable {
        response = testRestTemplate.postForEntity(new URI(baseUrl + "/transferAmount"), transferAmount, String.class);
    }

    /**
     * setup invalid account number exception.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount invalid receiver account number$")
    public void iUseTransferAmountInvalidReceiverAccountNumber() throws Throwable {
        transferAmount = new TransferAmount(1, 2, 50, "loan");
    }

    /**
     * call api /transferAmount.
     * @throws Throwable exception
     */
    @When("^when fail to deposite to receiver account$")
    public void whenFailToDepositeToReceiverAccount() throws Throwable {
        response = testRestTemplate.postForEntity(new URI(baseUrl + "/transferAmount"), transferAmount, String.class);
    }

    /**
     * received 417 status code Failed to transfer.
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^rollback transaction received response transfer amount failed with status code (\\d+)$")
    public void rollbackTransactionReceivedResponseTransferAmountFailedWithStatusCode(int arg0) throws Throwable {
        HttpStatus currentStatusCode = response.getStatusCode();
        Assert.assertEquals(HttpStatus.EXPECTATION_FAILED, currentStatusCode);
    }

    /**
     * call to get all transaction history.
     * @throws Throwable exception
     */
    @When("^I invoke /transactionHistory API$")
    public void iInvokeTransactionHistoryAPI() throws Throwable {
        HttpEntity httpEntity = new HttpEntity(new HttpHeaders());
        UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(baseUrl + "/transactionHistory").queryParam("accNumber", 1);
        response = testRestTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, httpEntity, String.class);
    }

    /**
     * check to get list of transaction.
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received response status code (\\d+) with all transaction History$")
    public void iReceivedResponseStatusCodeWithAllTransactionHistory(int arg0) throws Throwable {
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
