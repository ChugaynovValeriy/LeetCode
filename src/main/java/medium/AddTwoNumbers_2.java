package medium;

// https://leetcode.com/problems/add-two-numbers/

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean upDigit = false;
        ListNode curNode = new ListNode();
        ListNode result = curNode;
        while (l1 != null || l2 != null) {
            curNode.next = new ListNode();
            curNode = curNode.next;
            int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + (upDigit ? 1 : 0);
            curNode.val = sum % 10;
            upDigit = sum > 9;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }

        if (upDigit) {
            curNode.next = new ListNode();
            curNode = curNode.next;
            curNode.val = 1;
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode first1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode first2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        AddTwoNumbers_2 x = new AddTwoNumbers_2();
        ListNode result = x.addTwoNumbers(first1, first2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
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
}
