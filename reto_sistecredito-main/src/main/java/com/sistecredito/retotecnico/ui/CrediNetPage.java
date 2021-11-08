package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class CrediNetPage {
    private CrediNetPage(){}
    public static final Target SEARCH_CLIENT = Target.the("Search client input")
            .locatedBy("//input[@id='input-search']");
}
