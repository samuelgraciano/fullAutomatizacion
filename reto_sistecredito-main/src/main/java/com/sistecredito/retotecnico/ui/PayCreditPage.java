package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class PayCreditPage {
    private PayCreditPage(){}
    public static final Target DOCUMENT_TYPE = Target.the("Document type select")
            .locatedBy("//div[text()='Cédula de ciudadanía']");
    public static final Target DOCUMENT_TYPE_OPTION = Target.the("Document type {0} option")
            .locatedBy("//button[contains(text(),'{0}')]");
    public static final Target DOCUMENT_NUMBER = Target.the("Document number")
            .locatedBy("//input[@id='idDocument']");
    public static final Target SEND = Target.the("Send button")
            .locatedBy("//button[contains(text(),'Enviar')]");
    public static final Target CREDIT = Target.the("Credit with total value {0}")
            .locatedBy("//span[contains(text(),'{0}')]" +
                    "//ancestor::div[contains(@class,'card-credit')]//input");
    public static final Target PAYMENT_TYPE = Target.the("{0} option")
            .locatedBy("//span[contains(text(),'{0}')]" +
                    "//ancestor::div[contains(@class,'sc-payment--underline')]//input");
    public static final Target ACCEPT_TERMS = Target.the("Accept terms and conditions checkbox")
            .locatedBy("//input[@id='aceptTerms']");
    public static final Target PAYMENT_METHOD = Target.the("Payment Method {0}")
            .locatedBy("//span[contains(text(),'{0}')]");
    public static final Target CONTINUE = Target.the("Continue button")
            .locatedBy("//button[contains(text(),'Continuar')]");
    public static final Target PERSON_TYPE = Target.the("Person type {0}")
            .locatedBy("//label[text()='{0}']//preceding-sibling::input");
    public static final Target BANK = Target.the("Bank select")
            .locatedBy("//select[@id='selectBank']");
    public static final Target TRANSACTION_STATUS = Target.the("Transaction status")
            .locatedBy("//div[@id='status-bar']//child::span");




}
