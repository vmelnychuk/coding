package io.learn.springaop.dao;

import io.learn.springaop.model.Passenger;

public interface PassengerDao {
    Passenger getPassenger(long id);
    void add(Passenger passenger);
}
