package ACFirst;

class SwapPairs {
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

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        ListNode curr = head;
        prev.next = head;

        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            curr.next = prev.next.next;
            prev.next.next = curr;
            prev = curr;
            curr = curr.next;
        }

        return dummy.next;
    }

    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ret = this.swapPairs2(head.next.next);
        ListNode temp = head.next;

        head.next.next = head;
        head.next = ret;

        return temp;
    }
}
