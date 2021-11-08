package com.sistecredito.retotecnico.interactions.builders;

import com.sistecredito.retotecnico.interactions.Type;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;

public class TypeBuilder {
    private String text;

    public TypeBuilder(String text) {
        this.text = text;
    }

    public Type into(Target target){
        return Tasks.instrumented(Type.class, text,target);
    }
}
