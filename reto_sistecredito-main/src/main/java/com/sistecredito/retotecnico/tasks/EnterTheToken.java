package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.questions.GetToken;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.retotecnico.ui.ChatSisteCreditoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterTheToken implements Task {

    private String cellPhone;

    public EnterTheToken(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    @Step("{0} enters the token obtained from Phone number #cellPhone SMS")
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                WaitLoader.toDissapear(),
                WaitUntil.the(MESSAGE.of("¿Cuál es tu número celular?"), isVisible()).forNoMoreThan(20).seconds(),
                Enter.theValue(cellPhone).into(INPUT_CHAT.of("Escribe tu número celular.")),
                Click.on(SEND));
        actor.attemptsTo(WaitUntil.the(MESSAGE.of("En caso tal, que no recibas tu código, presiona el siguiente botón cuando " +
                "se encuentre en verde y te haremos una llamada para darte tu código " +
                "y puedas aquí digitarlo"), isVisible()).forNoMoreThan(20).seconds());
        actor.attemptsTo(
                Enter.theValue(actor.asksFor(GetToken.fromMobileForQuota())).into(INPUT_CHAT.of("Escribe tu número código.")),
                Click.on(SEND));

    }

    public static EnterTheToken fromMobileWithNumber(String numberCellPhone){
        return Tasks.instrumented(EnterTheToken.class,numberCellPhone);
    }
}
