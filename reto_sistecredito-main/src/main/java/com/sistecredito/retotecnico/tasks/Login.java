package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.tasks.builders.LoginBuilder;
import com.sistecredito.retotecnico.ui.LoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.thucydides.core.annotations.Step;

public class Login implements Task {
    private String user;
    private String password;

    public Login(String user, String password) {
        this.user = user;
        this.password = password;
    }
    @Step("{0} login with #user and #password")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(user).into(LoginPage.USER),
                Enter.theValue(password).into(LoginPage.PASSWORD),
                Click.on(LoginPage.LOGIN));
    }

    public static LoginBuilder withUser(String user){
        return new LoginBuilder(user);
    }
}
