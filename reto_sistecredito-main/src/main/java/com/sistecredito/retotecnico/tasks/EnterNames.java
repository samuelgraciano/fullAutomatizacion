package com.sistecredito.retotecnico.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.sistecredito.retotecnico.ui.ChatSisteCreditoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterNames implements Task {
    private String firstName;
    private String secondName;
    private String lastName;
    private String secondLastName;

    public EnterNames(String fullName){
        String[] names = fullName.split(" ");
        if (names.length == 3){
            firstName = names[0];

            secondName = "";
            lastName = names[1];
            secondLastName = names[2];
        }
        else {
            firstName = names[0];

            secondName = names[1];
            lastName = names[2];
            secondLastName = names[3];
        }
        if(firstName.length()<=3)
            firstName+="lan";
    }

    @Step("{0} enters names #firstName #secondName #lastName #secondLastName")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(MESSAGE.of("La solicitud requiere mas datos."),
                isVisible()).forNoMoreThan(140).seconds(),
                Enter.theValue(firstName).into(INPUT_CHAT.of("Ingrese primer nombre.")).thenHit(Keys.ENTER),
                WaitUntil.the(MESSAGE.of("segundo"),
                        isVisible()).forNoMoreThan(100).seconds(),
                Check.whether(secondName.isEmpty()).andIfSo(Click.on(OMIT)).otherwise(
                Enter.theValue(secondName).into(INPUT_CHAT.of("Ingresa un segundo nombre.")).thenHit(Keys.ENTER)),
                WaitUntil.the(MESSAGE.of("primer"),
                        isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(lastName).into(INPUT_CHAT.of("Ingresa tu primer apellido.")).thenHit(Keys.ENTER),
                WaitUntil.the(MESSAGE.of("segundo"),
                        isVisible()).forNoMoreThan(100).seconds(),
                Enter.theValue(secondLastName).into(INPUT_CHAT.of("Ingresa tu segundo apellido.")).thenHit(Keys.ENTER));
    }

    public static EnterNames withFullName(String fullName){
        return Tasks.instrumented(EnterNames.class, fullName);
    }

}
