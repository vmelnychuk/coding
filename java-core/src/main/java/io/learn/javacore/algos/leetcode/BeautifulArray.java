package io.learn.javacore.algos.leetcode;

import java.util.ArrayList;
import java.util.List;

public class BeautifulArray {

    public int[] beautifulArray(int n) {
        List<Integer> answer = new ArrayList<>();
        answer.add(1);
        while (answer.size() < n) {
            List<Integer> temp = new ArrayList<>();
            for (int el : answer) {
                if (2 * el - 1 <= n) {
                    temp.add(el * 2 - 1);
                }
            }
            for (int el : answer) {
                if (2 * el <= n) {
                    if (2 * el <= n) {
                        temp.add(el * 2);
                    }
                }
            }
            answer = temp;
        }

        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
