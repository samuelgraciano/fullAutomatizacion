package com.sistecredito.retotecnico.models;

public class FamilyReference {
    private String name;
    private String phoneNumber;
    private String relationship;

    public FamilyReference(String name, String phoneNumber, String relationship) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.relationship = relationship;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRelationship() {
        return relationship;
    }

    @Override
    public String toString() {
        return "FamilyReference{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", relationship='" + relationship + '\'' +
                '}';
    }
}
