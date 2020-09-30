package MethodFirst;

class ReverseBetween {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        for (int i = 1; i < m; i++) {
            prev = curr;
            curr = curr.next;
        }

        ListNode con = prev;
        ListNode tail = curr;
        ListNode third = null;

        for (int i = m; i <= n; i++) {
            third = curr.next;
            curr.next = prev;
            prev = curr;
            curr = third;
        }
        
        if (con != null) {
            con.next = prev;
        } else {
            head = prev;
        }
        tail.next = curr;

        return head;
    }
    
    public ListNode reverseBetween2(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }

        ListNode prev = new ListNode(-1);
        ListNode curr = head;
        prev.next = curr;
        ListNode bak = prev;

        for (int i = 1; i < m; i++) {
            prev = prev.next;
            curr = curr.next;
        }

        for (int i = m; i < n; i++) {
            ListNode third = curr.next.next;
            curr.next.next = prev.next;
            prev.next = curr.next;
            curr.next = third; 
        }

        return bak.next;
    }

    private ListNode succ ;

    public ListNode reverseBegin(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        if (n == 1) {
            this.succ = head.next;
            return head;
        }
        ListNode last = reverseBegin(head.next, n - 1);
        
        head.next.next = head;
        
        head.next = succ;

        return last;
    }

    public ListNode reverseBetween3(ListNode head, int m, int n) {
        if (head == null) {
            return null;
        }
        if (m == 1) {
            return reverseBegin(head, n);
        }
        
        ListNode last = reverseBetween3(head.next, m - 1, n - 1);
        
        head.next = this.succ;

        head.next = last;

        return head;
    }
}
