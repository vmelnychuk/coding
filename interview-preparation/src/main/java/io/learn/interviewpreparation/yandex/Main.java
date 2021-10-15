package io.learn.interviewpreparation.yandex;

import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        try (
            Scanner in = new Scanner(System.in);
            PrintWriter out = new PrintWriter(System.out)
        ) {
            solve(in, out);
        }
    }

    private void solve(Scanner in, PrintWriter out) {
        int a = in.nextInt();
        int b = in.nextInt();
        int sum = a + b;
        out.println(sum);
    }
}
