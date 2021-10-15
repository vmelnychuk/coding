package io.learn.interviewpreparation.bigo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class FunctionsTest {

    @Test
    void f() {
        Functions functions = new Functions();
        int sum = functions.f(10);

        assertEquals(512, sum);
        assertEquals(1023, functions.calls);
    }

    @Test
    void sum() {
        Functions functions = new Functions();
        int sum = functions.sum(10);

        assertEquals(55, sum);

    }

    @Test
    void printUnorderedPairs() {
        Functions functions = new Functions();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        functions.printUnorderedPairs(array);

        assertEquals(55, functions.calls);
    }

    @Test
    void reverseArray() {
        Functions functions = new Functions();
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
        functions.reverse(array);
        int[] expected = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        assertArrayEquals(expected, array);
        assertEquals(5, functions.calls);
    }
}
