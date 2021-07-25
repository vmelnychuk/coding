package io.learn.springaop.dao.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

import com.github.javafaker.Faker;
import io.learn.springaop.dao.PassengerDao;
import io.learn.springaop.model.Passenger;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PassengerDaoImpl implements PassengerDao {
    private static AtomicLong passengerIdGenerator = new AtomicLong(1);
    private Faker faker = new Faker();

    private static Map<Long, Passenger> passengersMap = new HashMap<>();

    @Override
    public Passenger getPassenger(long id) {
        if (passengersMap.containsKey(id)) {
            return passengersMap.get(id);
        } else {
            Passenger passenger = new Passenger(faker.name().fullName(), faker.country().name());
            passengerIdGenerator.set(id);
            passengersMap.put(id, passenger);
            return passenger;
        }
    }

    @Override
    public void add(Passenger passenger) {
        passengersMap.put(passengerIdGenerator.getAndIncrement(), passenger);
    }
}
