package Top200;

class RotateRight {
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

    public ListNode rotateRight(ListNode head, int k) {
        ListNode curr = head;

        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        if (length <= 1) {
            return head;
        }

        k = k % length;
        if (k == 0) {
            return head;
        } 

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        curr = dummy;
        curr.next = head;

        for (int i = 1; i <= k; i++) {
            curr = curr.next;
        }

        while (curr.next != null) {
            curr = curr.next;
            prev = prev.next;
        }

        ListNode res = prev.next;
        prev.next = null;
        curr.next = head;

        return res;
    }
}
