package MethodFirst;

class RotateRight {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode curr = head;

        if (head == null || head.next == null) {
            return head;
        }

        while (curr != null) {
            len ++;
            curr = curr.next;
        }

        k = k % len;

        if (k == 0) {
            return head;
        }

        ListNode slow = new ListNode(-1);
        slow.next = head;
        ListNode fast = slow;

        for (int i = 1; fast != null && i <= k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;

        return newHead;
    }
    
}
