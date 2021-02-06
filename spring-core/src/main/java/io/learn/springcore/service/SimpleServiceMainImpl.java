package io.learn.springcore.service;

import io.learn.springcore.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SimpleServiceMainImpl implements SimpleService {

    private SimpleRepository simpleRepository;

    @Autowired
    public SimpleServiceMainImpl(@Qualifier("simpleRepositoryMainImpl") SimpleRepository simpleRepository) {
        this.simpleRepository = simpleRepository;
    }

    @Override
    public void doTask() {
        System.out.println("Call doTask for " + this.getClass().getSimpleName());
        simpleRepository.doQuery();
    }
}
