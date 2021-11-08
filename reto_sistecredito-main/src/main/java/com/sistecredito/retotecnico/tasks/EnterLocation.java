package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.Type;
import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.tasks.builders.EnterLocationBuilder;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

import static com.sistecredito.retotecnico.ui.ChatSisteCreditoPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class EnterLocation implements Task {
    private String city;
    private String neighborhood;

    public EnterLocation(String city, String neighborhood) {
        this.city = city;
        this.neighborhood = neighborhood;
    }

    @Step("{0} enters the location for city #city and neighborhood #neighborhood")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(MESSAGE.of("¿Dónde vives?"), isVisible()).forNoMoreThan(20).seconds(),
                Click.on(LOCATION),
                WaitLoader.toDissapear(),
                Type.theValue(city).into(CITY),
                WaitLoader.toDissapear(),
                Type.theValue(neighborhood).into(NEIGHBORHOOD),
                Click.on(SEND_LOCATION));
    }

    public static EnterLocationBuilder forCity(String city) {
        return new EnterLocationBuilder(city);
    }
}
