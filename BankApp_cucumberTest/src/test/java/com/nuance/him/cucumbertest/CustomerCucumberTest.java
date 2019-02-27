package com.nuance.him.cucumbertest;

import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.io.IOException;

/**
 * Customer cucumber test class.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class CustomerCucumberTest extends SpringAbstractRequestHandler {

    private ResponseEntity<String> response;
    private final String baseUrl = "/bank";
    private JSONObject jsonObject;
    private String params;

    /**
     * call getAllCustomer Api.
     *
     * @throws Throwable
     */
    @When("^I invoke getAllCustomer API$")
    public void callDisplayCustomers() throws Throwable {
        connection = getConnection("GET", baseUrl + "/displayCustomer", null);
    }

    /**
     * to check list of customer return with status code 200.
     */
    @Then("^I received response status code 200 with all customer detail")
    public void getAllCustomersDetails() throws IOException {
        Assert.assertEquals(200, connection.getResponseCode());
    }

    /**
     * setup for addCustomer data.
     *
     * @throws Throwable
     */
    @Given("^I use addCustomer with valid data$")
    public void iUseAddCustomerWithValidData() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("name", "yogesh");
        jsonObject.put("city", "pune");
        jsonObject.put("phone", 1234567898);
        jsonObject.put("address", "pune");
    }

    /**
     * call /addCustomer Api.
     *
     * @throws Throwable
     */
    @When("^I invoke /addCustomer API$")
    public void iInvokeAddCustomerAPI() throws Throwable {
        connection = getConnection("POST", baseUrl + "/addCustomer", jsonObject);
    }

    /**
     * check customer add succefully with status code 201.
     *
     * @param arg0 arguments
     * @throws Throwable exception handler
     */
    @Then("^I received response status code (\\d+) with register customer detail$")
    public void iReceivedResponseStatusCodeWithRegisterCustomerDetail(int arg0) throws Throwable {
        Assert.assertEquals(201, connection.getResponseCode());
    }

    /**
     * call getAllCustomer with invalid url.
     *
     * @throws Throwable Exception handling.
     */
    @When("^I invoke getAllCustomer API with invalid url$")
    public void iInvokeGetAllCustomerAPIWithInvalidUrl() throws Throwable {
        connection = getConnection("GET", baseUrl + "/displayCustomer2", jsonObject);
    }

    /**
     * check status code 404 not found.
     *
     * @param arg0 arguments
     * @throws Throwable exception handler.
     */
    @Then("^I received message bad request with status code (\\d+)$")
    public void iReceivedMessageBadRequestWithStatusCode(int arg0) throws Throwable {
        Assert.assertEquals(404, connection.getResponseCode());
    }

    /**
     * call getCustomerById Api.
     *
     * @throws Throwable
     */
    @When("^I invoke getCustomerById API$")
    public void iInvokeGetCustomerByIdAPI() throws Throwable {
        params = "?customerId=1";
        connection = getConnection("GET", baseUrl + "/getCustomerById" + params, jsonObject);
    }

    /**
     * received status 200 with customer details.
     *
     * @param arg0 arguments
     * @throws Throwable exception handler.
     */
    @Then("^I received response status code (\\d+) with  customer detail$")
    public void iReceivedResponseStatusCodeWithCustomerDetail(int arg0) throws Throwable {
        Assert.assertEquals(connection.getResponseCode(), 200);
    }

    /**
     * call Api with invalid customer data.
     *
     * @throws Throwable exception handler.
     */
    @When("^I invoke getCustomerById API with invalid customerId$")
    public void iInvokeGetCustomerByIdAPIWithInvalidCustomerId() throws Throwable {
        connection = getConnection("GET", baseUrl + "/getCustomerById" + params, jsonObject);
    }

    /**
     * receive 404 status code with customer not found message.
     *
     * @param arg0 arguments
     * @throws Throwable exception handler
     */
    @Then("^I received response status code (\\d+) with message  customer NOt found$")
    public void iReceivedResponseStatusCodeWithMessageCustomerNOtFound(int arg0) throws Throwable {
        Assert.assertEquals(404, connection.getResponseCode());
    }
}
