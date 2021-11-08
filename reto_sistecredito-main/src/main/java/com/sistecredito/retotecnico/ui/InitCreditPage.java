package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class InitCreditPage {
    private InitCreditPage(){}
    public static final Target CREDIT_VALUE = Target.the("Credit value input")
            .locatedBy("//input[@id='credit-value']");
    public static final Target CALC = Target.the("Calc button")
            .locatedBy("//button[@id='btn-calc']");
    public static final Target FREQUENCY = Target.the("Frequency select")
            .locatedBy("//button[@id='select-frecuency']");
    public static final Target FREQUENCY_OPTION = Target.the("{0} frequency")
            .locatedBy("//span[text()='{0}']");
    public static final Target QUANTITY = Target.the("Quantity select")
            .locatedBy("//button[@id='select-months-quantity']");
    public static final Target QUANTITY_OPTION = Target.the("{0} quantity")
            .locatedBy("//span[text()='{0}' and @id='select-month']");
    public static final Target NEXT = Target.the("Next button")
            .locatedBy("//button[@id='btn-next']");
    public static final Target APPROVE = Target.the("Approve button")
            .locatedBy("//button[@id='btn-approve']");
    public static final Target TOKEN_POSITION = Target.the("Token at {0} position input")
            .locatedBy("//input[@id='dynamic-key-{0}']");
    public static final Target CREDIT_CREATION_MESSAGE = Target.the("Confirmation message label")
            .locatedBy("//*[@id='message']");
}
