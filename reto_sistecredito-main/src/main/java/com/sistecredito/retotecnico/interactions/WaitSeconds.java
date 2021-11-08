package com.sistecredito.retotecnico.interactions;

import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class WaitSeconds implements Interaction {
    private int seconds;

    public WaitSeconds(int seconds) {
        this.seconds = seconds*1000;
    }

    @Step("{0} waits #seconds seconds")
    @Override
    public <T extends Actor> void performAs(T actor) {

        new InternalSystemClock().pauseFor(seconds);
    }

    public static WaitSeconds forABit(int seconds){
        return Tasks.instrumented(WaitSeconds.class, seconds);
    }
}
