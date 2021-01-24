package io.learn.coding.interfaces;

public interface A {
    default void test() {
        System.out.println("A");
    }
}
