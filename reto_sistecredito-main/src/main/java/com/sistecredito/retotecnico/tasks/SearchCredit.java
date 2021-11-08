package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.tasks.builders.SearchCreditBuilder;
import com.sistecredito.retotecnico.ui.PayCreditPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class SearchCredit implements Task {
    private String documentType;
    private String documentNumber;

    public SearchCredit(String documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    @Step("{0} searches credit for the client with document type #documentType and documentNumber #documentNumber")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitLoader.toDissapear(),
                Click.on(PayCreditPage.DOCUMENT_TYPE),
                Click.on(PayCreditPage.DOCUMENT_TYPE_OPTION.of(documentType)),

                Enter.theValue(documentNumber).into(PayCreditPage.DOCUMENT_NUMBER),
                Click.on(PayCreditPage.SEND));
    }

    public static SearchCreditBuilder forTheClientWithDocumentType(String documentType){
        return new SearchCreditBuilder(documentType);
    }
}
