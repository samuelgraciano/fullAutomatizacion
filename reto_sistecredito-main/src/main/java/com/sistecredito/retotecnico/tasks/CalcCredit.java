package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.models.Credit;
import com.sistecredito.retotecnico.ui.ClientCrediNetPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static com.sistecredito.retotecnico.ui.InitCreditPage.*;

public class CalcCredit implements Task {

    private Credit credit;

    public CalcCredit(Credit credit) {
        this.credit = credit;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(ClientCrediNetPage.INIT_CREDIT),
                Enter.theValue(credit.getValue()).into(CREDIT_VALUE),
                Click.on(CALC),
                Click.on(FREQUENCY),
                Click.on(FREQUENCY_OPTION.of(credit.getFrequency())),
                Click.on(QUANTITY),
                Click.on(FREQUENCY_OPTION.of(credit.getQuantity())),
                Click.on(NEXT),
                Click.on(APPROVE));
    }

    public static CalcCredit withCreditOptions(Credit creditOptions){
        return Tasks.instrumented(CalcCredit.class,creditOptions);
    }
}
