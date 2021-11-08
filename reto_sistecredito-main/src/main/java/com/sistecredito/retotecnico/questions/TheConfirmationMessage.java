package com.sistecredito.retotecnico.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;

public class TheConfirmationMessage implements Question<String> {
    private Target target;

    public TheConfirmationMessage(Target target) {
        this.target = target;
    }

    @Override
    public String answeredBy(Actor actor) {
        return Text.of(target).viewedBy(actor).asString();
    }


    public static TheConfirmationMessage forTheTarget(Target target){
        return new TheConfirmationMessage(target);
    }
}
