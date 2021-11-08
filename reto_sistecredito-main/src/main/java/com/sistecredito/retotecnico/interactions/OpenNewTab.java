package com.sistecredito.retotecnico.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class OpenNewTab implements Interaction {

    @Step("{0} opens new tab")
    @Override
    public <T extends Actor> void performAs(T actor) {
        WebDriver driver = BrowseTheWeb.as(actor).getDriver();
        ((JavascriptExecutor) driver).executeScript("window.open()");
        actor.attemptsTo(Change.toLastTab());
    }

    public static OpenNewTab onBrowser(){
        return Tasks.instrumented(OpenNewTab.class);
    }
}
