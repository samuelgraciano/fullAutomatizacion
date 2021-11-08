package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.Change;
import com.sistecredito.retotecnico.interactions.OpenNewTab;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.sistecredito.retotecnico.ui.YopmailPage.*;

public class ConfirmEmail implements Task {
    private String email;

    public ConfirmEmail(String email) {
        this.email = email;
    }

    @Step("{0} confirms the email #email")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(OpenNewTab.onBrowser(),
                Open.url("https://yopmail.com/es/"),
                Enter.theValue(email).into(LOGIN_EMAIL).thenHit(Keys.ENTER),
                Click.on(EMAIL_SISTECREDITO),
                Click.on(CONFIRM_EMAIL),
                Change.toLastTab(),
                WaitUntil.the(AUTHORIZE_SISTECREDITO, WebElementStateMatchers.isClickable()).forNoMoreThan(10).seconds(),
                JavaScriptClick.on(AUTHORIZE_SISTECREDITO),
                Click.on(CONTINUE));
    }

    public static ConfirmEmail forYopmail(String email){
        return Tasks.instrumented(ConfirmEmail.class,email);
    }
}
