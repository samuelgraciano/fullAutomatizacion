package com.sistecredito.retotecnico.interactions;

import com.sistecredito.retotecnico.ui.AdminPersonasPage;
import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.InvalidElementStateException;

public class WaitLoader implements Interaction {
    @Step("{0} waits loader to dissapear")
    @Override
    public <T extends Actor> void performAs(T actor) {
        int count = 0;
        do {
            new InternalSystemClock().pauseFor(1000);
            count++;
        } while (AdminPersonasPage.LOADER.resolveFor(actor).isCurrentlyVisible() && count <= 20);
        if (count>20)
            throw new InvalidElementStateException("Element"+ AdminPersonasPage.LOADER.getName()+ " still visible");

    }

    public static WaitLoader toDissapear(){
        return Tasks.instrumented(WaitLoader.class);
    }
}
