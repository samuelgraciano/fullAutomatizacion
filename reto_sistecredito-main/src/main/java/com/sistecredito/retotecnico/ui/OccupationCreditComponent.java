package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class OccupationCreditComponent {
    private OccupationCreditComponent(){}

    public static final Target OCCUPATION_TYPE = Target.the("Occupation type select")
            .locatedBy("//select[@formcontrolname='ocupation']");
    public static final Target SALARY_RANGE = Target.the("Salary range select")
            .locatedBy("//select[@formcontrolname='salary']");
    public static final Target BUSINESS_NAME = Target.the("Business name input")
            .locatedBy("//input[@id='business']");
    public static final Target BUSINESS_PHONE = Target.the("Phone number input")
            .locatedBy("//input[@id='phone']");
    public static final Target ROLE = Target.the("Role select")
            .locatedBy("//select[@formcontrolname='role']");
    public static final Target SEND = Target.the("Send button")
            .locatedBy("//button[text()='Enviar']");


}
