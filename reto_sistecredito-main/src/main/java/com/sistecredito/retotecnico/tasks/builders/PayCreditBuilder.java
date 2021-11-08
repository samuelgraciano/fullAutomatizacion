package com.sistecredito.retotecnico.tasks.builders;

import com.sistecredito.retotecnico.models.Payment;
import com.sistecredito.retotecnico.tasks.PayCredit;
import net.serenitybdd.screenplay.Tasks;

public class PayCreditBuilder {
    private String creditTotalValue;

    public PayCreditBuilder(String creditTotalValue) {
        this.creditTotalValue = creditTotalValue;
    }

    public PayCredit withPaymentData(Payment payment){
        return Tasks.instrumented(PayCredit.class, creditTotalValue, payment);
    }
}
