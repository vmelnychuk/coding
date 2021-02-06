package io.learn.springcore.repository;

import org.springframework.stereotype.Repository;

@Repository
public class SimpleRepositoryMainImpl implements SimpleRepository {

    @Override
    public void doQuery() {
        System.out.println("Call do query for " + this.getClass().getSimpleName());
    }
}
