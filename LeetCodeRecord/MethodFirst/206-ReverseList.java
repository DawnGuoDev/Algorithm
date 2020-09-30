package MethodFirst;

class ReverseList {
    class ListNode {
        int val;
        ListNode  next;

        ListNode (int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode curr = head;

        while (curr.next != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        curr.next = prev;

        return curr;
    }

    public ListNode reverseList2(ListNode head) {
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

    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode ret = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return ret;
    }
    
    public ListNode reverseList4(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode curr = head;
        while (head.next != null) {
            ListNode temp = head.next.next;
            head.next.next = curr;
            curr = head.next;
            head.next = temp;
        }

        return curr;
    }
}
