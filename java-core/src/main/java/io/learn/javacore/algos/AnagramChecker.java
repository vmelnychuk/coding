package io.learn.javacore.algos;

import java.util.Objects;

public class AnagramChecker {

    public boolean check(String first, String second) {
        if (Objects.isNull(first) && Objects.isNull(second)) {
            return true;
        }
        if (Objects.isNull(first)) {
            return false;
        }
        if (first.equals(second)) {
            return true;
        }

        return false;
    }
}
