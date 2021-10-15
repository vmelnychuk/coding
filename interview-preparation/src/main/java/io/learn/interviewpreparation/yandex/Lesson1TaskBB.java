package io.learn.interviewpreparation.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson1TaskBB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        String[] nums = line.split(" ");
        int n = Integer.parseInt(nums[0]);
        int i = Integer.parseInt(nums[1]);
        int j = Integer.parseInt(nums[2]);
        reader.close();
        int result = calculateMinStations(n, i, j);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int calculateMinStations(int n, int i, int j) {
        if ((n > 100) || (i < 1 || i > n) || (j < 1 || j > n)) {
            throw new IllegalArgumentException("Input is not valid");
        }
        int rightSteps = 0;
        int rightStart = i;
        int leftSteps = 0;
        int leftStart = i;
        while (rightStart != j) {
            rightStart++;
            rightSteps++;
            if (rightStart > n) {
                rightStart %= n;
            }
        }
        while (leftStart != j) {
            leftStart--;
            leftSteps++;
            if (leftStart == 0) {
                leftStart = n;
            }
        }
        return Math.min(rightSteps - 1, leftSteps - 1);
    }


}

/**
 * 1 2 3 4 5 6 7 8 9 10
 * ^               ^
 * ->
 *
 *
 *
 * **/
