package io.learn.interviewpreparation.bigo;

public class Functions {
    int calls = 0;

    public int f(int n) {
        calls++;
        if (n <= 1) {
            return 1;
        }
        return f(n - 1) + f(n - 1);
    }

    public int sum(int n) {
        if (n <= 0) {
            return 0;
        }
        return n + sum(n - 1);
    }

    public void printUnorderedPairs(int[] array) {
        for (int i = 0; i < array.length; i++) {
            calls++;
            for (int j = i + 1; j < array.length; j++) {
                calls++;
                System.out.print(array[i] + "," + array[j] + " ");
            }
            System.out.println();
        }
    }

    public void reverse(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            calls++;
            int endIndex = array.length - 1 - i;
            int temp = array[i];
            array[i] = array[endIndex];
            array[endIndex] = temp;
        }
    }
}
