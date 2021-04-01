package com.tata.learn.数据结构.链表;

/**
 * @Decription:
 * @Author: Terry
 * @Date: 2/23/21
 * @Time: 8:50 PM
 */
public class ListNode_Level_Medium {
    /**
     * 删除链表的倒数第 N 个结点
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n < 0) {// 注意这里
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode fast = head;
        ListNode slow = dummy;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }

    /**
     * 排序链表
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        return null;
    }

    /**
     * 两数相加
     * https://leetcode-cn.com/problems/add-two-numbers/
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        int carry = 0;
        while (l1 != null || l2 != null) {
            // 1. 分别计算l1，l2的值
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int sum = v1 + v2 + carry;

            carry = sum / 10;// 计算进位
            sum = sum % 10;// 计算余数

            cur.next = new ListNode(sum);
            cur = cur.next;

            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }

        if (carry > 0) {
            cur.next = new ListNode(carry);
        }
        return dummy.next;
    }

    public ListNode mergeKListNode(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode prev = null;
        for (ListNode list : lists) {
            prev = mergeTwoLists(list, prev);
        }
        return prev;
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        cur.next = l1 == null ? l2 : l1;
        return dummy.next;
    }
}
