package io.learn.javacore.ccspj.smallproblems;

import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci Sequence
 * Starts from 0, 1
 * fib(n)  = fib(n-1) + fib(n - 2)
 */
public class Fibonacci {

    private Map<Long, Long> memo = new HashMap<>(Map.of(0L, 0L, 1L, 1L));

    public int fib1(int n) {
        if (n < 2) {
            return n;
        }
        int result = fib1(n - 1) + fib1(n - 2);
        if (result < 0) {
            throw new IllegalArgumentException(n + " is too big number to fit in int ");
        }
        return result;
    }

    public long fib2(long n) {
        if (!memo.containsKey(n)) {
            long number = fib2(n - 1) + fib2(n - 2);
            if (number < 0) {
                throw new IllegalArgumentException(n + " is too big number to fit in long ");
            }
            memo.put(n, number);
        }
        return memo.get(n);
    }

    public int fib3(int n) {
        int last = 0;
        int next = 1;
        for (int i = 0; i < n; i++) {
            int oldLast = last;
            last = next;
            next = oldLast + next;
        }
        return last;
    }
}
