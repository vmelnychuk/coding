package io.learn.javacore.algos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnagramCheckerTest {
    private AnagramChecker anagramChecker = new AnagramChecker();

    @Test
    @DisplayName("should return true when two words are same")
    void shouldReturnTrueWhenTwoWordsAreSame() {
        boolean result = anagramChecker.check("first", "first");

        assertTrue(result);
    }

    @Test
    @DisplayName("should return true when two words are null")
    void shouldReturnTrueWhenTwoWordsAreNull() {
        boolean result = anagramChecker.check(null, null);

        assertTrue(result);
    }

    @Test
    @DisplayName("should return false when one word is null")
    void shouldReturnFalseWhenOneWordIsNull() {
        boolean result = anagramChecker.check(null, "some");

        assertFalse(result);
    }
}
