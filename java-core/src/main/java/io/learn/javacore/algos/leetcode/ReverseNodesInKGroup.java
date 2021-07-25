package io.learn.javacore.algos.leetcode;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        int listSize = 0;
        ListNode current = head;
        // find the length of list
        while (current != null) {
            listSize++;
            current = current.next;
        }
        // find number of groups
        int groupSize = listSize / k;
        current = head;
        ListNode previous = null;
        ListNode startCurrent = null;
        ListNode nextNode = null;
        ListNode startPrevious = null;
        // iterate trough groups
        for (int i = 0; i < groupSize; i++) {
            previous = null;
            startCurrent = current;
            // reverse group
            for (int j = 0; j < k; j++) {
                nextNode = current.next;
                current.next = previous;
                previous = current;
                current = nextNode;
            }
            if (i == 0) {
                head = previous;
            }
            if (i > 0) {
                startPrevious.next = previous;
            }
            startPrevious = startCurrent;
        }
        // add rest of list
        if (startCurrent != null) {
            startCurrent.next = current;
        }
        return head;
    }
}

class ListReverser {
    public ListNode reverse(ListNode head) {
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;
        for (; current != null; ) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }
}

class ListTransformer {
    public String makeString(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode current = head;
        while (current != null) {
            sb.append(current.val + "-");
            current = current.next;
        }
        return sb.deleteCharAt(sb.length() -1).toString();
    }
}
