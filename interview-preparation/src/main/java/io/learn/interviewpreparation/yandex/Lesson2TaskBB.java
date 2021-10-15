package io.learn.interviewpreparation.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Lesson2TaskBB {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        String[] items = line.split(" ");
        List<Item> list = new ArrayList<>();
        for (String item : items) {
            if (item.equals("1")) {
                list.add(Item.house);
            } else if (item.equals("2")) {
                list.add(Item.shop);
            } else {
                list.add(Item.office);
            }
        }
        reader.close();
        int result = calculateMaxDistance(list);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int calculateMaxDistance(List<Item> list) {
        int maxDistance = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            Item item = list.get(i);
            if (item == Item.house) {
                int minDistance = Integer.MAX_VALUE;
                for (int j = 0; j < list.size(); j++) {
                    Item destination = list.get(j);
                    if (destination == Item.shop) {
                        int distance = Math.abs(i - j);
                        if (distance < minDistance) {
                            minDistance = distance;
                        }
                    }
                }
                if (maxDistance < minDistance) {
                    maxDistance = minDistance;
                }
            }
        }
        return maxDistance;
    }
}

enum Item {
    house, shop, office
}
