package com.sistecredito.retotecnico.models;

public class Payment {
    private String paymentType;
    private String methodPayment;
    private String bank;
    private String personType;

    public Payment(String paymentType, String methodPayment, String bank, String personType) {
        this.paymentType = paymentType;
        this.methodPayment = methodPayment;
        this.bank = bank;
        this.personType = personType;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getMethodPayment() {
        return methodPayment;
    }

    public String getBank() {
        return bank;
    }

    public String getPersonType() {
        return personType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "typePayment='" + paymentType + '\'' +
                ", methodPayment='" + methodPayment + '\'' +
                ", bank='" + bank + '\'' +
                ", typePerson='" + personType + '\'' +
                '}';
    }
}
