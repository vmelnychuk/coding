package io.learn.javacore.algos.badds;

public class Queue {
    private static final int DEFAULT_CAPACITY = 10;
    private int[] elements;
    private int head;
    private int tail;

    public Queue() {
        this.elements = new int[DEFAULT_CAPACITY];
        this.head = 0;
        this.tail = 0;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public void enqueue(int element) {
        if (tail >= elements.length - 1) {
            System.out.println(String.format("Increase queue from %s to %s", elements.length, elements.length * 2));
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            this.elements = temp;
        }
        elements[tail] = element;
        tail++;
    }

    public int dequeue() {
        int element = elements[head];
        head++;
        return element;
    }

    public int size() {
        return tail - head;
    }
}
