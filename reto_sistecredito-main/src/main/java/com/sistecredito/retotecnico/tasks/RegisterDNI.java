package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.tasks.builders.RegisterDNIBuilder;
import com.sistecredito.retotecnico.ui.StartRequestPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.retotecnico.ui.AdminPersonasPage.LOADER;
import static com.sistecredito.retotecnico.ui.StartRequestPage.DOCUMENT_TYPE;

public class RegisterDNI implements Task {

    private String documentType;
    private String documentNumber;

    public RegisterDNI(String documentType, String documentNumber) {
        this.documentType = documentType;
        this.documentNumber = documentNumber;
    }

    @Step("{0} registers the document #documentType with number #documentNumber")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitLoader.toDissapear(),
                SelectFromOptions.byVisibleText(documentType).from(DOCUMENT_TYPE),
                Enter.theValue(documentNumber).into(StartRequestPage.DNI),
                Enter.theValue(documentNumber).into(StartRequestPage.VERIFY_DNI),
                Click.on(StartRequestPage.SEND));
    }

    public static RegisterDNIBuilder withDocumentType(String documentType){
        return new RegisterDNIBuilder(documentType);
    }

}
