package io.learn.javacore.algos.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParentheses {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (isOpenParentheses(current)) {
                stack.push(current);
            } else if (isCloseParentheses(current)) {
                if (stack.isEmpty()) {
                    return false;
                }
                Character saved = stack.pop();
                if (!parenthesesIsMach(saved, current)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private boolean parenthesesIsMach(Character saved, char current) {
        if ((saved == '(' && current == ')') ||
            (saved == '{' && current == '}') ||
            (saved == '[' && current == ']')) {
            return true;
        } else {
            return false;
        }
    }

    private boolean isCloseParentheses(char symbol) {
        if (symbol == ')' || symbol == '}' || symbol == ']') {
            return true;
        } else {
            return false;
        }
    }

    private boolean isOpenParentheses(char symbol) {
        if (symbol == '(' || symbol == '{' || symbol == '[') {
            return true;
        } else {
            return false;
        }
    }
}
