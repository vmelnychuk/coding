package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class RemoveNthNodeFromEndOfListTest {

    RemoveNthNodeFromEndOfList removeNthFromEnd = new RemoveNthNodeFromEndOfList();

    @Test
    void removeNthFromEndEx1() {
        int n = 2;
        ListNode head = makeExampleList(5);
        String expectedResult = "[1,2,3,5]";

        ListNode result = removeNthFromEnd.removeNthFromEnd(head, n);

        assertEquals(expectedResult, result.toString());
    }

    @Test
    void removeNthFromEndEx2() {
        int n = 1;
        ListNode head = makeExampleList(1);

        ListNode result = removeNthFromEnd.removeNthFromEnd(head, n);

        assertNull(result);
    }

    @Test
    void removeNthFromEndEx3() {
        int n = 1;
        ListNode head = makeExampleList(2);
        String expectedResult = "[1]";

        ListNode result = removeNthFromEnd.removeNthFromEnd(head, n);

        assertEquals(expectedResult, result.toString());
    }

    private ListNode makeExampleList(int length) {
        ListNode current = null;
        for (int i = length; i > 0; i--) {
            if (i == length) {
                current = new ListNode(length);
            } else {
                current = new ListNode(i, current);
            }
        }
        return current;
    }
}
