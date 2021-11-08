package com.sistecredito.retotecnico.tasks;

import com.sistecredito.retotecnico.interactions.WaitLoader;
import com.sistecredito.retotecnico.questions.GetToken;
import com.sistecredito.retotecnico.ui.InitCreditPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.thucydides.core.annotations.Step;

public class ApproveCredit implements Task {

    @Step("{0} approves the credit with his token")
    @Override
    public <T extends Actor> void performAs(T actor) {
        String token = actor.asksFor(GetToken.fromMobileForCredit());
        for (int i = 0; i < token.length(); i++) {
            InitCreditPage.TOKEN_POSITION.of(""+(i+1)).resolveFor(actor).sendKeys(""+token.charAt(i));
        }
        actor.attemptsTo(Click.on(InitCreditPage.APPROVE),
                Click.on(InitCreditPage.NEXT),
                WaitLoader.toDissapear()
                );
    }

    public static ApproveCredit withToken(){
        return Tasks.instrumented(ApproveCredit.class);
    }
}
