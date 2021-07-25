package io.learn.springaop.model;

public class Ticket {
    private String number;
    private Passenger passenger;

    public Ticket(String number, Passenger passenger) {
        this.number = number;
        this.passenger = passenger;
    }

    public String getNumber() {
        return number;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
