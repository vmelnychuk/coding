package io.learn.coding.parallel;

class VegetableChopper extends Thread {

    public int vegetableCount = 0;
    public static boolean chopping = true;

    public VegetableChopper(String name) {
        this.setName(name);
    }

    public void run() {
        while(chopping) {
            System.out.println(this.getName() + " chopped a vegetable!");
            vegetableCount++;
        }
    }
}

public class ExecutionSchedulingDemo {
    public static void main(String args[]) throws InterruptedException {
        VegetableChopper barron = new VegetableChopper("Barron");
        VegetableChopper olivia = new VegetableChopper("Olivia");

        barron.start();
        olivia.start();
        Thread.sleep(1000);
        VegetableChopper.chopping = false;

        barron.join();
        olivia.join();
        System.out.format("%s chopped %d vegetables.\n", barron.getName(), barron.vegetableCount);
        System.out.format("%s chopped %d vegetables.\n", olivia.getName(), olivia.vegetableCount);
    }
}
