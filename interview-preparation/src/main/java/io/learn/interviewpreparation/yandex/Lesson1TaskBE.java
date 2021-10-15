package io.learn.interviewpreparation.yandex;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Lesson1TaskBE {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String line = reader.readLine();
        int d = Integer.parseInt(line);
        String coordinates = reader.readLine();
        String[] cords = coordinates.split(" ");
        int x = Integer.parseInt(cords[0]);
        int y = Integer.parseInt(cords[1]);
        Point pointX = new Point(x, y);
        reader.close();
        int result = calculateLocation(d, pointX);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int calculateLocation(int d, Point pointX) {
        Point a = new Point(0,0);
        Point b = new Point(d, 0);
        Point c = new Point(0, d);

        int ka = (a.x - pointX.x) * (b.y - a.y) - (b.x - a.x) * (a.y - pointX.y);
        int kb = (b.x - pointX.x) * (c.y - b.y) - (c.x - b.x) * (b.y - pointX.y);
        int kc = (c.x - pointX.x) * (a.y - c.y) - (a.x - c.x) * (c.y - pointX.y);

        if ((ka < 0 && kb < 0 && kc < 0) || (ka > 0 && kb > 0 && kc > 0)) {
            return 0;
        } else if (ka == 0 || kb == 0 || kc == 0) {
            return 0;
        } else {
            double distA = Math.sqrt(Math.pow(a.x - pointX.x, 2) + Math.pow(a.y - pointX.y, 2));
            double distB = Math.sqrt(Math.pow(b.x - pointX.x, 2) + Math.pow(b.y - pointX.y, 2));
            double distC = Math.sqrt(Math.pow(c.x - pointX.x, 2) + Math.pow(c.y - pointX.y, 2));

            if ((distA < distB && distA < distC)
                || ((distA == distB) && distA < distC)
                || ((distA == distC) && distA < distB)) {
                return 1;
            } else if ((distB < distA && distB < distC)
                || ((distB == distC) && distB < distA)) {
                return 2;
            } else if (distC < distA && distC < distB) {
                return 3;
            }
        }
        return 0;
    }
}

class Point {
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
