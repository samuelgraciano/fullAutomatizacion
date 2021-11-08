package com.sistecredito.retotecnico.models;

public class Location {
    private String city;
    private String neighborhood;

    public Location(String city, String neighborhood) {
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    @Override
    public String toString() {
        return "Location{" +
                "city='" + city + '\'' +
                ", neighborhood='" + neighborhood + '\'' +
                '}';
    }
}
