package io.learn.javacore.algos.leetcode;

public class LongestPalindromicSubstring {

    private int resultStart;

    private int resultLength;

    public String longestPalindrome(String s) {
        String maxPalindrome = "";

        for (int i = 0; i <= s.length() - 1; i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (isPalindrome(substring)) {
                    if (substring.length() > maxPalindrome.length()) {
                        maxPalindrome = substring;
                    }
                }
            }
        }
        return maxPalindrome;
    }

    public String longestPalindrome1(String s) {
        int stringLength = s.length();
        if (stringLength < 2) {
            return s;
        }
        for (int i = 0; i < stringLength - 1; i++) {
            expandRange(s, i, i);
            expandRange(s, i, i + 1);
        }
        return s.substring(resultStart, resultStart + resultLength);
    }

    private void expandRange(String string, int begin, int end) {
        while (begin >= 0 && end < string.length() &&
            string.charAt(begin) == string.charAt(end)) {
            begin--;
            end++;
        }
        if (resultLength < end - begin - 1) {
            resultStart = begin + 1;
            resultLength = end - begin - 1;
        }
    }


    private boolean isPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
