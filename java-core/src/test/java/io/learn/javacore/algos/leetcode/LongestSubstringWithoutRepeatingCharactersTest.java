package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestSubstringWithoutRepeatingCharactersTest {
    private LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters;

    @BeforeEach
    void setUp() {
        longestSubstringWithoutRepeatingCharacters = new LongestSubstringWithoutRepeatingCharacters();
    }

    @Test
    void lengthOfLongestSubstringEx1() {
        String input = "abcabcbb";

        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);

        assertEquals(3, result);
    }

    @Test
    void lengthOfLongestSubstringEx2() {
        String input = "bbbbb";

        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);

        assertEquals(1, result);
    }

    @Test
    void lengthOfLongestSubstringEx3() {
        String input = "pwwkew";

        int result = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring(input);

        assertEquals(3, result);
    }
}
