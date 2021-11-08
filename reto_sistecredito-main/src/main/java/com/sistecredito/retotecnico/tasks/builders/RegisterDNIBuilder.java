package com.sistecredito.retotecnico.tasks.builders;

import com.sistecredito.retotecnico.tasks.RegisterDNI;
import net.serenitybdd.screenplay.Tasks;

public class RegisterDNIBuilder {
    private String documentType;

    public RegisterDNIBuilder(String documentType) {
        this.documentType = documentType;
    }

    public RegisterDNI andDocumentNumber(String documentNumber){
        return Tasks.instrumented(RegisterDNI.class, documentType, documentNumber);
    }
}
