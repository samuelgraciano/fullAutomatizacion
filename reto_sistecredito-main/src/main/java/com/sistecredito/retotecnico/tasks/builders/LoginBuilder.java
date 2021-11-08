package com.sistecredito.retotecnico.tasks.builders;

import com.sistecredito.retotecnico.tasks.Login;
import net.serenitybdd.screenplay.Tasks;

public class LoginBuilder {
    private String user;

    public LoginBuilder(String user) {
        this.user = user;
    }

    public Login andPassword(String password){
        return Tasks.instrumented(Login.class, user,password);
    }
}
