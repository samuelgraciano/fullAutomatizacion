package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.interactions.WaitSeconds;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.retotecnico.ui.ChatSisteCreditoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class TakePictures implements Task {

    @Step("{0} takes pictures for identity")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MESSAGE.of("Tómate una linda foto para tu perfil."), isVisible()),
                Click.on(CAMERA),
                WaitSeconds.forABit(5),
                Click.on(DOCUMENT_CAMERA),
                Click.on(SEND_PHOTO),
                WaitLoader.toDissapear());
        actor.attemptsTo(
                WaitUntil.the(MESSAGE.of("Tómale una foto a la parte frontal de tu cédula."), isVisible()),
                Click.on(CAMERA),
                WaitSeconds.forABit(5),
                Click.on(DOCUMENT_CAMERA),
                Click.on(SEND_PHOTO),
                WaitLoader.toDissapear());
        actor.attemptsTo(
                WaitUntil.the(MESSAGE.of("Tómale una foto a la parte posterior de tu cédula."), isVisible()),
                Click.on(CAMERA),
                WaitSeconds.forABit(5),
                Click.on(DOCUMENT_CAMERA),
                Click.on(SEND_PHOTO));
    }

    public static TakePictures forValidateIdentity(){
        return Tasks.instrumented(TakePictures.class);
    }
}
