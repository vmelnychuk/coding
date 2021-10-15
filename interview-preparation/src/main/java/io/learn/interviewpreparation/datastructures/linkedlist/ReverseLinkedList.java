package io.learn.interviewpreparation.datastructures.linkedlist;

public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        ListNode prev = null; //
        ListNode curr = head; // Initialize

        while (curr != null) {
            ListNode next = curr.next; // save next

            curr.next = prev; // reverse

            prev = curr;      //
            curr = next;      // move prev and curr
        }
        return prev;
    }

    public ListNode reverseWithRecursion(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedHead = reverseWithRecursion(head.next);
        head.next.next = head;
        head.next = null;
        return reversedHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
