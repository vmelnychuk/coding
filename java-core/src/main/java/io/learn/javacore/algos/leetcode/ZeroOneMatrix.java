package io.learn.javacore.algos.leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class ZeroOneMatrix {

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        final int[][] directions = {
            {0, 1},
            {0, -1},
            {1, 0},
            {-1, 0}
        };

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] current = q.poll();
                int currentX = current[0];
                int currentY = current[1];
                for (int[] dir : directions) {
                    int x = currentX + dir[0];
                    int y = currentY + dir[1];
                    if (x < 0 || x > m - 1 || y < 0 || y > n - 1 || visited[x][y]) {
                        continue;
                    }
                    mat[x][y] = mat[currentX][currentY] + 1;
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return mat;
    }
}
