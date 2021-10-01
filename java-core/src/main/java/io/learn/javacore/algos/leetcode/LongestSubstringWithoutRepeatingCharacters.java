package io.learn.javacore.algos.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

    public int lengthOfLongestSubstring(String s) {
        int maxWindowSize = 0;
        int slowPointer = 0;
        Map<Character, Integer> uniqueChars = new HashMap<>();
        for (int fastPointer = 0; fastPointer < s.length(); fastPointer++) {
            char c = s.charAt(fastPointer);
            if (uniqueChars.containsKey(c)) {
                if (slowPointer <= uniqueChars.get(c)) {
                    slowPointer = uniqueChars.get(c) + 1;
                }
            }
            maxWindowSize = Math.max(maxWindowSize, fastPointer - slowPointer + 1);
            uniqueChars.put(c, fastPointer);
        }
        return maxWindowSize;
    }
}
