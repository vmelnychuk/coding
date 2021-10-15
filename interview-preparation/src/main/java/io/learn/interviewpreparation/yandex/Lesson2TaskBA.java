package io.learn.interviewpreparation.yandex;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Lesson2TaskBA {
    public static void main(String[] args) throws IOException {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(new File("input.txt"));
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Integer number = Integer.parseInt(line);
            if (number == 0) {
                break;
            }
            list.add(number);
        }
        scanner.close();
        int result = countMax(list);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int countMax(List<Integer> list) {
        Collections.sort(list, Collections.reverseOrder());
        Integer maxElement = list.get(0);
        int count = 0;
        for (Integer num : list) {
            if (num != maxElement) {
                break;
            } else {
                count++;
            }
        }
        return count;
    }
}
