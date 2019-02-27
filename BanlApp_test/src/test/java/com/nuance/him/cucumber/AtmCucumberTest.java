package com.nuance.him.cucumber;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionInterceptor;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import com.nuance.him.app.BankMainApp;
import com.nuance.him.config.DatabaseConfig;
import com.nuance.him.model.atm.AtmDetail;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.URI;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertNotNull;

/**
 * AtmCucumberTest class.
 */
@SpringBootTest(classes = BankMainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {BankMainApp.class,DatabaseConfig.class})
@Transactional
public class AtmCucumberTest {
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseUrl ="/bank";
    private ResponseEntity response;
    private RequestEntity request;
    private AtmDetail atmDetail;
    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionStatus transaction;

    /**
     * setup before scenario.
     */
    @Before()
    public void beforeScenario() {
        transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
        transaction.setRollbackOnly();
        TransactionInterceptor.currentTransactionStatus().setRollbackOnly();
    }

    /**
     * rollback after scenario.
     */
    @After
    public void afterScenario() {
        transactionManager.rollback(transaction);
        transactionManager.rollback(TransactionInterceptor.currentTransactionStatus());

    }

    /**
     * setup issueAtm input values.
     * @throws Throwable
     */
    @Given("^I use issueAtm$")
    public void iUseIssueAtm() throws Throwable {
        assertNotNull( "restTemplate null",testRestTemplate);
       atmDetail= new AtmDetail(123456,3,123,"visa");
    }

    /**
     * call Api.
     * @throws Throwable
     */
    @When("^I invoke /issueAtm API$")
    @Transactional
    public void iInvokeIssueAtmAPI() throws Throwable {
        assertNotNull("template should not null", testRestTemplate);
        response = testRestTemplate.postForEntity(new URI(baseUrl+"/issueAtm"), atmDetail, String.class);

    }

    /**
     * check status code of result should be 200.
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) with issue Atm successful message$")
    public void iReceivedResponseStatusCodeWithIssueAtmSuccessfulMessage(int arg0) throws Throwable {
        assertEquals(HttpStatus.CREATED, response.getStatusCode());

    }

    /**
     * initial setup for invalid data inputs.
     * @throws Throwable
     */
    @Given("^I use issueAtm for invalid account$")
    public void iUseIssueAtmForInvalidAccount() throws Throwable {
        atmDetail= new AtmDetail(123456,2,123,"visa");

    }

    /**
     * call Api for checking invalid account number.
     * @throws Throwable
     */
    @When("^I invoke /issueAtm API for invalid account number$")
    @Transactional
    public void iInvokeIssueAtmAPIForInvalidAccountNumber() throws Throwable {
        response = testRestTemplate.postForEntity(new URI(baseUrl+"/issueAtm"), atmDetail, String.class);

    }

    /**
     * check status code must return 404.
     * @param arg0
     * @throws Throwable
     */

    @Then("^I received response status code (\\d+) with Account not found message$")
    public void iReceivedResponseStatusCodeWithAccountNotFoundMessage(int arg0) throws Throwable {
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());

    }

    /**
     * initial setup to check is atmAlreadyTaken or not.
     * @throws Throwable
     */
    @Given("^I use issueAtm for  account already taken$")
    public void iUseIssueAtmForAccountAlreadyTaken() throws Throwable {
        atmDetail= new AtmDetail(123456,3,123,"visa");

    }

    /**
     * call Api .
     * @throws Throwable
     */
    @When("^I invoke /issueAtm API for  duplicate account number$")
    @Transactional
    public void iInvokeIssueAtmAPIForDuplicateAccountNumber() throws Throwable {
        response = testRestTemplate.postForEntity(new URI(baseUrl+"/issueAtm"), atmDetail, String.class);

    }

    @Then("^I received response status code (\\d+) with Account Already issue atm message$")
    public void iReceivedResponseStatusCodeWithAccountAlreadyIssueAtmMessage(int arg0) throws Throwable {
        assertEquals(HttpStatus.ALREADY_REPORTED, response.getStatusCode());

    }

    /**
     * call display all atm detail Api.
     * @throws Throwable
     */
    @When("^I invoke /displayAllAtm API$")
    public void iInvokeDisplayAllAtmAPI() throws Throwable {
        request = RequestEntity.get(new URI( baseUrl+ "/displayAllAtmDetail")).accept(MediaType.APPLICATION_JSON).build();
        response = testRestTemplate.exchange(request, String.class);
    }

    /**
     * receive list of atmDetail and status code 200.
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) withAll Atm details$")
    public void iReceivedResponseStatusCodeWithAllAtmDetails(int arg0) throws Throwable {
        assertEquals(HttpStatus.OK, response.getStatusCode());

    }

}
