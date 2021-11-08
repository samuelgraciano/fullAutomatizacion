package com.sistecredito.retotecnico.questions;

import com.sistecredito.retotecnico.interactions.CloseActualTab;
import com.sistecredito.retotecnico.tasks.WaitToken;
import com.sistecredito.retotecnico.ui.MessagesPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetToken implements Question<String> {


    private String tokenType;

    public GetToken(String tokenType) {
        this.tokenType = tokenType;
    }

    @Override
    public String getSubject() {
        return "{0} gets token from mobile";
    }

    @Override
    public String answeredBy(Actor actor) {
        actor.attemptsTo(WaitToken.fromMobile());
        String mensajeToken = MessagesPage.TOKEN.resolveFor(actor).getText();
        String token;
        if(tokenType.equals("quota"))
                token= mensajeToken.split("es")[1].replace(".","").replace(" ","");

        else
            token = mensajeToken.split(" ")[0].trim();
        actor.attemptsTo(CloseActualTab.onBrowser());

        System.out.println("esto es lo que hay en el token"+token);
        return token;
    }

    public static GetToken fromMobileForQuota(){
        return new GetToken("quota");
    }
    public static GetToken fromMobileForCredit(){
        return new GetToken("credit");
    }
}
