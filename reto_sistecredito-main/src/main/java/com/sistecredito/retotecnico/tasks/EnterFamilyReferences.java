package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.models.FamilyReference;
import com.sistecredito.retotecnico.ui.ChatSisteCreditoPage;
import com.sistecredito.retotecnico.ui.ReferencesCreditComponent;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterFamilyReferences implements Task {

    private FamilyReference familyReference;

    public EnterFamilyReferences(FamilyReference familyReference) {
        this.familyReference = familyReference;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(ChatSisteCreditoPage.MESSAGE.of("Dale click al siguiente botón, " +
                "para diligenciar el formulario de tu referencia familiar."), isVisible()).forNoMoreThan(20).seconds());
        actor.attemptsTo(
                Click.on(ChatSisteCreditoPage.REFERENCES),
                Enter.theValue(familyReference.getName()).into(ReferencesCreditComponent.NAME),
                Enter.theValue(familyReference.getPhoneNumber()).into(ReferencesCreditComponent.PHONE),
                SelectFromOptions.byVisibleText(familyReference.getRelationship()).from(ReferencesCreditComponent.RELATIONSHIP),
                Click.on(ReferencesCreditComponent.SEND));
    }

    public static EnterFamilyReferences withReference(FamilyReference familyReference){
        return Tasks.instrumented(EnterFamilyReferences.class, familyReference);
    }
}
