package io.learn.coding.streams;

import java.util.Spliterator;
import java.util.function.Consumer;

import io.learn.coding.streams.model.Person;

public class PersonSpliterator implements Spliterator<Person> {
    private final Spliterator<String> linesSpliterator;
    private String name;
    private int age;
    private String city;

    public PersonSpliterator(Spliterator<String> lineSpliterator) {
        this.linesSpliterator = lineSpliterator;
    }

    @Override
    public boolean tryAdvance(Consumer<? super Person> action) {
        if (this.linesSpliterator.tryAdvance(line -> this.name = line) &&
            this.linesSpliterator.tryAdvance(line -> this.age = Integer.parseInt(line)) &&
            this.linesSpliterator.tryAdvance(line -> this.city = line)) {
            action.accept(new Person(name, age, city));
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Spliterator<Person> trySplit() {
        throw new UnsupportedOperationException("Not supported operation");
    }

    @Override
    public long estimateSize() {
        return linesSpliterator.estimateSize() / 3;
    }

    @Override
    public int characteristics() {
        return linesSpliterator.characteristics();
    }
}
