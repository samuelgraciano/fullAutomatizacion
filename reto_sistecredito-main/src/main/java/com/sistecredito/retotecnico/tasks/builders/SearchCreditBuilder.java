package com.sistecredito.retotecnico.tasks.builders;

import com.sistecredito.retotecnico.tasks.SearchCredit;
import net.serenitybdd.screenplay.Tasks;

public class SearchCreditBuilder {
    private String documentType;

    public SearchCreditBuilder(String documentType) {
        this.documentType = documentType;
    }

    public SearchCredit withDocumentNumber(String documentNumber){
        return Tasks.instrumented(SearchCredit.class, documentType, documentNumber);
    }
}
