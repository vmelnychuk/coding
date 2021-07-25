package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReverseNodesInKGroupTest {
    private ReverseNodesInKGroup reverseNodesInKGroup;

    @BeforeEach
    void setUp() {
        reverseNodesInKGroup = new ReverseNodesInKGroup();
    }

    @Test
    void reverseKGroupOfTwo() {
        ListNode head = makeList();

        ListNode reversed = reverseNodesInKGroup.reverseKGroup(head, 2);

        assertEquals(2, reversed.val);
        assertEquals(1, reversed.next.val);
        assertEquals(4, reversed.next.next.val);
        assertEquals(3, reversed.next.next.next.val);
        assertEquals(5, reversed.next.next.next.next.val);
    }

    @Test
    void reverseKGroupOfThree() {
        ListNode head = makeList();

        ListNode reversed = reverseNodesInKGroup.reverseKGroup(head, 3);

        assertEquals(3, reversed.val);
        assertEquals(2, reversed.next.val);
        assertEquals(1, reversed.next.next.val);
        assertEquals(4, reversed.next.next.next.val);
        assertEquals(5, reversed.next.next.next.next.val);
    }

    @Test
    void reverseKGroupOfFive() {
        ListNode head = makeList();

        ListNode reversed = reverseNodesInKGroup.reverseKGroup(head, 5);

        assertEquals(5, reversed.val);
        assertEquals(4, reversed.next.val);
        assertEquals(3, reversed.next.next.val);
        assertEquals(2, reversed.next.next.next.val);
        assertEquals(1, reversed.next.next.next.next.val);
    }

    private ListNode makeList() {
        ListNode five = new ListNode(5);
        ListNode four = new ListNode(4, five);
        ListNode three = new ListNode(3, four);
        ListNode two = new ListNode(2, three);
        ListNode one = new ListNode(1, two);

        return one;
    }
}
