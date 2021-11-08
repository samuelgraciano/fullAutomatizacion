package com.sistecredito.retotecnico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.sistecredito.retotecnico.ui.CrediNetPage.SEARCH_CLIENT;

public class SearchClient implements Task {
    private String documentNumber;

    public SearchClient(String documentNumber) {
        this.documentNumber = documentNumber;
    }
    @Step("{0} searches client with document number: #documentNumber")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(documentNumber).into(SEARCH_CLIENT).thenHit(Keys.ENTER));
    }

    public static SearchClient withDocumentNumber(String documentNumber){
        return Tasks.instrumented(SearchClient.class, documentNumber);
    }
}
