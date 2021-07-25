package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LongestPalindromicSubstringTest {
    private LongestPalindromicSubstring longestPalindromicSubstring;

    @BeforeEach
    void setUp() {
        longestPalindromicSubstring = new LongestPalindromicSubstring();
    }

    @Test
    void longestPalindromeEx1() {
        String s = "babad";
        String expectedResult = "bab";

        String palindrome = longestPalindromicSubstring.longestPalindrome(s);

        assertEquals(expectedResult, palindrome);
    }

    @Test
    void longestPalindromeEx2() {
        String s = "cbbd";
        String expectedResult = "bb";

        String palindrome = longestPalindromicSubstring.longestPalindrome(s);

        assertEquals(expectedResult, palindrome);
    }

    @Test
    void longestPalindromeEx3() {
        String s = "a";
        String expectedResult = "a";

        String palindrome = longestPalindromicSubstring.longestPalindrome(s);

        assertEquals(expectedResult, palindrome);
    }

    @Test
    void longestPalindromeEx4() {
        String s = "ac";
        String expectedResult = "a";

        String palindrome = longestPalindromicSubstring.longestPalindrome(s);

        assertEquals(expectedResult, palindrome);
    }

    @Test
    void longestPalindrome1Ex1() {
        String s = "babad";
        String expectedResult = "bab";

        String palindrome = longestPalindromicSubstring.longestPalindrome1(s);

        assertEquals(expectedResult, palindrome);
    }

    @Test
    void longestPalindrome1Ex2() {
        String s = "cbbd";
        String expectedResult = "bb";

        String palindrome = longestPalindromicSubstring.longestPalindrome1(s);

        assertEquals(expectedResult, palindrome);
    }

    @Test
    void longestPalindrome1Ex3() {
        String s = "a";
        String expectedResult = "a";

        String palindrome = longestPalindromicSubstring.longestPalindrome1(s);

        assertEquals(expectedResult, palindrome);
    }

    @Test
    void longestPalindrome1Ex4() {
        String s = "ac";
        String expectedResult = "a";

        String palindrome = longestPalindromicSubstring.longestPalindrome1(s);

        assertEquals(expectedResult, palindrome);
    }
}
