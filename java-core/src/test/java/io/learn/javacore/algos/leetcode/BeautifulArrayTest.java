package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

class BeautifulArrayTest {

    BeautifulArray beautifulArray = new BeautifulArray();

    @Test
    void beautifulArrayEx1() {
        int n = 4;
        int[] expectedResult = new int[]{1, 3, 2, 4};

        int[] result = beautifulArray.beautifulArray(n);

        assertArrayEquals(expectedResult, result);
    }

    @Test
    void beautifulArrayEx2() {
        int n = 5;
        int[] expectedResult = new int[]{1, 5, 3, 2, 4};

        int[] result = beautifulArray.beautifulArray(n);

        assertArrayEquals(expectedResult, result);
    }
}
