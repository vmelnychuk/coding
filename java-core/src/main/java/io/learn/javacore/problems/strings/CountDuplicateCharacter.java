package io.learn.javacore.problems.strings;

import java.util.HashMap;
import java.util.Map;

public class CountDuplicateCharacter {
    private CountDuplicateCharacter() {
        throw new AssertionError("Cannot be instantiated");
    }

    public static Map<Character, Integer> countDuplicateCharacters(String string) {
        Map<Character, Integer> result = new HashMap<>();
        for (char c : string.toCharArray()) {
            if (result.containsKey(c)) {
                Integer value = result.get(c);
                value++;
                result.put(c, value);
            } else {
                result.put(c, 1);
            }
        }
        return result;
    }
}
