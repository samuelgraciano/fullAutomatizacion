package com.sistecredito.retotecnico.interactions;

import com.sistecredito.retotecnico.ui.ChatSisteCreditoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import net.thucydides.core.annotations.Step;

public class SelectDate implements Interaction {

    private String day;
    private String month;
    private String year;

    public SelectDate(String date) {
        String[] dateSplit = date.split("-");
        day = dateSplit[0];
        month = dateSplit[1];
        year = dateSplit[2];
    }

    @Step("{0} selects the date #day - #month - #year")
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on((ChatSisteCreditoPage.CALENDAR)),
                Click.on(ChatSisteCreditoPage.DISPLAY_CALENDAR),
                SelectFromOptions.byVisibleText(year).from(ChatSisteCreditoPage.YEAR),
                SelectFromOptions.byVisibleText(month).from(ChatSisteCreditoPage.MONTH),
                Click.on(ChatSisteCreditoPage.DAY.of(day)),
                WaitSeconds.forABit(1),

                Click.on(ChatSisteCreditoPage.SEND_CALENDAR));
    }

    public static SelectDate withDate(String date){
        return Tasks.instrumented(SelectDate.class,date);
    }
}
