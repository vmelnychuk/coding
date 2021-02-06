package io.learn.javacore.inputoutput;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Main {

    public static void main(String[] args) throws IOException {
        for (String element: args) {
            System.out.println("Element: " + element);
        }
        InputStream input = null;
        input.skip(-1);
        DataInputStream dataInputStream = new DataInputStream(input);

    }
}
