package com.nuance.him.cucumbertest;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * Run All cucumber test.
 */
@RunWith(Cucumber.class)
@CucumberOptions(format = { "pretty", "html:target/cucumber" }, features = { "src/test/resources/Customer.feature" ,
    "src/test/resources/Account-positive.feature","src/test/resources/Atm.feature","src/test/resources/Account-negetive.feature","src/test/resources/TransferAmount.feature"}
    , glue = "com.nuance.him.cucumbertest")
public class RunCucumberTest {}
