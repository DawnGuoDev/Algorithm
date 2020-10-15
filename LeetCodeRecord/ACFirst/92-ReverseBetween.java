package ACFirst;

class ReverseBetween {
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
    
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        curr.next = head;

        for (int i = 1; i < m; i++) {
            curr = curr.next;
        }

        ListNode prev = null;
        ListNode tail = curr.next;
        
        for (int i = 0; i <= n - m; i++) {
            ListNode temp = tail.next;
            tail.next = prev;
            prev = tail;
            tail = temp;
        }

        curr.next.next = tail;
        curr.next = prev;

        return dummy.next;
    }

    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        curr.next = head;

        for (int i = 1; i < m; i++) {
            curr = curr.next;
        }

        ListNode prev = curr;
        curr = curr.next;

        for (int i = 1; i <= n - m; i++) {
            ListNode temp1Node = curr.next.next;
            ListNode temp2Node = curr.next;
            curr.next.next = prev.next;
            prev.next = temp2Node;
            curr.next = temp1Node;
        }

        return dummy.next;
    }


    private ListNode tailNext = null;

    public ListNode reverseBegin(ListNode head, int len) {
        if (head == null || head.next == null) {
            return head;
        }

        if (len == 1) {
            tailNext = head.next;
            return head;
        }

        ListNode ret = this.reverseBegin(head.next, len - 1);
        head.next.next =  head;
        head.next = tailNext;

        return ret;

    }

    public ListNode reverseBetween3(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }

        if (m == n) {
            return head;
        }

        if (m == 1) {
            return this.reverseBegin(head, n);
        }

        ListNode ret = this.reverseBetween3(head.next, m - 1, n - 1);
        
        head.next = ret;

        return head;
    }
}
