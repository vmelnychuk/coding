package io.learn.javacore.algos.datastructures;

public class Cell {
    private int value;
    private Cell next;

    public Cell(int value) {
        this.value = value;
    }

    public Cell(int value, Cell next) {
        this.value = value;
        this.next = next;
    }

    public int getValue() {
        return value;
    }

    public Cell getNext() {
        return next;
    }

    public void setNext(Cell cell) {
        this.next = cell;
    }
}
