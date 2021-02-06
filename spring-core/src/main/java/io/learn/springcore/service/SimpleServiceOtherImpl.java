package io.learn.springcore.service;

import io.learn.springcore.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class SimpleServiceOtherImpl implements SimpleService {

    @Autowired
    @Qualifier("simpleRepositoryOtherImpl")
    private SimpleRepository simpleRepository;

    @Override
    public void doTask() {
        System.out.println("Call of do Task for " + this.getClass().getSimpleName());
        simpleRepository.doQuery();
    }
}
