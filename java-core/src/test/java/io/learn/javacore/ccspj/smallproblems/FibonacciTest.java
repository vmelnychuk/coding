package io.learn.javacore.ccspj.smallproblems;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class FibonacciTest {

    private Fibonacci fibonacci = new Fibonacci();

    @Test
    void fib1For10() {
        assertEquals(55, fibonacci.fib1(10));
    }

    @Test
    void fib1For0() {
        assertEquals(0, fibonacci.fib1(0));
    }

    @Test
    void fib1For1() {
        assertEquals(1, fibonacci.fib1(1));
    }

    @Test
    void fib1For30() {
        assertEquals(832040, fibonacci.fib1(30));
    }

    @Test
    void fib2For91() {
        assertEquals(4660046610375530309L, fibonacci.fib2(91));
    }

    @Test
    void fib3() {
        assertEquals(102334155, fibonacci.fib3(40));
    }
}
