package com.sistecredito.retotecnico.tasks;


import com.sistecredito.retotecnico.models.Client;

import com.sistecredito.retotecnico.ui.AdminPersonasPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;

import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;



public class RequestQuota implements Task {
    private Client client;

    public RequestQuota(Client client) {
        this.client = client;
    }

    @Step("{0} requests a quota for the client #client")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                EnterTheToken.fromMobileWithNumber(client.getPersonal().getCellPhone()),
                EnterLocation.forCity(client.getLocation().getCity()).andNeighborhood(client.getLocation().getNeighborhood()),
                TakePictures.forValidateIdentity(),
                EnterNames.withFullName(client.getPersonal().getName()),
                EnterOtherInformation.withPersonalData(client.getPersonal()),
                EnterFamilyReferences.withReference(client.getFamilyReference()),
                EnterOccupation.withOcuppationData(client.getOccupation()),
                WaitUntil.the(AdminPersonasPage.AVAILABLE_QUOTA, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(100).seconds());
    }

    public static RequestQuota forTheClient (Client client){
        return Tasks.instrumented(RequestQuota.class, client);
    }
}
