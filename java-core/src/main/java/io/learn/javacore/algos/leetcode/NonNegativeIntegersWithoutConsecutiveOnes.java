package io.learn.javacore.algos.leetcode;

public class NonNegativeIntegersWithoutConsecutiveOnes {
    public int findIntegers(int num) {
        if (num < 0) {
            return 0;
        }

        StringBuilder sb = new StringBuilder();
        while (num > 0) {
            if ((num & 1) == 1) {
                sb.append(1);
            }
            else {
                sb.append(0);
            }
            num >>>= 1;
        }
        String bit = sb.toString();
        int n = bit.length();
        int[] ones = new int[n];
        int[] zeroes = new int[n];
        ones[0] = 1;
        zeroes[0] = 1;
        for (int i = 1; i < n; i++) {
            zeroes[i] = ones[i - 1] + zeroes[i - 1];
            ones[i] = zeroes[i - 1];
        }
        int total = ones[n - 1] + zeroes[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (bit.charAt(i) == '1' && bit.charAt(i + 1) == '1') break;
            if (bit.charAt(i) == '0' && bit.charAt(i + 1) == '0') total -= ones[i];
        }
        return total;
    }
}
