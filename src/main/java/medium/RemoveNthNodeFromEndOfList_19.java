package medium;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

import common.ListNode;

import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndOfList_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> list = new ArrayList<>(30);
        if (head == null) {
            return null;
        }
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        if (n == list.size()) {
            return list.get(0).next;
        }

        ListNode prev = list.get(list.size() - n - 1);
        prev.next = prev.next.next;
        return list.get(0);
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        RemoveNthNodeFromEndOfList_19 x = new RemoveNthNodeFromEndOfList_19();
        ListNode result = x.removeNthFromEnd(head, 1);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
