package Top200;

class ReverseList {
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

    public ListNode reverseList(ListNode head) {
        if (head == null  || head.next == null) {
            return head;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
    
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode curr = new ListNode(-1);
        curr.next = head;

        while (curr.next != null) {
            ListNode temp = curr.next.next;
            curr.next.next = prev;
            prev = curr.next;
            curr.next = temp; 
        }

        return prev;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode last = this.reverseList3(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
}
