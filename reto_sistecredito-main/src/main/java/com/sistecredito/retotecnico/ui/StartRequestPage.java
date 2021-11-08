package com.sistecredito.retotecnico.ui;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class StartRequestPage {

    private StartRequestPage(){}
    public static final Target DOCUMENT_TYPE = Target.the("Password input")
            .located(By.xpath("//select[@formcontrolname='nid_type']"));
    public static final Target DNI = Target.the("DNI input")
            .located(By.id("nid"));
    public static final Target VERIFY_DNI = Target.the("Verify DNI input")
            .located(By.id("verify_nid"));
    public static final Target SEND = Target.the("Send button")
            .locatedBy("//button[text()='Enviar']");
}
