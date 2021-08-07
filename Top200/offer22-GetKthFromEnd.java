package Top200;

class GetKthFromEnd {
    class ListNode {
        int val;
        ListNode next;
        
        ListNode() {}
        
        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = dummy;
        curr.next = head;

        for (int i = 1; i <= k; i++) {
            curr = curr.next;
        }

        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }

        return prev.next;
    }
}
