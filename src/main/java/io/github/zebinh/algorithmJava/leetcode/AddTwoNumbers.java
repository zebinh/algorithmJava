package io.github.zebinh.algorithmJava.leetcode;

import java.util.List;

/**
 * leetcode 第2题
 * 两数之和
 */


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curNode = head, i = l1, j = l2;
        int carry = 0;
        while (i != null || j != null) {
            int v1 = i == null ? 0 : i.val;
            int v2 = j == null ? 0 : j.val;
            int sum = carry + v1 + v2;
            ListNode newNode = new ListNode(sum % 10);
            curNode.next = newNode;
            curNode = newNode;
            carry = sum / 10;
            if (i != null){
                i = i.next;
            }
            if (j != null){
                j = j.next;
            }
        }
        if (carry > 0) {
            curNode.next = new ListNode(carry);
        }
        return head.next;
    }
}
