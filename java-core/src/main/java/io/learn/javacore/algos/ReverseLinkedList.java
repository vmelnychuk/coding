// привет Василий
// Как поживаешь

package io.learn.javacore.algos;

public class ReverseLinkedList {

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.setHead(new Node(85));
        list.getHead().setNext(new Node(15));
        list.getHead().getNext().setNext(new Node(4));
        list.getHead().getNext().getNext().setNext(new Node(20));

        System.out.println("Given Linked list");
        list.printList(list.getHead());
        list.setHead(list.reverse(list.getHead()));
        System.out.println("");
        System.out.println("Reversed linked list ");
        list.printList(list.getHead());
    }
}

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}

class LinkedList {
    private Node head;

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {
        this.head = head;
    }

    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        head = prev;
        return head;
    }

    public void printList(Node head) {
        while (head != null) {
            System.out.print(head.getData() + " ");
            head.setNext(head.getNext());
        }
    }
}
