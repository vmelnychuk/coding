package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class WordLadderIITest {

    private WordLadderII wordLadderII = new WordLadderII();

    @BeforeEach
    void setUp() {
    }

    @Test
    void findLaddersEx1() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
        List<List<String>> expectedResult = Arrays.asList(
            Arrays.asList("hit", "hot", "dot", "dog", "cog"),
            Arrays.asList("hit", "hot", "lot", "log", "cog")
        );

        List<List<String>> result = wordLadderII.findLadders(beginWord, endWord, wordList);

        assertTrue(expectedResult.size() == result.size() && expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }

    @Test
    void findLaddersEx2() {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot", "dot", "dog", "lot", "log");
        List<List<String>> expectedResult = Arrays.asList();

        List<List<String>> result = wordLadderII.findLadders(beginWord, endWord, wordList);

        assertTrue(expectedResult.size() == result.size() && expectedResult.containsAll(result) && result.containsAll(expectedResult));
    }
}
