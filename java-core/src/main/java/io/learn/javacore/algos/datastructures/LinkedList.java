package io.learn.javacore.algos.datastructures;

public class LinkedList {
    private Cell head;

    public LinkedList(Cell head) {
        this.head = head;
    }

    public Cell getHead() {
        return head;
    }

    public void iterate() {
        Cell current = head;
        while (current != null) {
            System.out.println("value = " + current.getValue());
            current = current.getNext();
        }
    }

    public void iterateWithFor() {
        for (Cell current = head; current != null; current = current.getNext()) {
            System.out.println("value = " + current.getValue());
        }
    }

    public void insertAtHead(Cell newCell) {
        newCell.setNext(head);
        this.head = newCell;
    }
}
