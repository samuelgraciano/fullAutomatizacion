package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class LoginPage {
    private LoginPage(){}

    public static final Target REGISTER = Target.the("Register button")
            .locatedBy("//button[text()='Regístrate']");
    public static final Target WITH_MY_EMAIL = Target.the("With my email option")
            .locatedBy("//span[text()='Con tu cuenta de correo']");
    public static final Target PASSWORD = Target.the("Password input")
            .locatedBy("//input[@id='password' or @id='TextBoxPassword']");
    public static final Target USER = Target.the("User input")
            .locatedBy("//input[@id='username' or @id='TextBoxuser']");
    public static final Target LOGIN = Target.the("Login button")
            .locatedBy("//button[text()='Iniciar sesión' or @id='Access']");
}
