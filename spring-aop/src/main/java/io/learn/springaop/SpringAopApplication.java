package io.learn.springaop;


import io.learn.springaop.configuration.ApplicationConfiguration;
import io.learn.springaop.dao.PassengerDao;
import io.learn.springaop.model.Passenger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringAopApplication {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class);
        PassengerDao passengerDao = context.getBean(PassengerDao.class);
        Passenger passenger1 = passengerDao.getPassenger(1);
        Passenger passenger2 = passengerDao.getPassenger(2);
        Passenger passenger2Saved = passengerDao.getPassenger(2);
        System.out.println(passenger1);
        System.out.println(passenger2);
        System.out.println(passenger2Saved);
    }

}
