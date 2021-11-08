package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ReferencesCreditComponent {

    private ReferencesCreditComponent(){}
    public static final Target NAME = Target.the("Name input")
            .locatedBy("//input[@id='name']");
    public static final Target PHONE = Target.the("Phone number input")
            .locatedBy("//input[@id='phone']");
    public static final Target RELATIONSHIP = Target.the("Relationship select")
            .locatedBy("//select[@formcontrolname='relationship']");
    public static final Target SEND = Target.the("Send button")
            .locatedBy("//button[text()='Enviar']");
}
