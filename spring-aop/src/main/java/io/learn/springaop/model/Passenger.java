package io.learn.springaop.model;

public class Passenger {
    private String name;
    private String country;

    public Passenger(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "Passenger{" +
            "name='" + this.getName() + '\'' +
            ", country='" + this.getCountry() + '\'' +
            '}';
    }
}
