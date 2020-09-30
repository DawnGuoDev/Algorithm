package MethodFirst;
    

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class GetKthFromEnd {
    private int k = 0;
    private ListNode res = null;

    public ListNode getKthFromEnd(ListNode head, int k) {
        this.k = k;
        recur(head);

        return this.res;    
    }

    public void recur(ListNode head) {
        if (head == null) {
            return;
        }

        recur(head.next);

        if (this.k == 0) {
            return;
        }

        if (--this.k == 0) {
            this.res = head;
        }
    }
    
    public ListNode getKthFromEnd2(ListNode head, int k) {
        ListNode prev = head;
        ListNode latter = head;

        for (int i = 1; latter != null && i <= k ; i++) {
            latter = latter.next;
        }
    
        while (latter != null) {
            prev = prev.next;
            latter = latter.next;            
        }

        return prev;
    }
}
