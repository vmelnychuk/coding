package io.learn.javacore.algos.leetcode;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeTwoSortedListsTest {
    private MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();

    @Test
    public void mergeTwoListsEx1() {
        String expectedResult = "[1,1,2,3,4,4]";

        ListNode four = new ListNode(4);
        ListNode two = new ListNode(2, four);
        ListNode one = new ListNode(1, two);

        ListNode four1 = new ListNode(4);
        ListNode three = new ListNode(3, four1);
        ListNode one1 = new ListNode(1, three);

        ListNode result = mergeTwoSortedLists.mergeTwoLists(one, one1);

        assertEquals(expectedResult, result.toString());
    }

    @Test
    public void mergeTwoListsEx2() {
        ListNode one = null;
        ListNode one1 = null;

        ListNode result = mergeTwoSortedLists.mergeTwoLists(one, one1);

        assertNull(result);
    }

    @Test
    public void mergeTwoListsEx3() {
        String expectedResult = "[0]";
        ListNode one = null;
        ListNode one1 = new ListNode(0);

        ListNode result = mergeTwoSortedLists.mergeTwoLists(one, one1);

        assertEquals(expectedResult, result.toString());
    }


}
