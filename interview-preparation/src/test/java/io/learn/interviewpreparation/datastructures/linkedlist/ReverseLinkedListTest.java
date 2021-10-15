package io.learn.interviewpreparation.datastructures.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReverseLinkedListTest {
    @Test
    public void reverseList() {
        ListNode forth = new ListNode(4);
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reverseHead = reverseLinkedList.reverse(first);

        assertEquals(forth, reverseHead);
    }

    @Test
    public void revereListWithRecursion() {
        ListNode forth = new ListNode(4);
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode reverseHead = reverseLinkedList.reverseWithRecursion(first);

        assertEquals(forth, reverseHead);
        assertEquals(third, reverseHead.next);
    }
}
