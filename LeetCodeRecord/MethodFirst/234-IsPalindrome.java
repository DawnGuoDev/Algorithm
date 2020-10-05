package MethodFirst;

class IsPalindrome {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }
    } 
   
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode halfHead = this.reverseList(slow);
        slow.next = null;
        
        while (halfHead != null) {
            if (halfHead.val != head.val) {
                return false;
            }

            halfHead = halfHead.next;
            head = head.next;
        }
        return true;

    }

    public ListNode reverseList(ListNode head) {
        if (head.next == null) {
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
