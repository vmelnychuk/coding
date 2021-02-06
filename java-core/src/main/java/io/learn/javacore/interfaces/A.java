package io.learn.javacore.interfaces;

public interface A {
    default void test() {
        System.out.println("A");
    }
}
