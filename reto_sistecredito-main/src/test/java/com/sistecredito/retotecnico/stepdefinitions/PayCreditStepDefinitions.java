package com.sistecredito.retotecnico.stepdefinitions;

import com.sistecredito.retotecnico.drivers.MyChromeDriver;
import com.sistecredito.retotecnico.interactions.WaitSeconds;
import com.sistecredito.retotecnico.models.Client;
import com.sistecredito.retotecnico.models.Credit;
import com.sistecredito.retotecnico.models.Payment;
import com.sistecredito.retotecnico.questions.TheConfirmationMessage;
import com.sistecredito.retotecnico.tasks.*;
import com.sistecredito.retotecnico.utils.Generate;
import com.sistecredito.retotecnico.utils.JSonEnvironment;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static com.sistecredito.retotecnico.ui.InitCreditPage.CREDIT_CREATION_MESSAGE;
import static com.sistecredito.retotecnico.ui.PayCreditPage.TRANSACTION_STATUS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class PayCreditStepDefinitions {

    @Before
    public void setStage() {
        //OnStage.setTheStage(Cast.whereEveryoneCan(BrowseTheWeb.with(MyChromeDriver.createDriver().withSomePrefs())));
        OnStage.setTheStage(new OnlineCast());
    }
    private Client client;
    private Credit credit;

    @Given("^that (.*) created a new client$")
    public void thatJuanCreatedANewClient(String nameActor) {

        client = Generate.newClient();
        OnStage.theActorCalled(nameActor).remember("client", client);
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(JSonEnvironment.fromSettings().getValue("urlCreateUser")));

        OnStage.theActorInTheSpotlight().wasAbleTo(Register.newClient(client),
                ConfirmEmail.forYopmail(client.getUser().getEmail()),
                Login.withUser(client.getUser().getEmail()).andPassword(client.getUser().getPassword()),
                RegisterDNI.withDocumentType(client.getPersonal().getDocumentType())
                        .andDocumentNumber(client.getPersonal().getDocumentNumber()));

       /*OnStage.theActorInTheSpotlight().wasAbleTo(Login.withUser("fdom13@yopmail.com").andPassword("123456"),
                RegisterDNI.withDocumentType(client.getPersonal().getDocumentType())
                        .andDocumentNumber(client.getPersonal().getDocumentNumber())
                );*/

    }


    @Given("^he requested a valid quota$")
    public void heRequestedAValidQuota() {

        OnStage.theActorInTheSpotlight().attemptsTo(NavigateTo.requestQuota(),
                RequestQuota.forTheClient(client));
    }

    @When("^he creates a credit$")
    public void heCreatesACredit() {

        credit = Generate.newCredit();
        OnStage.theActorInTheSpotlight().remember("credit", credit);
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url(JSonEnvironment.fromSettings().getValue("credit.url")),
                Login.withUser(JSonEnvironment.fromSettings().getValue("credit.user"))
                .andPassword(JSonEnvironment.fromSettings().getValue("credit.password")),
                SearchClient.withDocumentNumber(client.getPersonal().getDocumentNumber()),
                CalcCredit.withCreditOptions(credit),
                ApproveCredit.withToken());
        OnStage.theActorInTheSpotlight().should(seeThat(TheConfirmationMessage.forTheTarget(CREDIT_CREATION_MESSAGE),
                Matchers.containsString("Has finalizado el proceso de crédito exitosamente.")));
    }

    @When("^he pays the credit$")
    public void hePaysTheCredit() {
        Payment payment = Generate.aPaymentPSE();
        OnStage.theActorInTheSpotlight().attemptsTo(Open.url(JSonEnvironment.fromSettings().getValue("payCreditUrl")),
                SearchCredit.forTheClientWithDocumentType(client.getPersonal().getDocumentType())
        .withDocumentNumber(client.getPersonal().getDocumentNumber()),
                PayCredit.forTheCredit(credit.getValue()).withPaymentData(payment));
    }

    @Then("^he should see the confirmation of pay$")
    public void heShouldSeeTheConfirmationOfPay() {

        OnStage.theActorInTheSpotlight().should(seeThat(TheConfirmationMessage.forTheTarget(TRANSACTION_STATUS),
                is(equalTo("Tu transacción ha sido aprobada"))));

    }

}
