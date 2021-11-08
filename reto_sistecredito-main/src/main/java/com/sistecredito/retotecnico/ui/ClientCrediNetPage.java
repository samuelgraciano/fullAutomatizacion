package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ClientCrediNetPage {
    private ClientCrediNetPage(){}
    public static final Target INIT_CREDIT = Target.the("Init credit button")
            .locatedBy("//button[@id='apply-credit']");
}
