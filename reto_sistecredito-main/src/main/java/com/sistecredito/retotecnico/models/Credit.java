package com.sistecredito.retotecnico.models;

public class Credit {
    private String value;
    private String frequency;
    private String quantity;


    public Credit(String value, String frequency, String quantity) {
        this.value = value;
        this.frequency = frequency;
        this.quantity = quantity;
    }

    public String getValue() {
        return value;
    }

    public String getFrequency() {
        return frequency;
    }

    public String getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Credit{" +
                "value='" + value + '\'' +
                ", frequency='" + frequency + '\'' +
                ", quantity='" + quantity + '\'' +
                '}';
    }
}
