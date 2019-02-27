package com.nuance.him.cucumbertest;

import org.json.JSONObject;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.testng.Assert;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * AtmCucumberTest class.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class AtmCucumberTest extends SpringAbstractRequestHandler {


    private final String baseUrl = "/bank";
    private JSONObject jsonObject;
    private String params;

    /**
     * setup issueAtm input values.
     *
     * @throws Throwable
     */
    @Given("^I use issueAtm$")
    public void iUseIssueAtm() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("atmNumber", 1236789);
        jsonObject.put("accNumber", 12);
        jsonObject.put("atmType", "visa");
        jsonObject.put("cvvNumber", 123);

    }

    /**
     * call Api.
     *
     * @throws Throwable
     */
    @When("^I invoke /issueAtm API$")
    public void iInvokeIssueAtmAPI() throws Throwable {
        connection = getConnection("POST", baseUrl + "/issueAtm", jsonObject);

    }

    /**
     * check status code of result should be 200.
     *
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) with issue Atm successful message$")
    public void iReceivedResponseStatusCodeWithIssueAtmSuccessfulMessage(int arg0) throws Throwable {
        Assert.assertEquals(connection.getResponseCode(),201);

    }

    /**
     * initial setup for invalid data inputs.
     *
     * @throws Throwable
     */
    @Given("^I use issueAtm for invalid account$")
    public void iUseIssueAtmForInvalidAccount() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("atmNumber", 123456);
        jsonObject.put("accNumber", 0);
        jsonObject.put("atmType", "visa");
        jsonObject.put("cvvNumber", 123);

    }

    /**
     * call Api for checking invalid account number.
     *
     * @throws Throwable
     */
    @When("^I invoke /issueAtm API for invalid account number$")
    public void iInvokeIssueAtmAPIForInvalidAccountNumber() throws Throwable {
        connection = getConnection("POST", baseUrl + "/issueAtm", jsonObject);

    }

    /**
     * check status code must return 404.
     *
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) with Account not found message$")
    public void iReceivedResponseStatusCodeWithAccountNotFoundMessage(int arg0) throws Throwable {
        Assert.assertEquals(404, connection.getResponseCode());

    }

    /**
     * initial setup to check is atmAlreadyTaken or not.
     *
     * @throws Throwable
     */
    @Given("^I use issueAtm for  account already taken$")
    public void iUseIssueAtmForAccountAlreadyTaken() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("atmNumber", 123456);
        jsonObject.put("accNumber", 3);
        jsonObject.put("atmType", "visa");
        jsonObject.put("cvvNumber", 123);

    }

    /**
     * call Api .
     *
     * @throws Throwable
     */
    @When("^I invoke /issueAtm API for  duplicate account number$")
    public void iInvokeIssueAtmAPIForDuplicateAccountNumber() throws Throwable {
        connection = getConnection("POST", baseUrl + "/issueAtm", jsonObject);

    }

    @Then("^I received response status code (\\d+) with Account Already issue atm message$")
    public void iReceivedResponseStatusCodeWithAccountAlreadyIssueAtmMessage(int arg0) throws Throwable {
        Assert.assertEquals(208, connection.getResponseCode());

    }

    /**
     * call display all atm detail Api.
     *
     * @throws Throwable
     */
    @When("^I invoke /displayAllAtm API$")
    public void iInvokeDisplayAllAtmAPI() throws Throwable {
        connection = getConnection("GET", baseUrl + "/displayAllAtmDetail", jsonObject);

    }

    /**
     * receive list of atmDetail and status code 200.
     *
     * @param arg0
     * @throws Throwable
     */
    @Then("^I received response status code (\\d+) withAll Atm details$")
    public void iReceivedResponseStatusCodeWithAllAtmDetails(int arg0) throws Throwable {
        Assert.assertEquals(200, connection.getResponseCode());

    }
}
