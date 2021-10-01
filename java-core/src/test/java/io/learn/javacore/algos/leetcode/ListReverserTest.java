package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ListReverserTest {
    private ListReverser listReverser = new ListReverser();

    @Test
    public void reverseEmptyList() {
        ListNode emptyList = new ListNode();

        ListNode reversedList = listReverser.reverse(emptyList);

        assertEquals(reversedList, emptyList);
    }

    @Test
    public void reverseTwoElementList() {
        ListNode second = new ListNode(2);
        ListNode first = new ListNode(1, second);

        ListNode reversedList = listReverser.reverse(first);

        assertEquals(second, reversedList);
        assertEquals(first, reversedList.next);
    }

    @Test
    public void reverseThreeElementList() {
        ListNode third = new ListNode(3);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(1, second);

        ListNode reversedList = listReverser.reverse(first);

        assertEquals(third, reversedList);
        assertEquals(second, reversedList.next);
        assertEquals(first, reversedList.next.next);
    }
}
