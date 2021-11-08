package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.models.Payment;
import com.sistecredito.retotecnico.tasks.builders.PayCreditBuilder;
import com.sistecredito.retotecnico.utils.FormatNumber;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.retotecnico.ui.PayCreditPage.*;

public class PayCredit implements Task {

    private String creditTotalValue;
    private Payment payment;

    public PayCredit(String creditTotalValue, Payment payment) {
        this.creditTotalValue = creditTotalValue;
        this.payment = payment;
    }

    @Step("{0} pays the credit with value #creditTotalValue and payment information: #payment")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitLoader.toDissapear(),
                Click.on(CREDIT.of(FormatNumber.separator(creditTotalValue))),
                Click.on(PAYMENT_TYPE.of(payment.getPaymentType())),
                Click.on(ACCEPT_TERMS),
                Click.on(PAYMENT_METHOD.of(payment.getMethodPayment())),
                Click.on(CONTINUE),
                WaitLoader.toDissapear(),
                Click.on(PERSON_TYPE.of(payment.getPersonType())),
                SelectFromOptions.byValue(payment.getBank()).from(BANK),
                Click.on(CONTINUE),
                WaitLoader.toDissapear());
    }

    public static PayCreditBuilder forTheCredit(String creditTotalValue){
        return new PayCreditBuilder(creditTotalValue);
    }
}
