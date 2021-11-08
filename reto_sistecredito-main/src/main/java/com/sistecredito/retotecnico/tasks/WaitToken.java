package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.OpenNewTab;
import com.sistecredito.retotecnico.ui.MessagesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;

public class WaitToken implements Task {

    @Step("{0} waits a token is received")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(OpenNewTab.onBrowser(),
                Open.url("https://messages.google.com/web/conversations"),
                WaitUntil.the(MessagesPage.DESTINATION_NUMBER, WebElementStateMatchers.isVisible())
                        .forNoMoreThan(20).seconds(),
                //WaitUntil.the(MessagesPage.LOADER, WebElementStateMatchers.isNotVisible())
                        //.forNoMoreThan(20).seconds(),
                Click.on(MessagesPage.DESTINATION_NUMBER),
                WaitUntil.the(MessagesPage.LAST_SMS, WebElementStateMatchers.containsOnlyText("jue, 16:23"))
                        .forNoMoreThan(20).seconds());
    }

    public static WaitToken fromMobile(){
        return Tasks.instrumented(WaitToken.class);
    }
}
