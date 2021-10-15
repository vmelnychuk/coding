package io.learn.interviewpreparation.yandex;

import java.io.*;

public class Lesson1TaskBA {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("input.txt"));
        String exitCodeStr = reader.readLine();
        int exitCode = Integer.parseInt(exitCodeStr);
        String interactorCodeStr = reader.readLine();
        int interactorCode = Integer.parseInt(interactorCodeStr);
        String chekerCodeStr = reader.readLine();
        int checkerCode = Integer.parseInt(chekerCodeStr);
        reader.close();
        int result = calculateResult(exitCode, interactorCode, checkerCode);
        FileWriter writer = new FileWriter("output.txt");
        writer.write(String.valueOf(result));
        writer.flush();
    }

    private static int calculateResult(int exitCode, int interactorCode, int checkerCode) {
        if ((exitCode < -129 || exitCode > 127)
            || (interactorCode < 0 || interactorCode > 7)
            || (checkerCode < 0 || checkerCode > 7)) {
            throw new IllegalArgumentException("Code is out of range");
        }
        if (interactorCode == 0) {
            if (exitCode == 0) {
                return checkerCode;
            } else {
                return 3;
            }
        } else if (interactorCode == 1) {
            return checkerCode;
        } else if (interactorCode == 4) {
            if (exitCode == 0) {
                return 4;
            } else {
                return 3;
            }
        } else if (interactorCode == 6) {
            return 0;
        } else if (interactorCode == 7) {
            return 1;
        } else {
            return interactorCode;
        }
    }

}

