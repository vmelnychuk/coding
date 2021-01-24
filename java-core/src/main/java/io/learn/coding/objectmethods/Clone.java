package io.learn.coding.objectmethods;

import java.util.ArrayList;
import java.util.List;

public class Clone {

    public static void main(String[] args) {
        Animal animal = new Animal("Bob");
        Cat cat = new Cat("Alice");
        System.out.println(animal.getName());
        System.out.println(cat.getName());
        try {
            animal = (Animal) cat.clone();
            System.out.println(animal.getName());
        } catch (CloneNotSupportedException e) {
        }

    }
}

class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Cat extends Animal implements Cloneable {
    private List<String> list  = new ArrayList<String>(List.of("One", "Two", "Three"));

    public Cat(String name) {
        super(name + " in Cat");
    }

    public List<String> getList() {
        return list;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
