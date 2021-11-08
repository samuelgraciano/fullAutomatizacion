package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.models.Client;
import com.sistecredito.retotecnico.ui.LoginPage;
import com.sistecredito.retotecnico.ui.RegisterPersonasPage;



import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.Keys;

import static com.sistecredito.retotecnico.ui.RegisterPersonasPage.*;

public class Register implements Task {

    private Client client;

    public Register(Client client) {
        this.client = client;
    }

    @Step("{0} register client with #client")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(LoginPage.REGISTER),
                Click.on(LoginPage.WITH_MY_EMAIL),
                Enter.theValue(client.getPersonal().getName()).into(NAME),
                Enter.theValue(client.getUser().getEmail()).into(EMAIL).thenHit(Keys.ENTER),
                Enter.theValue(client.getUser().getEmail()).into(VERIFY_EMAIL).thenHit(Keys.ENTER),
                Enter.theValue(client.getUser().getPassword()).into(PASSWORD),
                Enter.theValue(client.getUser().getPassword()).into(VERIFY_PASSWORD),
                Click.on(RegisterPersonasPage.SEND),
                Click.on(ACCEPT));
    }

    public static Register newClient(Client client){
        return Tasks.instrumented(Register.class, client);
    }
}
