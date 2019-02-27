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
 * cucumber stepdefination class for customer testing.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = DatabaseConfig.class)
public class TransferAmountCucumberTest extends SpringAbstractRequestHandler{
    private HttpURLConnection connection;
    private JSONObject jsonObject;
    private final String baseUrl = "/bank";


    /**
     * setting a object value for transfer amount.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount$")
    public void iUseTransferAmount() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("accIdFrom",1 );
        jsonObject.put("accIdTo",3 );
        jsonObject.put("amount",50);
        jsonObject.put("description","loan" );
    }

    /**
     * call a /transferAmount url.
     * @throws Throwable exception
     */
    @When("^I invoke /transferAmount API$")
    public void iInvokeTransferAmountAPI() throws Throwable {
        connection = getConnection("POST", baseUrl + "/transferAmount", jsonObject);

    }

    /**
     * check the result of /transferAmount call with status 201.
     * @param arg0 arguments
     * @throws Throwable exception
     */
    @Then("^I received response status code (\\d+) with successful message$")
    public void iReceivedResponseStatusCodeWithSuccessfulMessage(int arg0) throws Throwable {
        assertEquals(201, connection.getResponseCode());
    }

    /**
     * setup wrong value for object.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount invalid account number$")
    public void iUseTransferAmountInvalidAccountNumber() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("accIdFrom",1 );
        jsonObject.put("accIdTo",2);
        jsonObject.put("amount",50);
        jsonObject.put("description","loan" );
    }

    /**
     * call Api.
     * @throws Throwable
     */
    @When("^I invoke /transferAmount API with invalid account number$")
    public void iInvokeTransferAmountAPIWithInvalidAccountNumber() throws Throwable {
        connection = getConnection("POST", baseUrl + "/transferAmount", jsonObject);
    }

    /**
     * check result if it show 417 status code
     * @param arg0
     * @throws Throwable exception
     */

    @Then("^I received response transfer amount failed with status code (\\d+)$")
    public void iReceivedResponseTransferAmountFailedWithStatusCode(int arg0) throws Throwable {
        assertEquals(417, connection.getResponseCode());
    }

    /**
     * setup transfer amount to check insufficient balance.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount when insufficient balance$")
    public void iUseTransferAmountWhenInsufficientBalance() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("accIdFrom",1 );
        jsonObject.put("accIdTo",3 );
        jsonObject.put("amount",50012);
        jsonObject.put("description","loan" );
    }

    /**
     * call Api /transferAmount.
     * @throws Throwable exception
     */

    @When("^I invoke /transferAmount when insufficient  account balance$")
    public void iInvokeTransferAmountWhenInsufficientAccountBalance() throws Throwable {
        connection = getConnection("POST", baseUrl + "/transferAmount", jsonObject);
    }

    /**
     * setup invalid account number exception.
     * @throws Throwable exception
     */
    @Given("^I use transferAmount invalid receiver account number$")
    public void iUseTransferAmountInvalidReceiverAccountNumber() throws Throwable {
        jsonObject = new JSONObject();
        jsonObject.put("accIdFrom",1 );
        jsonObject.put("accIdTo",2 );
        jsonObject.put("amount",50);
        jsonObject.put("description","loan" );
    }

    /**
     * call api /transferAmount.
     * @throws Throwable exception
     */
    @When("^when fail to deposite to receiver account$")
    public void whenFailToDepositeToReceiverAccount() throws Throwable {
        connection = getConnection("POST", baseUrl + "/transferAmount", jsonObject);
    }

    /**
     * received 417 status code Failed to transfer.
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^rollback transaction received response transfer amount failed with status code (\\d+)$")
    public void rollbackTransactionReceivedResponseTransferAmountFailedWithStatusCode(int arg0) throws Throwable {
        assertEquals(417, connection.getResponseCode());
    }

    /**
     * call to get all transaction history.
     * @throws Throwable exception
     */
    @When("^I invoke /transactionHistory API$")
    public void iInvokeTransactionHistoryAPI() throws Throwable {
        String param="?accNumber=1";
        connection = getConnection("GET", baseUrl + "/transactionHistory"+param , null);
    }

    /**
     * check to get list of transaction.
     * @param arg0
     * @throws Throwable exception
     */
    @Then("^I received response status code (\\d+) with all transaction History$")
    public void iReceivedResponseStatusCodeWithAllTransactionHistory(int arg0) throws Throwable {
        assertEquals(200, connection.getResponseCode());
    }
}
