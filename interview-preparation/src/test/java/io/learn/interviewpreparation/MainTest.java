package io.learn.interviewpreparation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    public void sayHello() {
        Main main = new Main();
        String result = main.sayHello();

        assertEquals("Hello...", result);
    }
}
