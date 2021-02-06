package io.learn.javacore.algos;

public class Sqrt {

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        double sqrtOf2 = sqrt.sqrt(0.25);
        System.out.println(sqrtOf2);
    }

    private double sqrt(double number) {
        if (number == 0) {
            return 0;
        }
        double last = 0;
        double res = 1.0;
        while (res != last) {
            last = res;
            res = (res + number / res) / 2;
        }
        return res;
    }
}
