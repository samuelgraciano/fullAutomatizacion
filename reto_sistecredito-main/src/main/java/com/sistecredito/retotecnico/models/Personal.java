package com.sistecredito.retotecnico.models;

public class Personal {
    private String name;
    private String documentType;
    private String documentNumber;
    private String cellPhone;
    private String birthDate;
    private String documentGeneratedDate;
    private String phoneNumber;
    private String gender;

    public Personal(String name, String documentType, String documentNumber, String cellPhone, String birthDate, String documentGeneratedDate, String phoneNumber, String gender) {
        this.name = name;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.cellPhone = cellPhone;
        this.birthDate = birthDate;
        this.documentGeneratedDate = documentGeneratedDate;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getName() {
        return name;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getDocumentGeneratedDate() {
        return documentGeneratedDate;
    }

    @Override
    public String toString() {
        return "Personal{" +
                "name='" + name + '\'' +
                ", documentType='" + documentType + '\'' +
                ", documentNumber='" + documentNumber + '\'' +
                ", cellPhone='" + cellPhone + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", documentGeneratedDate='" + documentGeneratedDate + '\'' +
                '}';
    }
}
