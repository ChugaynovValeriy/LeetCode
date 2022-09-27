package hard;

// https://leetcode.com/problems/merge-k-sorted-lists/

import common.ListNode;

public class MergeKSortedLists_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        return divide(lists, 0, lists.length - 1);
    }

    private ListNode divide(ListNode[] lists, int first, int last) {
        if (first == last) {
            return lists[first];
        }
        return mergeLists(divide(lists, first, first + (last - first) / 2), divide(lists, first + (last - first) / 2 + 1, last));
    }

    private ListNode mergeLists(ListNode list1, ListNode list2) {
        ListNode prev;
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        if (list1.val < list2.val) {
            prev = list1;
            list1 = list1.next;
        } else {
            prev = list2;
            list2 = list2.next;
            prev.next = list1;
        }


        ListNode result = prev;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                prev = list1;
                list1 = list1.next;
            } else {
                prev.next = list2;
                prev = prev.next;
                list2 = list2.next;
                prev.next = list1;
            }
        }
        if (list2 != null) {
            prev.next = list2;
        }
        return result;
    }


    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{
                new ListNode(1, new ListNode(4, new ListNode(5))),
                new ListNode(1, new ListNode(3, new ListNode(4))),
                new ListNode(2, new ListNode(6))
        };

        MergeKSortedLists_23 x = new MergeKSortedLists_23();
        ListNode result = x.mergeKLists(lists);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
