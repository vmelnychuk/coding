package io.learn.javacore.algos.datastructures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LinkedListTest {
    private LinkedList list;

    @BeforeEach
    void setUp() {
        Cell third = new Cell(3);
        Cell second = new Cell(2, third);
        Cell first = new Cell(1, second);

        list = new LinkedList(first);

    }

    @Test
    void iterate() {
        list.iterate();
    }

    @Test
    void iterateWithFor() {
        list.iterateWithFor();
    }


    @Test
    void getHead() {
        Cell head = list.getHead();

        assertEquals(1, head.getValue());
    }

    @Test
    void insertAtHead() {
        Cell cell = new Cell(42);
        list.insertAtHead(cell);

        Cell head = list.getHead();

        assertEquals(42, head.getValue());
        list.iterateWithFor();
    }
}
