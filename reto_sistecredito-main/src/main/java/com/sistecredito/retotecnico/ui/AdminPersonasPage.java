package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class AdminPersonasPage {
    private AdminPersonasPage(){}

    public static final Target ACCEPT = Target.the("Accept button")
            .locatedBy("//button[contains(text(),'Aceptar')]");
    public static final Target REQUEST_QUOTA = Target.the("Request quota option")
            .locatedBy("//span[contains(text(),'Solicita tu cupo')]");
    public static final Target LOADER = Target.the("Loader component")
            .locatedBy("//span[contains(text(),'Espera un momento') or @id='loading-gestures']");
    public static final Target AVAILABLE_QUOTA = Target.the("Available quota")
            .locatedBy("//span[text()='Cupo disponible']");
}
