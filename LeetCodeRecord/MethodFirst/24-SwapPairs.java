package MethodFirst;

class SwapPairs {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        curr.next = head;

        while (curr.next != null && curr.next.next != null) {
            ListNode third = curr.next.next.next;
            ListNode second = curr.next.next;
            
            curr.next.next = third;
            second.next = curr.next;
            curr.next = second;
            curr = curr.next.next;
        }

        return dummy.next;
    }
    
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode res = this.swapPairs2(head.next.next);
        ListNode headNext = head.next;
        head.next = res;
        headNext.next = head;
        return headNext;
    }
}
