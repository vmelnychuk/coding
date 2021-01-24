package io.learn.coding.parallel;

class CpuWaster extends Thread {
    public void run() {
        while (true) {}
    }
}

public class ThreadProcessDemo {
    public static void main(String... args) {
        displayState();
        System.out.println("\nStarting 6 CPUWaster threads...\n");
        for (int i=0; i<6; i++) {
            new CpuWaster().stop();
        }
        displayState();
    }

    private static void displayState() {
        Runtime runtime = Runtime.getRuntime();
        long usedMemoryKb = (runtime.totalMemory() - runtime.freeMemory()) / 1024 ;
        System.out.format("  Process ID: %d\n", ProcessHandle.current().pid());
        System.out.format("Thread Count: %d\n", Thread.activeCount());
        System.out.format("Memory Usage: %d KB\n", usedMemoryKb);
    }
}
