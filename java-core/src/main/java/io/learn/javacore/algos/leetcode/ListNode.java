package io.learn.javacore.algos.leetcode;


public class ListNode {
    int val;

    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        sb.append(this.val);
        if (next != null) {
            sb.append(",");
        }
        ListNode current = next;
        while (current != null) {
            sb.append(current.val);
            current = current.next;
            if (current != null) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();

    }
}
