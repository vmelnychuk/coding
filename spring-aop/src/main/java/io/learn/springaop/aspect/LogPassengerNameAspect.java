package io.learn.springaop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Slf4j
@Aspect
@Service
public class LogPassengerNameAspect {
    @Before("execution(public io.learn.springaop.model.Passenger io.learn.springaop.dao.impl.PassengerDaoImpl.getPassenger(..))")
    public void loggingAdviceGetName() {
        log.info("call getPassenger");
    }
}
