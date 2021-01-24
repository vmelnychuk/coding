package io.learn.coding.algos;

public class EuclidGcd {

    public int calculate(int m, int n) {
        if (m == 0) {
            return n;
        } else if (n == 0) {
            return m;
        }
        if (m > n) {
            int remainder = m % n;
            if (remainder == 0) {
                return n;
            } else {
                return calculate(n, remainder);
            }
        } else {
            int remainder = n % m;
            if (remainder == 0) {
                return m;
            } else {
                return calculate(m, remainder);
            }
        }
    }
}
