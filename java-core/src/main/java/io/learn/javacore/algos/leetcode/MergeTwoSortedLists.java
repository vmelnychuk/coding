package io.learn.javacore.algos.leetcode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        ListNode current1 = l1;
        ListNode current2 = l2;

        while (current1 != null && current2 != null) {
            if (current1.val < current2.val) {
                dummy.next = current1;
                current1 = current1.next;
            } else {
                dummy.next = current2;
                current2 = current2.next;
            }
            dummy = dummy.next;
        }
        if (current1 != null) {
            dummy.next = current1;
        } else {
            dummy.next = current2;
        }
        return head.next;
    }
}
