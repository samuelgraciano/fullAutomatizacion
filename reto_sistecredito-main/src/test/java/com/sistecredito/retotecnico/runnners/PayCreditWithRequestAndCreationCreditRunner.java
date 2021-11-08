package com.sistecredito.retotecnico.runnners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import net.serenitybdd.junit.runners.SerenityRunner;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/pay_credit_with_request_and_creation_credit.feature",
        glue = "com.sistecredito.retotecnico.stepdefinitions",
        snippets = SnippetType.CAMELCASE)
public class PayCreditWithRequestAndCreationCreditRunner {
}
