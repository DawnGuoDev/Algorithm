package MethodFirst;

class DeleteNode {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public ListNode deleteNode(ListNode head, int val) {
        ListNode prev = new ListNode(-1);
        ListNode bak = prev;
        prev.next = head;

        while (prev.next != null && prev.next.val != val) {
            prev = prev.next;            
        }

        if (prev.next != null && prev.next.val == val) {
            prev.next = prev.next.next;
        }

        return bak.next;
    }
}
