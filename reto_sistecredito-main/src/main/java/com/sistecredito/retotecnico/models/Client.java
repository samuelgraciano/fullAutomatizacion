package com.sistecredito.retotecnico.models;

public class Client {


    private User user;
    private Personal personal;
    private Location location;
    private FamilyReference familyReference;
    private Occupation occupation;



    public Client(User user, Personal personal, Location location, FamilyReference familyReference, Occupation occupation) {
        this.user = user;
        this.personal = personal;
        this.location = location;
        this.familyReference = familyReference;
        this.occupation = occupation;
    }


    public Occupation getOccupation() {
        return occupation;
    }

    public User getUser() {
        return user;
    }

    public Personal getPersonal() {
        return personal;
    }

    public Location getLocation() {
        return location;
    }

    public FamilyReference getFamilyReference() {
        return familyReference;
    }

    @Override
    public String toString() {
        return "Client{" +
                "user=" + user +
                ", personal=" + personal +
                ", location=" + location +
                ", familyReference=" + familyReference +
                '}';
    }
}
