package io.learn.javacore.algos.leetcode;

public class PushDominoes {

    private final char left = 'L';

    private final char right = 'R';

    private final char straight = '.';

    public String pushDominoes(String dominoes) {
        char[] chars = dominoes.toCharArray();
        StringBuilder result = new StringBuilder();
        int previousLetterIndex = -1;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (current != straight) {
                if (previousLetterIndex == -1) {
                    if (current == left) {
                        for (int j = 0; j < i; j++) {
                            chars[j] = left;
                        }
                    }
                } else {
                    char previousLetter = chars[previousLetterIndex];
                    if (previousLetter == left && current == left) {
                        for (int j = previousLetterIndex + 1; j < i; j++) {
                            chars[j] = left;
                        }
                    } else if (previousLetter == right && current == right) {
                        for (int j = previousLetterIndex + 1; j < i; j++) {
                            chars[j] = right;
                        }
                    } else if (previousLetter == right && current == left) {
                        int places = i - previousLetterIndex - 1;
                        int middle = places / 2;
                        for (int j = previousLetterIndex + 1; j <= previousLetterIndex + middle; j++) {
                            chars[j] = right;
                        }
                        for (int j = i - middle; j <= i - 1; j++) {
                            chars[j] = left;
                        }
                    }
                }
                previousLetterIndex = i;
            }
        }
        if (previousLetterIndex != -1 && chars[previousLetterIndex] == right) {
            for (int i = previousLetterIndex +1; i < chars.length; i++) {
                chars[i] = right;
            }
        }
        return result.append(chars).toString();
    }
}
