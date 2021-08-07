package Top200;

class RemoveNthFromEnd {
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

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = dummy;
        curr.next = head;

        for (int i = 1; i <= n; i++) {
            curr = curr.next;
        }        

        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }

        prev.next = prev.next.next;

        return dummy.next;
    }
    
}
