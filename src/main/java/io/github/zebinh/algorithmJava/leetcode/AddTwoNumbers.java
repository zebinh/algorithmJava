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
        int sum = l1.val + l2.val;
        ListNode head = new ListNode(sum % 10);
        int highBit = sum / 10;
        ListNode newCur = head;
        ListNode i = l1.next;
        ListNode j = l2.next;
        while (i != null && j != null) {
            sum = i.val + j.val;
            ListNode newNode = new ListNode((sum+highBit) % 10);
            newCur.next = newNode;
            newCur = newNode;
            highBit = (sum + highBit) / 10;
            i = i.next;
            j = j.next;
        }
        while (i != null) {
            ListNode newNode = new ListNode((i.val+highBit) % 10);
            newCur.next = newNode;
            newCur = newNode;
            highBit = (i.val+highBit) / 10;
            i = i.next;
        }
        while (j != null) {
            ListNode newNode = new ListNode((j.val+highBit) % 10);
            newCur.next = newNode;
            newCur = newNode;
            highBit = (j.val+highBit) / 10;
            j = j.next;
        }
        if (highBit == 1) {
            ListNode newNode = new ListNode(highBit);
            newCur.next = newNode;
        }
        return head;
    }
}
