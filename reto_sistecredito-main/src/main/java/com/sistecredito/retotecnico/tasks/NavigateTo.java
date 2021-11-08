package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.ui.AdminPersonasPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.questions.Visibility;
import net.thucydides.core.annotations.Step;

public class NavigateTo implements Task {

    @Step("{0} navigates to request quota")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitLoader.toDissapear());
        actor.attemptsTo(
                Check.whether(Visibility.of(AdminPersonasPage.ACCEPT).viewedBy(actor).asAQuestion())
                .andIfSo(Click.on(AdminPersonasPage.ACCEPT)),
                Click.on(AdminPersonasPage.REQUEST_QUOTA)
                );
    }

    public static Task requestQuota(){
        return Tasks.instrumented(NavigateTo.class);
    }
}
