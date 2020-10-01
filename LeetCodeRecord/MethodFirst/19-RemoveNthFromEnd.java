package MethodFirst;

class RemoveNthFromEnd {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode slow = new ListNode(-1);
        ListNode bakDummyNode = slow;
        ListNode fast = slow;
        slow.next = head;

        for (int i = 1; i <= n; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return bakDummyNode.next;
    }
    
}
