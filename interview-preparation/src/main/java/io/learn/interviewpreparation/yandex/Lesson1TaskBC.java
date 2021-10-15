package io.learn.interviewpreparation.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson1TaskBC {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        String[] nums = line.split(" ");
        int x = Integer.parseInt(nums[0]);
        int y = Integer.parseInt(nums[1]);
        int z = Integer.parseInt(nums[2]);
        reader.close();
        int result = calculateFormat(x, y, z);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int calculateFormat(int x, int y, int z) {
        if ((x < 1 || x > 31) || (y < 1 || y > 31) || (z < 1970 || z > 2069)) {
            throw new IllegalArgumentException("Not valid input");
        }
        if ((x > 12) && (y <= 12)) {
            return 1;
        } else if ((x <= 12) && (y > 12)) {
            return 1;
        } else if ((x == y) && (x < 13) && (y < 13)) {
            return 1;
        } else {
            return 0;
        }
    }


}
