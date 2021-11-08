package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.models.Occupation;
import com.sistecredito.retotecnico.ui.ChatSisteCreditoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.retotecnico.ui.ChatSisteCreditoPage.MESSAGE;
import static com.sistecredito.retotecnico.ui.OccupationCreditComponent.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterOccupation implements Task {

    private Occupation occupation;

    public EnterOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    @Step("{0} enters the occupation ")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MESSAGE.of("Dale click al siguiente botón, para diligenciar el formulario de tu Ocupación"), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ChatSisteCreditoPage.OCCUPATION),
                SelectFromOptions.byVisibleText(occupation.getOccupation()).from(OCCUPATION_TYPE),
                SelectFromOptions.byVisibleText(occupation.getSalaryRange()).from(SALARY_RANGE),
                Enter.theValue(occupation.getBusinessName()).into(BUSINESS_NAME),
                Enter.theValue(occupation.getBusinessPhone()).into(BUSINESS_PHONE),
                SelectFromOptions.byVisibleText(occupation.getRole()).from(ROLE),
                Click.on(SEND));
    }

    public static EnterOccupation withOcuppationData(Occupation ocuppation){
        return Tasks.instrumented(EnterOccupation.class,ocuppation);
    }
}
