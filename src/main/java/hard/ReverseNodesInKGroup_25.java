package hard;

// https://leetcode.com/problems/reverse-nodes-in-k-group/

import common.ListNode;

public class ReverseNodesInKGroup_25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode c1 = head;
        ListNode c2 = c1 == null ? null : c1.next;
        ListNode prev = null;

        while (c1 != null) {
            int i = 1;
            ListNode lastInGroup = c1;
            while (i < k && lastInGroup != null) {
                lastInGroup = lastInGroup.next;
                i++;
            }
            if (lastInGroup == null) {
                break;
            }
            if (c1 == head) {
                head = lastInGroup;
            }
            ListNode first = c1;
            ListNode afterLast = lastInGroup.next;
            while (c2 != afterLast) {
                ListNode temp = c2.next;
                c2.next = c1;
                c1 = c2;
                c2 = temp;
            }
            if (prev != null) {
                prev.next = c1;
            }
            prev = first;
            c1 = c2;
            c2 = c1 == null ? null : c1.next;
        }
        if (prev != null) {
            prev.next = c1;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode first1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, new ListNode(6))))));
        ReverseNodesInKGroup_25 x = new ReverseNodesInKGroup_25();

        ListNode result = x.reverseKGroup(first1, 3);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
