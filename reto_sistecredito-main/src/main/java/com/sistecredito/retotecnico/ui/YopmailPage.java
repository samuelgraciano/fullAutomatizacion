package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.IFrame;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class YopmailPage {
    private YopmailPage(){}
    public static final Target LOGIN_EMAIL = Target.the("Login input")
            .locatedBy("//input[@id='login']");
    public static final Target EMAIL_SISTECREDITO = Target.the("Email from sistecredito")
            .inIFrame(IFrame.withPath(By.id("ifinbox"))).locatedBy("//span[text()='Sistecrédito']");
    public static final Target CONFIRM_EMAIL = Target.the("Confirm email")
            .inIFrame(IFrame.withPath(By.id("ifmail"))).locatedBy("//strong[text()='Confirma tu correo ']");
    public static final Target AUTHORIZE_SISTECREDITO = Target.the("Authorize sistecredito check")
           .locatedBy("//*[text()='Si, autorizo a Sistecrédito.']");
    public static final Target CONTINUE = Target.the("Continue button")
            .locatedBy("//button[text()='Continuar']");

}
