package io.learn.springcore.service;

import io.learn.springcore.repository.SimpleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class SimpleServiceMainImpl implements SimpleService {

    @Value("${name}")
    private String name;

    private SimpleRepository simpleRepository;

    @Autowired
    public SimpleServiceMainImpl(@Qualifier("simpleRepositoryMainImpl") SimpleRepository simpleRepository) {
        this.simpleRepository = simpleRepository;
    }

    @Override
    public void doTask() {
        System.out.println("Call doTask for " + this.getClass().getSimpleName() + " by user [" + name + "]");
        simpleRepository.doQuery();
    }
}
