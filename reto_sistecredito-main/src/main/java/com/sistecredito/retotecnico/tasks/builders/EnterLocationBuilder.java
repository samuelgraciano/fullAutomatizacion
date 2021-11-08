package com.sistecredito.retotecnico.tasks.builders;

import com.sistecredito.retotecnico.tasks.EnterLocation;
import net.serenitybdd.screenplay.Tasks;

public class EnterLocationBuilder {
    private String city;

    public EnterLocationBuilder(String city) {
        this.city = city;
    }

    public EnterLocation andNeighborhood(String neighborhood){
        return Tasks.instrumented(EnterLocation.class,city, neighborhood);
    }
}
