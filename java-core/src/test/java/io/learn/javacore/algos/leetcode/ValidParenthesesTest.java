package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ValidParenthesesTest {
    private ValidParentheses validParentheses = new ValidParentheses();

    @Test
    void isValidEx1() {
        String input = "()";


        boolean result = validParentheses.isValid(input);

        assertTrue(result);
    }

    @Test
    void isValidEx2() {
        String input = "()[]{}";


        boolean result = validParentheses.isValid(input);

        assertTrue(result);
    }

    @Test
    void isValidEx3() {
        String input = "(]";


        boolean result = validParentheses.isValid(input);

        assertFalse(result);
    }

    @Test
    void isValidEx4() {
        String input = "([)]";


        boolean result = validParentheses.isValid(input);

        assertFalse(result);
    }

    @Test
    void isValidEx5() {
        String input = "{[]}";


        boolean result = validParentheses.isValid(input);

        assertTrue(result);
    }

    @Test
    void isValidEx6() {
        String input = "]";


        boolean result = validParentheses.isValid(input);

        assertFalse(result);
    }
}
