package io.learn.javacore.algos.badds;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class QueueTest {
    @Test
    @DisplayName("Test creation and enqueue and dequeue of one element")
    public void creationAndEnqueueDequeue() {
        int element = 1;
        Queue queue = new Queue();
        queue.enqueue(element);
        int savedElement = queue.dequeue();

        assertEquals(element, savedElement);
        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("Test several enquue and dequue")
    public void severalEnqueueAndDequeue() {
        Queue queue = new Queue();
        int size = 1000;
        for (int i = 0; i < size; i++) {
            queue.enqueue(i);
        }

        assertEquals(size, queue.size());

        for (int i = 0; i < size; i++) {
            queue.dequeue();
        }

        assertTrue(queue.isEmpty());
    }

    @Test
    @DisplayName("size of one")
    public void size() {
        Queue queue = new Queue();
        queue.enqueue(1);

        assertEquals(1, queue.size());
    }

    @Test
    @DisplayName("size of empty")
    public void sizeOfEmpty() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.dequeue();

        assertEquals(0, queue.size());
    }

}
