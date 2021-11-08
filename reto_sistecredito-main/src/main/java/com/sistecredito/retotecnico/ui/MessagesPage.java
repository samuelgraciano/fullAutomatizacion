package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class MessagesPage {
    private MessagesPage(){}
    public static final Target DESTINATION_NUMBER = Target.the("The destination number 85122")
            .locatedBy("//span[text()='85122']");
    public static final Target LAST_SMS = Target.the("Last sms")
            .locatedBy("//div[@data-e2e-message-status]");
    public static final Target TOKEN = Target.the("Token")
            .locatedBy("//div[@data-e2e-message-status]//ancestor::mws-message-wrapper" +
                    "//div[@class='text-msg ng-star-inserted']");
    public static final Target LOADER = Target.the("Loader")
            .locatedBy("//div[@id='loader']");


}
