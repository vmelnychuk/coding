package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListTransformerTest {
    private ListTransformer listTransformer = new ListTransformer();

    @Test
    public void emptyListToString() {
        ListNode head = new ListNode();

        String result = listTransformer.makeString(head);

        assertEquals("0", result);
    }

    @Test
    public void oneElementListToString() {
        ListNode head = new ListNode(1);

        String result = listTransformer.makeString(head);

        assertEquals("1", result);
    }

    @Test
    public void twoElementListToString() {
        ListNode second = new ListNode(2);
        ListNode fist = new ListNode(1, second);

        String result = listTransformer.makeString(fist);

        assertEquals("1-2", result);
    }

    @Test
    public void threeElementListToString() {
        ListNode third = new ListNode(3);
        ListNode second = new ListNode(2, third);
        ListNode fist = new ListNode(1, second);

        String result = listTransformer.makeString(fist);

        assertEquals("1-2-3", result);
    }

    @Test
    public void fourElementListToString() {
        ListNode forth = new ListNode();
        ListNode third = new ListNode(3, forth);
        ListNode second = new ListNode(2, third);
        ListNode fist = new ListNode(1, second);

        String result = listTransformer.makeString(fist);

        assertEquals("1-2-3-0", result);
    }
}
