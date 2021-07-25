package io.learn.javacore.algos.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomSortString {

    public String customSortString(String order, String str) {
        Map<Character, Integer> orderMap = makeOrderMap(order);
        List<StringBuilder> resultList = new ArrayList<>(orderMap.size());
        for (int i = 0; i < orderMap.size(); i++) {
            resultList.add(new StringBuilder());
        }
        StringBuilder tail = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char symbol = str.charAt(i);
            if (orderMap.containsKey(symbol)) {
                int placeInOrder = orderMap.get(symbol);
                StringBuilder stringHolder = resultList.get(placeInOrder);
                stringHolder.append(symbol);
            } else {
                tail.append(symbol);
            }
        }

        String resultString = String.join("", resultList);
        return tail.append(resultString).toString();
    }

    private Map<Character, Integer> makeOrderMap(String order) {
        Map<Character, Integer> orderMap = new HashMap<>();
        for (int i = 0; i < order.length(); i++) {
            orderMap.put(order.charAt(i), i);
        }
        return orderMap;
    }

    public static void main(String[] args) {
        CustomSortString customSortString = new CustomSortString();
        String res = customSortString.customSortString("cba", "abcd");
        System.out.println(res);
    }
}
