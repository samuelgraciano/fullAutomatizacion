package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.SelectDate;
import com.sistecredito.retotecnico.models.Personal;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.retotecnico.ui.ChatSisteCreditoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterOtherInformation implements Task {
    private Personal personal;

    public EnterOtherInformation(Personal personal) {
        this.personal = personal;
    }

    @Step("{0} enters his birth date, document date, gender and phone number #personal")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(MESSAGE.of("Selecciona tu fecha de nacimiento"), isVisible()).forNoMoreThan(20).seconds(),
                SelectDate.withDate(personal.getBirthDate()),
                WaitUntil.the(MESSAGE.of("¿Cuál es la fecha de expedición de tu documento?"), isVisible()).forNoMoreThan(20).seconds(),
                SelectDate.withDate(personal.getDocumentGeneratedDate()),
                WaitUntil.the(MESSAGE.of("¿Cuál es tu género?"), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(GENDER.of(personal.getGender())),
                Enter.theValue(personal.getPhoneNumber()).into(INPUT_CHAT.of("Ingrese número de teléfono fijo.")),
                Click.on(SEND)
                );
    }

    public static EnterOtherInformation withPersonalData(Personal personalData){
        return Tasks.instrumented(EnterOtherInformation.class,personalData);
    }
}
