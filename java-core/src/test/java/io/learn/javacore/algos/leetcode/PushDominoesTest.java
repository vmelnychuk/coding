package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PushDominoesTest {

    private PushDominoes pushDominoes = new PushDominoes();

    @Test
    void pushDominoesEx1() {
        String input = "RR.L";
        String expectedResult = "RR.L";

        String result = pushDominoes.pushDominoes(input);

        assertEquals(expectedResult, result);
    }

    @Test
    void pushDominoesEx2() {
        String input = ".L.R...LR..L..";
        String expectedResult = "LL.RR.LLRRLL..";

        String result = pushDominoes.pushDominoes(input);

        assertEquals(expectedResult, result);
    }
}
