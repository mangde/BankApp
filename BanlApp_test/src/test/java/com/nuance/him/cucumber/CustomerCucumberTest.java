package com.nuance.him.cucumber;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.web.util.UriComponentsBuilder;
import org.testng.AssertJUnit;
import com.nuance.him.app.BankMainApp;
import com.nuance.him.config.DatabaseConfig;
import com.nuance.him.model.customermodel.Customer;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.net.URI;
import static org.junit.Assert.assertNotNull;
import static org.springframework.http.RequestEntity.get;

/**
 * Customer cucumber test class.
 */
@SpringBootTest(classes = BankMainApp.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = { BankMainApp.class, DatabaseConfig.class })
@Transactional
public class CustomerCucumberTest {

    @Autowired
    private TestRestTemplate restTemplate;
    private ResponseEntity response;
    private RequestEntity request;
    private String bankUrl = "/bank";
    private Customer customer;
    private UriComponentsBuilder builder;
    private HttpEntity httpEntity;
    @Autowired
    private PlatformTransactionManager transactionManager;
    private TransactionStatus transaction;

    /**
     * before scenario setup transaction state.
     */
    @Before
    public void beforeScenario() {
        assertNotNull(transactionManager);
        transaction = transactionManager.getTransaction(new DefaultTransactionDefinition());
    }

    /**
     * after scenario rollback transaction.
     */
    @After
    public void afterScenario() {
        transactionManager.rollback(transaction);
    }

    /**
     * call getAllCustomer Api.
     *
     * @throws Throwable
     */
    @When("^I invoke getAllCustomer API$")
    public void callDisplayCustomers() throws Throwable {
        AssertJUnit.assertNotNull("restTemplate null", restTemplate);
        System.out.println(new URI(bankUrl + "/displayCustomer"));
        request = get(new URI(bankUrl + "/displayCustomer")).accept(MediaType.APPLICATION_JSON).build();
        response = restTemplate.exchange(request, String.class);
    }

    /**
     * to check list of customer return with status code 200.
     */
    @Then("^I received response status code 200 with all customer detail")
    public void getAllCustomersDetails() {
        AssertJUnit.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * setup for addCustomer data.
     *
     * @throws Throwable
     */
    @Given("^I use addCustomer with valid data$")
    public void iUseAddCustomerWithValidData() throws Throwable {
        customer = new Customer("Yogesh", 1234567898l, "jalna", "motibag");
    }

    /**
     * call /addCustomer Api.
     *
     * @throws Throwable
     */
    @When("^I invoke /addCustomer API$")
    public void iInvokeAddCustomerAPI() throws Throwable {
        response = restTemplate.postForEntity(new URI(bankUrl + "/addCustomer"), customer, String.class);
    }

    /**
     * check customer add succefully with status code 201.
     *
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) with register customer detail$")
    public void iReceivedResponseStatusCodeWithRegisterCustomerDetail(int arg0) throws Throwable {
        AssertJUnit.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    /**
     * call getAllCustomer with invalid url.
     *
     * @throws Throwable
     */
    @When("^I invoke getAllCustomer API with invalid url$")
    public void iInvokeGetAllCustomerAPIWithInvalidUrl() throws Throwable {
        AssertJUnit.assertNotNull("restTemplate null", restTemplate);
        request = get(new URI(bankUrl + "/dis123Customer")).accept(MediaType.APPLICATION_JSON).build();
        response = restTemplate.exchange(request, String.class);
    }

    /**
     * check status code 404 not found.
     *
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received message bad request with status code (\\d+)$")
    public void iReceivedMessageBadRequestWithStatusCode(int arg0) throws Throwable {
        AssertJUnit.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    /**
     * call getCustomerById Api.
     *
     * @throws Throwable
     */
    @When("^I invoke getCustomerById API$")
    public void iInvokeGetCustomerByIdAPI() throws Throwable {
        httpEntity = new HttpEntity(new HttpHeaders());
        builder = UriComponentsBuilder.fromUriString(bankUrl + "/getCustomerById").queryParam("customerId", 1);
        response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, httpEntity, String.class);
    }

    /**
     * received status 200 with customer details.
     *
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) with  customer detail$")
    public void iReceivedResponseStatusCodeWithCustomerDetail(int arg0) throws Throwable {
        AssertJUnit.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    /**
     * call Api with invalid customer data.
     *
     * @throws Throwable
     */
    @When("^I invoke getCustomerById API with invalid customerId$")
    public void iInvokeGetCustomerByIdAPIWithInvalidCustomerId() throws Throwable {
        httpEntity = new HttpEntity(new HttpHeaders());
        builder = UriComponentsBuilder.fromUriString(bankUrl + "/getCustomerById").queryParam("customerId", 0);
        response = restTemplate.exchange(builder.buildAndExpand().toUri(), HttpMethod.GET, httpEntity, String.class);
    }

    /**
     * receive 404 status code with customer not found message.
     *
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) with message  customer NOt found$")
    public void iReceivedResponseStatusCodeWithMessageCustomerNOtFound(int arg0) throws Throwable {
        AssertJUnit.assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }
}
