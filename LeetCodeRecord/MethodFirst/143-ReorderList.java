package MethodFirst;

class ReorderList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }
    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null  || head.next.next == null) {
            return;
        }

        ListNode slow = head;
        ListNode fast = head;

        // slow 指的是中点的位置
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // 反转中点之后的链表
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // prev 是反转之后的链表

        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = head.next;
            head.next = prev;
            head = prev.next;
            prev = temp;
        }
    }
    
}
