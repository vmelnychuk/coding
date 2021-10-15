package io.learn.interviewpreparation.yandex;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Lesson2TaskBC {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt"));
        String line = scanner.nextLine();
        scanner.close();
        int result = countPrice(line);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int countPrice(String line) {
        int price = 0;
        if (line.length() == 1) {
            return price;
        }
        int length = line.length();
        for (int i = 0; i < length / 2; i++) {
            if (line.charAt(i) != line.charAt(length - i - 1)) {
                price++;
            }
        }
        return price;
    }
}
