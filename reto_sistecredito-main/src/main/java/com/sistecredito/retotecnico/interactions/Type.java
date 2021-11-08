package com.sistecredito.retotecnico.interactions;

import com.sistecredito.retotecnico.interactions.builders.TypeBuilder;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.time.InternalSystemClock;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

public class Type implements Interaction {
    private String text;
    private Target target;

    public Type(String text, Target target) {
        this.text = text;
        this.target = target;
    }

    @Step("{0} enters the value #text on #target")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebElementFacade webElement = target.resolveFor(actor);
        for (int i = 0; i < text.length(); i++) {
            webElement.sendKeys(""+text.charAt(i));
        }
        new InternalSystemClock().pauseFor(1000);
        actor.attemptsTo(Hit.the(Keys.ENTER).into(target));
    }

    public static TypeBuilder theValue(String text){
        return new TypeBuilder(text);
    }
}
