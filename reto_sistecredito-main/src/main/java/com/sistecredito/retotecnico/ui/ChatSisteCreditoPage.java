package com.sistecredito.retotecnico.ui;

import net.serenitybdd.screenplay.targets.Target;

public class ChatSisteCreditoPage {
    private ChatSisteCreditoPage(){}
    public static final Target MESSAGE = Target.the("Message {0}")
            .locatedBy("//*[contains(text(),'{0}')]");
    public static final Target INPUT_CHAT = Target.the("{0} option")
            .locatedBy("//input[@placeholder='{0}']");
    public static final Target SEND = Target.the("Send button")
            .locatedBy("//button[@ng-reflect-klass='btn sc-btn__btn-send']");
    public static final Target LOCATION = Target.the("Location button")
            .locatedBy("//button[@ng-reflect-ng-class='sc-btn__btn-location']");
    public static final Target CAMERA = Target.the("Camera button")
            .locatedBy("//button[@ng-reflect-ng-class='sc-btn__btn-camera']");
    public static final Target DOCUMENT_CAMERA = Target.the("Camera button")
            .locatedBy("//button[@class='btn sc-camera__btn-capture pb-4']");
    public static final Target CITY = Target.the("City input")
            .locatedBy("//input[@placeholder='Busca el municipio']");
    public static final Target NEIGHBORHOOD = Target.the("Neighborhood input")
            .locatedBy("//input[@placeholder='Busca el barrio']");
    public static final Target SEND_LOCATION = Target.the("Location send button")
            .locatedBy("//button[contains(text(),'Enviar')]");
    public static final Target START = Target.the("Start button")
            .locatedBy("//button[@id='btn-init']");
    public static final Target SEND_CALENDAR = Target.the("Send button")
            .locatedBy("//button[text()='Enviar']");

    public static final Target SEND_PHOTO = Target.the("Send photo   button")
            .locatedBy("//button[text()=' Enviar foto']");
    public static final Target OMIT = Target.the("Omit button")
            .locatedBy("//button[contains(text(),'Omitir')]");
    public static final  Target CALENDAR = Target.the("calendar birthdate")
            .locatedBy("//button[@ng-reflect-ng-class='sc-btn__btn-calendar']");
    public static final  Target DISPLAY_CALENDAR = Target.the("Display calendar")
            .locatedBy("//button[contains(@class,'datepicker')]");
    public static final  Target MONTH = Target.the("Month select")
            .locatedBy("//select[@aria-label='Select month']");
    public static final  Target YEAR = Target.the("Year select")
            .locatedBy("//select[@aria-label='Select year']");
    public static final  Target DAY = Target.the("Day {0} option")
            .locatedBy("//div[@class='btn-light' and text()='{0}']");

    public static final Target GENDER = Target.the("Gender {0}")
            .locatedBy("//button[@value='{0}']");
    public static final Target REFERENCES = Target.the("References")
            .locatedBy("//button[@ng-reflect-ng-class='sc-btn__btn-form']");
    public static final Target OCCUPATION = Target.the("Occupation button")
            .locatedBy("//button[@ng-reflect-ng-class='sc-btn__btn-form']");




}
