package Top200;

class ReorderList {
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

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode slow = dummy;
        ListNode fast = dummy;
        ListNode curr = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode reverseBegin = slow.next;
        slow.next = null;
        
        reverseBegin = this.reverseList(reverseBegin);

        while (reverseBegin != null) {
            ListNode temp = reverseBegin.next;
            reverseBegin.next = curr.next;
            curr.next = reverseBegin;
            curr = reverseBegin.next;
            reverseBegin = temp;
        }
    }

    // 翻转链表
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
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
}
