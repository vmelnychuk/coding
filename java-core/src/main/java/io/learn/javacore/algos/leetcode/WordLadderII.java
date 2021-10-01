package io.learn.javacore.algos.leetcode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class WordLadderII {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> result = new ArrayList<>();
        if (!wordList.contains(endWord)) {
            return result;
        }
        ArrayList<String> workingWordList = new ArrayList<>();
        workingWordList.add(beginWord);
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distances = new HashMap<>();

        bfs(beginWord, wordList, graph, distances);
        dfs(beginWord, endWord, graph, distances, new ArrayList<>(), result);
        return result;
    }

    private void dfs(String beginWord, String endWord,
                     Map<String, List<String>> graph, Map<String, Integer> distances,
                     ArrayList<String> p, List<List<String>> paths) {
        if (beginWord.equals(endWord)) {
            List<String> path = new ArrayList<>(p);
            path.add(beginWord);
            paths.add(path);
            return;
        }
        int d = distances.get(beginWord);
        p.add(beginWord);
        for (String next : graph.get(beginWord)) {
            if (distances.get(next) == d + 1) {
                dfs(next, endWord, graph, distances, p, paths);
            }
        }
        p.remove(p.size() - 1);
    }

    private void bfs(String beginWord, List<String> wordList, Map<String, List<String>> graph, Map<String, Integer> distances) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        distances.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            graph.putIfAbsent(current, new ArrayList<>());
            int currentDistance = distances.get(current);
            List<String> neighbors = getNeighbors(current, wordList);
            for (String neighbour : neighbors) {
                graph.get(current).add(neighbour);
                if (!distances.containsKey(neighbour)) {
                    distances.put(neighbour, currentDistance + 1);
                    queue.offer(neighbour);
                }
            }
        }
    }

    private int hammingDistance(String first, String second) {
        int distance = 0;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                distance++;
            }
        }
        return distance;
    }

    private List<String> getNeighbors(String current, List<String> words) {
        List<String> result = new ArrayList<>();
        for (String word : words) {
            if (hammingDistance(current, word) == 1) {
                result.add(word);
            }
        }
        return result;
    }
}
