package io.learn.coding.problems.strings;


import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Map;

import org.hamcrest.collection.IsMapContaining;
import org.junit.jupiter.api.Test;

class CountDuplicateCharacterTest {

    @Test
    public void countCharacters() {
        String text = "abcdabcda";
        Map<Character, Integer> duplicates = CountDuplicateCharacter.countDuplicateCharacters(text);
        assertThat(duplicates, IsMapContaining.hasEntry('a', 3));
    }
}
