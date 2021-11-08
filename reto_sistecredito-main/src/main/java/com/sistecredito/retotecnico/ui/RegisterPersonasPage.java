package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class RegisterPersonasPage {
    private RegisterPersonasPage(){}

    public static final Target NAME = Target.the("Name input")
            .located(By.id("name"));
    public static final Target EMAIL = Target.the("Email input")
            .located(By.id("email"));
    public static final Target VERIFY_EMAIL = Target.the("Verify email input")
            .located(By.id("verify_email"));
    public static final Target PASSWORD = Target.the("Password input")
            .located(By.id("password"));
    public static final Target VERIFY_PASSWORD = Target.the("Verify password input")
            .located(By.id("verify_pass"));
    public static final Target SEND = Target.the("Send button")
            .locatedBy("//button[text()='Enviar']");
    public static final Target ACCEPT = Target.the("Accept button")
            .locatedBy("//button[contains(text(),'Aceptar')]");
}
