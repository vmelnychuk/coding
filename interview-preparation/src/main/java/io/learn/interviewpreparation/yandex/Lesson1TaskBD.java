package io.learn.interviewpreparation.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson1TaskBD {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        int n = Integer.parseInt(line);
        String coordinates = reader.readLine();
        String[] cords = coordinates.split(" ");
        int[] array = new int[cords.length];
        for (int i = 0; i < cords.length; i++) {
            array[i] = Integer.parseInt(cords[i]);
        }
        reader.close();
        int result = calculateLocation(n, array);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int calculateLocation(int n, int[] array) {
        int minDistance = 0;
        int location = array[0];
        for (int i = 0; i < n; i++) {
            minDistance += Math.abs(array[i] - location);
        }
        for (int i = 1; i < n; i++) {
            int currentDistance = 0;
            int currentLocation = array[i];
            for (int j = 0; j < n; j++) {
                currentDistance += Math.abs(array[j] - currentLocation);
            }
            if (currentDistance < minDistance) {
                location = currentLocation;
                minDistance = currentDistance;
            }
        }
        return location;
    }
}
